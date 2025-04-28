import "./App.css";
import { useEffect, useState, useLayoutEffect } from "react";

export default function App() {
  const [isDataFetched, setIsDataFetched] = useState(false);
  const [todos, setTodos] = useState([]);
  const [recipeId, setRecipeId] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [api, setApi] = useState("http://localhost:8080/api/v1/list/getList/");

  //dark theme
  useLayoutEffect(() => {
    document.body.style.backgroundColor = "black";
  });

  async function getTodos() {
    try {
      const res = await fetch(`/api/v1/recipe/getAllRecipe/`);
      const todos = await res.json();
      setTodos(todos);
      console.log(todos);
    } catch (err) {
      console.error(err);
    }
  }

  function handleClick() {
    setIsDataFetched(!isDataFetched);
    getTodos();
  }

  if (!isDataFetched) {
    return <button onClick={handleClick}>Get Todo List</button>;
  }

  if (todos.length === 0) {
    return <p>Loading...</p>;
  }

  if (selectedCategory !== "All") {
    addRecipe(selectedCategory);
  }

  function addRecipe(id) {
    const y = api;
    const j = id;
    const i = ",";
    const x = y.concat(j, i);
    setApi(x);
    console.log(x);
    // recipeId.concat(recipeId, id);
    // setRecipeId(recipeId);
    // console.log(recipeId);
  }

  async function getIngredients() {
    const str = api.slice(0, -1); //trim the additional comma at the end
    try {
      const res = await fetch(str);
      const opt = await res.json();
      console.log(opt);
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <div>
      <select onChange={(e) => addRecipe(e.target.value.toString())}>
        <option>Monday</option>
        {todos.map((item) => (
          <option value={item.id}>{item.recipeName}</option>
        ))}
      </select>
      <button onClick={getIngredients}>Get Ingredients</button>
    </div>
  );
}
