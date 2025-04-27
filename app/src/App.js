import React from 'react';
import './App.css'
import { BrowserRouter, Router, Routes, Route, Link } from "react-router-dom"
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';
import Planner from './components/Planner/Planner.js';

class App extends React.Component {
  
  
  render(){
    return(
      <div>
          <h1>Test</h1>
          <BrowserRouter>
    <Routes>
   <Route path="/" element={<App />} />
   <Route path='planner' element={<Planner />}/>
   </Routes>
  </BrowserRouter>
      </div>
    );
  }  
}

export default App;