import "./App.css";
import { useEffect, useState, useLayoutEffect } from "react";
import Calendar from "./Components/Calendar";
import Dnd from "./Components/Dnd";

export default function App() {
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

  function addRecipe(id) {
    const y = api;
    const j = id;
    const i = ",";
    const x = y.concat(j, i);
    setApi(x);
    console.log(x);
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
      setRecipeId(opt);
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <div className="App">
      <Dnd />
    </div>
  );
}
