import React, { Component } from 'react';
import logo from '../assets/PageImages/logo.svg';
import {BarLoader} from 'react-spinners';
import '../Style/App.css';
//import {Home} from '../Views/Home.js'



class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      loading : true
    }
    localStorage.setItem('initialLoading', 'true');
  }
    componentWillMount(){
      this.loaderImgStyle={

        display: 'block',
        marginLeft: 'auto',
        marginRight: 'auto'

      }

  }
  componentDidMount(){

    if(localStorage.getItem("initialLoading")== "false" || localStorage.getItem("initialLoading")== "undefined") {

      setTimeout(() => this.setState({ loading: false, initialLoading : true }), 2500); 
      
    }
 
  }

  render() {
    let data;
    if(this.state.loading) {
      data =        <div className="mainLoadingComponent">
              <img src={require('../assets/PageImages/OptimusPrimeTruck.jpg')} style={this.loaderImgStyle} alt="E-Parmsun" height="300" width="450" />  
                <div className="divSpinner">          
                <BarLoader
                    color={'#123abc'} 
                    loading={this.state.loading} 
                    height={30}
                    width={450}
                    
                  /></div>
        
              </div>
 
    }
    else {
        //  data = <Home />
        data = <h1>Test</h1>
    }
    return (
        <div>  {data}</div>
      
    );
  }
}

export default App;
