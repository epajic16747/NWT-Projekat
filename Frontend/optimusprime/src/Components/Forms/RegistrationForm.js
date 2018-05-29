import React, { Component}  from 'react';
import {Link} from 'react-router-dom';

import { Form, Input, DatePicker, Col, TimePicker, Select, Cascader, InputNumber,RadioGroup ,Radio , Button, Alert} from 'antd';

import 'antd/dist/antd.css'


//CONSTANTS[BEGIN]
const FormItem = Form.Item;
const Option = Select.Option;
const formItemLayout = {
    labelCol: {
      xs: { span: 24 },
      sm: { span: 8 },
    },
    wrapperCol: {
      xs: { span: 24 },
      sm: { span: 16 },
    },
  };
//[END]
class RegistrationForm extends Component {

    constructor(){
      super()
      this.state={   
          
          username : '',
          password : '',
          email : '',
          datum : '',
          pol : 'false',
          
          gender : 2,

          //Validacija
          v_username : false,
          v_password : false, 
          v_password_confirm : false,
          v_email : false, 
          v_datum : false,

          inicijalnoStanje : true,
          uspjesnaRegistracija : false
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
            console.log("IMA LI ME OVJDE");
            this.setState({
                password : value,
                v_password : true
            })
            callback();
            return;       
        }
    }
    validatePasswordConfirm = (rule, value, callback) => {

        const form = this.props.form;
        if(value == ""){
            callback('Molimo Vas da unesite korisnicku sifru');
            this.setState({v_password_confirm : false});
            return;             
        }
        else if(value != form.getFieldValue('password')){
            callback('Sifra i potvrda sifre se ne poklapaju!');
            this.setState({v_password_confirm : false});
            return;                         
        }
        else {
            this.setState({v_password_confirm : true});
            callback();
            return;
        }
    }
    validateEmail = (rule,value, callback) => {

        var pattern = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+(com|org|net|gov|ba)\b$/i;
        if(value == ""){
            callback('Molimo Vas da unesite vasu email adresu!');
            this.setState({v_email : false});
            return;               
        }
        else if(!pattern.test(value)){
            callback('Email adresa nije u ispravnom formatu!');
            this.setState({v_email : false});
            return;

        }
        else {
            this.setState({
                email : value,
                v_email : true
            })
            callback();
            return;              
        }

    }
    validateDate = (rule, value, callback) => {
        if(value == ""){
            callback('Unesite datum rođenja!');
            this.setState({v_datum : false});
            return;
        }
        else{
            this.setState({
                v_datum : true,
                datum  :  value.format("DD/MM/YYYY")

            })
            callback();
            return;
        }
        //TO DO validacija na neki opseg tipa min 18 god
    }
    handleGender = (e) => {
        if(e.target.value == 1){
            this.setState({ pol : 'true', gender : 1})
        }
        else {
            this.setState({ pol : 'false', gender : 2})
        }
    }
    handleSubmit = (e) => {
        
        e.preventDefault();
        console.log("BIND STATE za fetch");
        const state = this.state;
        console.log("STATE: ", state);
        if(state.v_username && state.v_password && state.v_password_confirm && state.v_email && state.v_datum) {
            console.log("USAO U IF");
            fetch('http://localhost:4000/korisnik/registracija',{
                mode : 'cors',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    "Accept": "application/json"
                },
                 body: JSON.stringify({
                  korisnickoIme: state.username,
                  sifra: state.password,
                  email: state.email,
                  pol: state.pol,
                  zaposlenik: 'false',
                  datumRodjenja: state.datum            
                })
              })
            .then((response) => {   
              console.log("RESPONSE:", response.json());
              // Neka validacija 
              this.setState({uspjesnaRegistracija : true, inicijalnoStanje : false})
            })
            .catch(ex => {
              console.log('Zahtjev nije poslan serveru: ', ex);
              this.setState({uspjesnaRegistracija : false, inicijalnoStanje : false})
            })

            this.setState({
                v_username : false,
                v_password : false, 
                v_password_confirm : false,
                v_email : false, 
                v_datum : false
            })
            //Neke validacije
        }
        else {
            this.setState({uspjesnaRegistracija : false, inicijalnoStanje : false})
         }
    }
  render(){
    const { getFieldDecorator, getFieldsError, getFieldError, isFieldTouched } = this.props.form;
    const RadioGroup = Radio.Group;
    const state = this.state;
    let responseMessage;
    if(state.inicijalnoStanje == true){
        responseMessage = <div></div>
    }
    else if(state.inicijalnoStanje == false && !state.uspjesnaRegistracija){
        responseMessage = <Alert
                            message="Greska!"
                            description="Greska prilikom registracije! Molimo provjerite vase unose!"
                            type="error"
                            showIcon
                          />   
    }
    else {
        responseMessage = <Alert
                            message="Uspjesna registracija!"
                            description="Korisnik je uspjesno registrovan!"
                            type="success"
                            showIcon
                           />
    }

                    
    return (
        <Form onSubmit={this.handleSubmit}>
            <FormItem
                {...formItemLayout}
                label="Korisnicko ime:"
     
                
            >
                {getFieldDecorator('username', {
                    rules: [
                        {
                        validator : this.validateUsername,
                        }
                    ]
                })(
                    <Input placeholder ="Unesite korisnicko ime..."/>
                )}
            </FormItem>
            <FormItem
                {...formItemLayout}
                label="Password:"                
            >
                {getFieldDecorator('password', 
                {
                    rules: [
                        {
                        validator : this.validatePassword,
                        },
                    ]
                })(
                    <Input type="password" placeholder ="Unesite vasu zeljenu sifru..."/>
                )}
            </FormItem>     

            <FormItem
                {...formItemLayout}
                label="Password confirm:"                
            >
                {getFieldDecorator('password_c', 
                {
                    rules: [
                        {
                        validator : this.validatePasswordConfirm,
                        },
                    ]
                })(
                    <Input type="password" placeholder ="Potvrda sifre..."/>
                )}
            </FormItem>     

            <FormItem
                {...formItemLayout}
                label="Email:"                
            >
                {getFieldDecorator('email', 
                {
                    rules: [
                        {
                        validator : this.validateEmail,
                        },
                    ]
                })(
                    <Input  placeholder ="Email adresa..."/>
                )}
            </FormItem>                              


            <FormItem
            {...formItemLayout}
            label="Datum rodjenja:"

            >
            {getFieldDecorator('datumRodjenja', 
            {
                rules: [
                    {
                    validator : this.validateDate,
                    },
                ]
            })(
                 <DatePicker placeholder="Unesite datum rođenja..." style={{ width: '100%' }} format={"DD-MM-YYYY"} />
            )}            
           
            </FormItem>
            <FormItem
            {...formItemLayout}
            label="Pol:"
            >
                <RadioGroup onChange={this.handleGender} value={state.gender} defaultValue={2}>
                    <Radio value={1}>Žensko</Radio>
                    <Radio value={2}>Muško</Radio>
                </RadioGroup>
                
            </FormItem>

                <Button  type="primary" htmlType="submit">
                    Submit
                </Button>
                {responseMessage}
      
        </Form>
    );
  }


}
export default Form.create()(RegistrationForm)

