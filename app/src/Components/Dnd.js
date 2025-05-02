import React, { useState } from "react";
import "./Dnd.css";
import { set } from "date-fns";

export default function Dnd() {
  const groups = ["Recipe", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
  const [items, setitems] = useState([]);
  const [dragging, setDragging] = useState();
  const [todos, setTodos] = useState([]);

  const handleDragStart = (e) => {
    setDragging(e.target);
  };

  const onDragEnter = (e, group) => {
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
    console.log(items);
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
      </div>
    </div>
  );
}