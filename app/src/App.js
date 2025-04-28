import React from "react";
import "./App.css";
import { BrowserRouter, Router, Routes, Route, Link } from "react-router-dom";
import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import Planner from "./components/Planner/Planner";

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <Header />
        <Planner />
        <Footer />
      </div>
    );
  }
}

export default App;
