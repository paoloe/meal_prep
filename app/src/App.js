import './App.css';
import {useEffect, useState, useLayoutEffect} from "react";
 
 export default function App() {
  const [isDataFetched, setIsDataFetched] = useState(false);
  const [todos, setTodos] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("All");
  let recipeId = [];
  var x = "http://localhost:8080/api/v1/list/getList/";

  //dark theme
  useLayoutEffect(() => {
    document.body.style.backgroundColor = "black";
  })

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

  function addRecipe(id){
    if (recipeId.includes(id)){
      recipeId = recipeId.filter(ids => ids!=id);
    } else{
      recipeId.push(id);
    }
    console.log(recipeId);
  }

  return (
    <div>
      <select value={todos}
        onChange={(e) => setSelectedCategory(e.target.value)}
        className='product-dropdown'
        name='product-dropdown'>
          <option value="">Select Recipe</option>
          {todos.map((item) => (
            <option value={item.id}>{item.recipeName}</option>
          ))}
        </select>
    </div>
  );
}