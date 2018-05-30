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

            <Menu.Item key="signIn"  style={{ 'float': 'right'}}>
              <Link to="/signIn" >Sign In</Link>
            </Menu.Item>
 
          </Menu>
          );
        }
        else if(localStorage.getItem('prijavljen') == 'true' && localStorage.getItem('tipKorisnika') == 'autoprevoznik') {
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
              <Menu.Item key="autoprevoznik">
              <Link to="/autoprevoznik">Autoprevoznik</Link>
              </Menu.Item>
              <Menu.Item key="transporti">
              <Link to="/transporti">Transporti</Link>
              </Menu.Item>   
              <Menu.Item key="kreirajTransport">
                <Link to="/kreirajTransport">Kreiraj Transport</Link>
              </Menu.Item>   
              <Menu.Item key="signUp"  style={{ 'float': 'right'}}>
                <Link to="/signUp" >Sign Up</Link>
              </Menu.Item>
            </Menu>
          );
        }
        else if(localStorage.getItem('prijavljen') == 'true' && localStorage.getItem('tipKorisnika') == 'autoprevoznik') {
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
              <Menu.Item key="autoprevoznik">
              <Link to="/autoprevoznik">Autoprevoznik</Link>
              </Menu.Item>
              <Menu.Item key="ponude">
              <Link to="/ponude">Ponude</Link>
              </Menu.Item>   
              <Menu.Item key="kreirajPonudu">
                <Link to="/kreirajPonudu">Kreiraj Ponudu</Link>
              </Menu.Item>   

              <Menu.Item key="signUp"  style={{ 'float': 'right'}}>
                <Link to="/signUp" >Sign Up</Link>
              </Menu.Item>
            </Menu>
          );          
      }
      else if(localStorage.getItem('prijavljen') == 'true' && localStorage.getItem('tipKorisnika') == 'kompanija') {
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
            <Menu.Item key="kompanija">
            <Link to="/kompanija">Kompanija</Link>
            </Menu.Item>
            <Menu.Item key="transporti">
            <Link to="/transporti">Transporti</Link>
            </Menu.Item>   
            <Menu.Item key="kreirajTransport">
              <Link to="/kreirajTransport">Kreiraj Transport</Link>
            </Menu.Item>   
            <Menu.Item key="signUp"  style={{ 'float': 'right'}}>
              <Link to="/signUp" >Sign Up</Link>
            </Menu.Item>
          </Menu>
        );          
      }
    else if(localStorage.getItem('prijavljen') == 'true' && localStorage.getItem('tipKorisnika') == 'admin') {
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
          <Menu.Item key="kompanije">
          <Link to="/kompanije">Kompanije</Link>
          </Menu.Item>
          <Menu.Item key="autoprevoznici">
              <Link to="/autoprevoznici">Autoprevoznik</Link>
          </Menu.Item>          
          <Menu.Item key="sviTransporti">
          <Link to="/sviTransporti">Transporti</Link>
          </Menu.Item>   
          <Menu.Item key="kreirajKompaniju">
            <Link to="/kreirajKompanijy">Kreiraj Kompaniju</Link>
          </Menu.Item>   
          <Menu.Item key="kreirajAutoprevoznika">
            <Link to="/kreirajAutoprevoznika">Kreiraj Autoprevoznika</Link>
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
          <Menu.Item key="kompanije">
          <Link to="/kompanije">Kompanije</Link>
          </Menu.Item>
          <Menu.Item key="autoprevoznici">
              <Link to="/autoprevoznici">Autoprevoznik</Link>
          </Menu.Item>          
          <Menu.Item key="sviTransporti">
          <Link to="/sviTransporti">Transporti</Link>
          </Menu.Item>   
          <Menu.Item key="kreirajKompaniju">
            <Link to="/kreirajKompaniju">Kreiraj Kompaniju</Link>
          </Menu.Item>   
          <Menu.Item key="kreirajAutoprevoznika">
            <Link to="/kreirajAutoprevoznika">Kreiraj Autoprevoznika</Link>
          </Menu.Item>   
          <Menu.Item key="registracijaKorisnika">
                <Link to="/registracijaKorisnika">Registracija Korisnika</Link>
              </Menu.Item>                    
          <Menu.Item key="signUp"  style={{ 'float': 'right'}}>
            <Link to="/signUp" >Sign Up</Link>
          </Menu.Item>
        </Menu>
      );  
    }   
          
    }
  


}


