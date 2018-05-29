import { Form, Icon, Input, Button, Checkbox,Alert} from 'antd';

import React, { Component}  from 'react';
import {Link} from 'react-router-dom'
import 'antd/dist/antd.css'
import '../../Style/LoginForm.css';
const FormItem = Form.Item;

 class Login extends Component {

    constructor(){
      super()
      this.state={
          username: '',
          password: '',

          v_password : false,
          v_username : false,

          inicijalnoStanje : true,
          uspjesnaPrijava : false
          
          
      }
  }

    handleLogin = (e) => {
      
      e.preventDefault();
      const state = this.state;

      if(state.v_username && state.v_password) {
        
          fetch('http://localhost:4000/korisnik/prijava',{
              mode : 'cors',
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json',
                  "Accept": "application/json"
              },
              body: JSON.stringify({
                korisnickoIme: state.username,
                sifra: state.password,
              })
            })
          .then((response) => {   
            console.log("RESPONSE:", response.json());
            // Neka validacija 
            this.setState({uspjesnaPrijava : true, inicijalnoStanje : false})
            localStorage.setItem('prijavljen', 'true');
          })
          .catch(ex => {
            console.log('Zahtjev nije poslan serveru: ', ex);
            this.setState({uspjesnaPrijava : false, inicijalnoStanje : false})
          })

          this.setState({
              v_username : false,
              v_password : false
          })
          //Neke validacije
      }
      else {
          this.setState({uspjesnaPrijava : false, inicijalnoStanje : false})
      }
  }

  validateUsername = (rule, value, callback) => {
    
    if(value == ""){   
        callback('Molimo Vas da unesite korisnicko ime!');
        this.setState({v_username : false})
        return;
    }
    else if (value.length <= 5) {
      callback('Korisnicko ime mora imati bar 6 znakova!');
      this.setState({v_username : false})
      return;
    }
    //Unique username 
    else {
      this.setState({
          username : value,
          v_username : true
      })
      callback();
      return;
    }

    
  }
  validatePassword = (rule, value, callback) => {
      if(value == ""){
          callback('Molimo Vas da unesite korisnicku sifru');
          this.setState({v_password : false})
          return;            
      }
      else if(value.length <= 7) {
          callback('Korisnicka sfira mora imati bar 8 znakova!');
          this.setState({v_password : false})
          return;              
      }
      //Extra validations
      else {
      
          this.setState({
              password : value,
              v_password : true
          })
          callback();
          return;       
      }
  }
 postojiUser = (e) => {
   return true;
 }

 handleLogout = () =>{
      localStorage.setItem('prijavljen', 'undefined');
 }
  render(){
    const { getFieldDecorator } = this.props.form;

    const state = this.state;
    let responseMessage;
    if(state.inicijalnoStanje == true){
        responseMessage = <div></div>
    }
    else if(state.inicijalnoStanje == false && !state.uspjesnaPrijava){
        responseMessage = <Alert
                            message="Greska!"
                            description="Greska prilikom prijave! Molimo provjerite da li su vasi podaci ispravni!"
                            type="error"
                            showIcon
                          />   
    }
    else {
        responseMessage = <Alert
                            message="Uspjesna registracija!"
                            description="Korisnik je uspjesno prijavljen!"
                            type="success"
                            showIcon
                           />
    }   
    
    if(localStorage.getItem('prijavljen') != 'true' || localStorage.getItem('prijavljen') == 'undefined') {
      return (
        <Form onSubmit={this.handleLogin} className="login-form">
          <FormItem>
            {getFieldDecorator('userName', 
            {
              rules : [
                  {validator : this.validateUsername,},     
              ]
            })(
              <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />} placeholder="Username..." />
            )}
          </FormItem>
            
          <FormItem>
            {getFieldDecorator('password', {
              rules: [
                {validator : this.validatePassword}

              ],
            })(
              <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />} type="password" placeholder="Password..." />
            )}
          </FormItem>
          <Button type="primary" htmlType="submit" className="login-form-button">
              Log in
            </Button>
            {responseMessage}

        </Form>
      );
    }

    else {
      return(
        <div>
          <h1>Vec ste prijavljeni!</h1>
          <Button type="primary" onClick={this.handleLogout} className="login-form-button">
              Log out
          </Button>
        </div>
      );
    }
  
  }


}
export default Form.create()(Login)
/*
DODACI NEKI ZA KASNIJE
        <FormItem>
          {getFieldDecorator('remember', {
            valuePropName: 'checked',
            initialValue: true,
          })(
            <Checkbox>Remember me</Checkbox>
          )}
          <a className="login-form-forgot" href="">Forgot password</a>
          <Button type="primary" htmlType="submit" className="login-form-button">
            Log in
          </Button>
          Or <a href="">register now!</a>
        </FormItem>

*/
