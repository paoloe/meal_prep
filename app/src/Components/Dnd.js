import React, { useState } from "react";
import "./Dnd.css";

export default function Dnd() {
  const groups = [
    "Recipe",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday",
  ];
  const [items, setitems] = useState([]);
  const [dragging, setDragging] = useState();
  const [todos, setTodos] = useState([]);
  const [api, setApi] = useState("http://localhost:8080/api/v1/list/getList/");
  const [ingredients, setIngredients] = useState([]);

  const handleDragStart = (e) => {
    setDragging(e.target);
  };

  const onDragEnter = (e, group) => {
    // Create a new array by mapping over the existing items
    const updatedItems = items.map((item, index) => {
      // Check if the current item is the one being dragged
      if (index === dragging.id - 1) {
        // Return a new object with the updated group
        return { ...item, group: group };
      }
      // Return the item unchanged if it's not the one being dragged
      return item;
    });

    // Update the state with the new array
    setitems(updatedItems);
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

  async function getIngredients() {
    try {
      const res = await fetch(api);
      const ingredients = await res.json();
      setIngredients(ingredients);
      console.log(ingredients);
    } catch (err) {
      console.error(err);
    }
  }

  const onLoad = () => {
    getTodos();
    setitems(
      todos.map((todo) => {
        return { id: todo.id, group: groups[0], value: todo.recipeName };
      })
    );
    // console.log(items);
  };

  const updateApiWithIds = () => {
    console.log(items);
    // Map through items to extract their IDs and join them with commas
    // This will create a string like "1,2,3" from the IDs of the items
    // ".join" automatically adds a comma between the id's but not at the end - brilliant
    const ids = items.map((item) => item.id).join(",");

    // Update the api state with the concatenated IDs
    setApi(`http://localhost:8080/api/v1/list/getList/${ids}`);

    //show the api in console
    console.log(`Updated API: ${api}`);
  };

  return (
    <div className="groups">
      {groups.map((group) => (
        <div
          className="group"
          key={group}
          onDragEnter={(e) => onDragEnter(e, group)}
        >
          <h1 className="title">{group}</h1>
          <div>
            {items
              .filter((item) => item.group === group)
              .map((thing) => (
                <div
                  key={thing.id}
                  id={thing.id}
                  className="thing"
                  draggable
                  onDragStart={(e) => handleDragStart(e)}
                >
                  {thing.value}
                </div>
              ))}
          </div>
        </div>
      ))}
      <div className="title">
        <button onClick={onLoad}>Load</button>
        <button onClick={updateApiWithIds}>Test Get</button>
        <button onClick={getIngredients}>Get Ingredients</button>
      </div>
    </div>
  );
}
