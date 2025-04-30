import React, { useState } from "react";
import "./Dnd.css";

export default function Dnd() {
  const groups = ["group1", "group2", "group3"];
  const [items, setitems] = useState([
    { id: 1, group: groups[0], value: "Chicken" },
    { id: 2, group: groups[0], value: "Monkey" },
    { id: 3, group: groups[0], value: "Duck" },
    { id: 4, group: groups[1], value: "Rhino" },
    { id: 5, group: groups[1], value: "Sandwich" },
    { id: 6, group: groups[2], value: "Ostrich" },
    { id: 7, group: groups[2], value: "Flamingo" }
  ]);

  const [dragging, setDragging] = useState();

  const handleDragStart = (e) => {
    setDragging(e.target);
  };

  const onDragEnter = (e, group) => {
    setitems([...items, (items[dragging.id - 1].group = group)]);
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
    </div>
  );
}