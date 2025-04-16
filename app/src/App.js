import './App.css';
import React from "react";

export default class RecipeList extends React.Component{
    //const [helloText, setHelloText] = useState();
  state = {
    values: []
  };

  componentDidMount() {
    fetch(`http://localhost:8080/api/v1/list/getList/1`)
        .then(response => response.json())
        .then(json => {
          this.setState({
            values: json
          })
        })
        .then(() =>
          console.log(json))
        .catch(error => {
          console.log('error');
          console.log(error);
        });
  };

  render() {
    return (
      <div>

    </div>
    );
  }
}