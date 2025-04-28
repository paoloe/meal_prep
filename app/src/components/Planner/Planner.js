import React from "react";
import { useEffect, useState, useLayoutEffect } from "react";

export default class Planner extends React.Component {

  // const [isDataFetched, setIsDataFetched] = useState(false);
  // const [todos, setTodos] = useState([]);
  // const [selectedCategory, setSelectedCategory] = useState("All");
  // let recipeId = [];
  // var x = "http://localhost:8080/api/v1/list/getList/";

  constructor(props){
    super(props);
    this.state = {
      todos: [],
      setTodos: []
    }
  }

  async getTodos() {
    try {
      const res = await fetch(`/api/v1/recipe/getAllRecipe/`);
      const todos = await res.json();
      // setTodos(todos);
      console.log(todos);
      console.log("test");
    } catch (err) {
      console.error(err);
    }
  }

  render() {
    this.getTodos();
    return (
      <div className="planner">
        <h1>Hello</h1>
        <select>
          <option>Tuesday</option>
          {/* {todos.map((result) => (
            <option id={result.id}>{result.recipeName}</option>
          ))} */}
        </select>
        {/* <select onChange={(e) => setSelectedCategory(e.target.value)}>
              <option>Select Recipe</option>
                {todos.map((item) => (
                    <option value={item.id}>{item.recipeName}</option>
                  ))}
            </select>
            <select>
              <option>Tuesday</option>
                {todos.map((result)=>(<option id={result.id}>{result.recipeName}</option>))}    
            </select>
            <select>
              <option>Wednesday</option>
                {todos.map((result)=>(<option id={result.id}>{result.recipeName}</option>))}    
            </select>
            <select>
              <option>Thursday</option>
                {todos.map((result)=>(<option id={result.id}>{result.recipeName}</option>))}    
            </select>
            <select>
              <option>Friday</option>
                {todos.map((result)=>(<option id={result.id}>{result.recipeName}</option>))}    
            </select>
            <select>
              <option>Saturday</option>
                {todos.map((result)=>(<option id={result.id}>{result.recipeName}</option>))}    
            </select>
            <select>
              <option>Sunday</option>
                {todos.map((result)=>(<option id={result.id}>{result.recipeName}</option>))}    
            </select> */}
      </div>
    );
  }
}
