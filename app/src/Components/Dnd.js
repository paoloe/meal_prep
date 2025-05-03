import React, { useState } from "react";
import "./Dnd.css";

export default function Dnd() {
  const groups = ["Recipe", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
  const [items, setitems] = useState([]);
  const [dragging, setDragging] = useState();
  const [todos, setTodos] = useState([]);
  const [api, setApi] = useState("http://localhost:8080/api/v1/list/getList/");

  const handleDragStart = (e) => {
    setDragging(e.target);
  };

  const onDragEnter = (e, group) => {
    // "...items" is the spread operator, it creates a shallow copy of the items array - cool.
    setitems([...items, (items[dragging.id - 1].group = group)]);
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

  const onLoad = () => { 
    getTodos();
    setitems(todos.map((todo) => {
      return { id: todo.id, group: groups[0], value: todo.recipeName };
    }));
    // console.log(items);
  }

  const onTestGet = () => {
    console.log(items);
    // setApi(api.concat(items.map((item) => item.id)));
    // console.log(api)
  } 

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
        <button onClick={onTestGet}>Test Get</button>
      </div>
    </div>
  );
}