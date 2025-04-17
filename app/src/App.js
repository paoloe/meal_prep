import './App.css';
import {useEffect, useState} from "react";
 
 export default function App() {
  const [isDataFetched, setIsDataFetched] = useState(false);
  const [todos, setTodos] = useState([]);

  async function getTodos() {
    try {
      const res = await fetch(`/api/v1/recipe/getAllRecipe/`);
      const todos = await res.json();
      setTodos(todos);
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

  return (
    <div>
      <ul>
        {todos.map((todoItem, index) => (
          <li key={index}>{todoItem.recipeName}: {todoItem.recipeIngredient}</li>
        ))}
      </ul>
    </div>
  );
}