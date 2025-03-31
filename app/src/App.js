import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App(){
  const [helloText, setHelloText] = useState();

  useEffect(() => {
    hello();
  }, []);

  const hello = () => {
    console.log('Hello');
    var obj;
    fetch(`/api/v1/list/getList/1`)
        .then(response => response.json())
        .then(data => {
          obj = data;
        })
        .then(() =>
          console.log(obj))
        .catch(error => {
          console.log('error');
          console.log(error);
        });
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
