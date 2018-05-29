import React, { Component}  from 'react';
import { Menu, Icon } from 'antd';
import 'antd/dist/antd.css'

const MenuItemGroup = Menu.ItemGroup;

 export class FooterC extends Component {

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
  
      render() {

        
        return (
          <Menu
            onClick={this.handleClick}
          
            mode="horizontal"
            theme= "light"
          >
          <p align="center">Some text!! ili nesto</p>
          
          </Menu>
        );
    }
  


}


