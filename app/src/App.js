import "./App.css";
import { useEffect, useState, useLayoutEffect } from "react";
import Calendar from "./Components/Calendar";

export default function App() {
  const [isDataFetched, setIsDataFetched] = useState(false);
  const [todos, setTodos] = useState([]);
  const [recipeId, setRecipeId] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [api, setApi] = useState("http://localhost:8080/api/v1/list/getList/");
  const daysOfWeek = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday",
  ];
  const [showDetails, setShowDetails] = useState(false);
  const [data, setData] = useState(null);

  const showDetailsHandle = (dayStr) => {
    setData(dayStr);
    setShowDetails(true);
  };

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

  function testPost(){
    const data = {
      recipeName: "TestRecipe",
      recipeIngredient:"TestIngredient1,TestIngredient2"
    };

    fetch("/api/v1/recipe/addNewRecipe/", {
      method: "POST",
      headers: {
        'Accept': 'application/json',
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => console.log(data))
      .catch((error) => console.error(error));
  }

  async function getIngredients() {
    const str = api.slice(0, -1); //trim the additional comma at the end
    try {
      const res = await fetch(str);
      const opt = await res.json();
      console.log(opt);
      // recipeId = opt;
      setRecipeId(opt);
    } catch (err) {
      console.log(err);
    }
  }

  const daysOfWeekSelect = () => {
    return (
      daysOfWeek.map((day) => (
        <select onChange={(e) => addRecipe(e.target.value.toString())}>
          <option value={day}>{day}</option>
          {todos.map((item) => (
            <option value={item.id}>{item.recipeName}</option>
          ))}
        </select>
      ))
      ); 
    }

  return (
    <div className="App">
      {/* <header className="App-header">
        <p>Weekly Meal Planner</p>
      </header> */}
      {/* {daysOfWeekSelect()} */}
      <ul>
        {recipeId.map((ingredient) => (
          <li>
            {ingredient.item}:{ingredient.quantity}
          </li>
        ))}
      </ul>
      <button className="btnGet" onClick={testPost}>Test Add Recipe</button>
      <button className="btnGet" onClick={getIngredients}>Get Ingredients</button>
      <br/>
      <Calendar showDetailsHandle={showDetailsHandle} />
      {/* {showDetails && <Details data={data} />} */}
    </div>
  );
}
