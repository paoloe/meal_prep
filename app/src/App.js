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
      <select value={todos}
        onChange={(e) => todos(e.target.value)}
        className='product-dropdown'
        name='product-dropdown'>
          <option value="">All</option>
          {todos.map((item) => (
            <option value={item.recipeName}>{item.recipeName}</option>
          ))}
        </select>
    </div>
  );
}