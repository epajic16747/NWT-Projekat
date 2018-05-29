import React, { Component}  from 'react';
import { Menu, Icon } from 'antd';
import {Redirect, Link} from 'react-router-dom';
import 'antd/dist/antd.css'
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

 export class MainMenuUser extends Component {

    constructor(){
      super()
      this.state = {
        current: 'home',
      }
          
          
    }
    handleClick = (e) => {
        console.log('click ', e);
        this.setState({
          current: e.key,
        });

      }
    //To do validacija na tipa korisnika admin ide posebno
      render() {

        if(localStorage.getItem('prijavljen') != 'true' || localStorage.getItem('prijavljen') == 'undefined') {
          return (
            <Menu
            onClick={this.handleClick}
            selectedKeys={[this.state.current]}
            mode="horizontal"
            theme= "light"
          >
             <Menu.Item key="home">
             <Link to="/home" >Home</Link>
           </Menu.Item>
           <Menu.Item key="shop">
           <Link to="/proizvodi">Shop</Link>
           </Menu.Item>
           <Menu.Item key="about">
           <Link to="/about">About Us</Link>
           </Menu.Item>   
           <Menu.Item key="contact">
             <Link to="/contact">Contact Us</Link>
           </Menu.Item>    
                   
            <Menu.Item key="signIn"  style={{ 'float': 'right'}}>
              <Link to="/signIn" >Sign In</Link>
            </Menu.Item>
            <Menu.Item key="signUp"  style={{ 'float': 'right'}}>
              <Link to="/signUp" >Sign Up</Link>
            </Menu.Item>
          </Menu>
          );
        }
        else {
          return (
            <Menu
            onClick={this.handleClick}
            selectedKeys={[this.state.current]}
            mode="horizontal"
            theme= "light"
            >
              <Menu.Item key="home">
                <Link to="/home" >Home</Link>
              </Menu.Item>
              <Menu.Item key="shop">
              <Link to="/proizvodi">Shop</Link>
              </Menu.Item>
              <Menu.Item key="about">
              <Link to="/about">About Us</Link>
              </Menu.Item>   
              <Menu.Item key="contact">
                <Link to="/contact">Contact Us</Link>
              </Menu.Item>   
              <Menu.Item key="reportProblem">
                <Link to="/reportProblem">Report a problem</Link>
              </Menu.Item>    
              <Menu.Item key="korpa">
                <Link to="/korpa">Korpa</Link>
              </Menu.Item>                                  
              <Menu.Item key="signIn"  style={{ 'float': 'right'}}>
                <Link to="/signIn" >Sign In</Link>
              </Menu.Item>
              <Menu.Item key="signUp"  style={{ 'float': 'right'}}>
                <Link to="/signUp" >Sign Up</Link>
              </Menu.Item>
            </Menu>
          );
      }
    }
  


}


