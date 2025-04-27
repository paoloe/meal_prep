import React from 'react';
import {useEffect, useState, useLayoutEffect} from "react";


// const [isDataFetched, setIsDataFetched] = useState(false);
// const [todos, setTodos] = useState([]);
// const [selectedCategory, setSelectedCategory] = useState("All");
// let recipeId = [];
// var x = "http://localhost:8080/api/v1/list/getList/";

export default class Planner extends React.Component {

    render() {

        return (
            <div className='planner'>
              <h1>Hello</h1>
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
        )
    }
}