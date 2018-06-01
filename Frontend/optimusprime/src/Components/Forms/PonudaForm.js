import React, { Component}  from 'react';
import {Link} from 'react-router-dom';

import { Form, Input, DatePicker, Col, TimePicker, Select, Cascader, InputNumber,RadioGroup ,Radio , Button, Alert} from 'antd';

import 'antd/dist/antd.css'


//CONSTANTS[BEGIN]
const FormItem = Form.Item;
const Option = Select.Option;
const { TextArea } = Input;
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
class PonudaForm extends Component {

    constructor(){
      super()
      this.state={   
          
          naziv : '',
          opis : '',
          adresa : '',
          telefon: '',
          email : '',


          //Validacija
          v_naziv: false,
          v_opis : false, 
          v_adresa: false,
          v_telefon: false,
          v_email : false, 


          inicijalnoStanje : true,
          uspjesnaRegistracija : false
      }
    }
    validateNaziv = (rule, value, callback) => {
        
        if(value == ""){   
            callback('Molimo Vas da unesite naziv kompanije!');
            this.setState({v_naziv : false})
            return;
        }
        else if (value.length <= 2) {
          callback('Naziv kompanije ime mora imati bar 3 znaka!');
          this.setState({v_naziv : false})
          return;
        }
 
        else {
          this.setState({
              naziv : value,
              v_naziv: true
          })
          callback();
          return;
        }

        
    }
    validateOpis = (rule,value, callback) => {
        if(value == ""){   
            callback('Molimo Vas da unesite opis autoprevoznika!');
            this.setState({v_opis: false})
            return;
        }
        else if (value.length <= 49) {
          callback('Opis mora imati bar 50 znakova!');
          this.setState({v_opis : false})
          return;
        }
      
        else {
          this.setState({
              opis: value,
              v_opis : true
          })
          callback();
          return;
        }        
    }
    validateAdresa = (rule, value, callback) => {
        if(value == ""){   
            callback('Molimo Vas da unesite adresu autoprevoznika!');
            this.setState({v_adresa : false})
            return;
        }
        else if (value.length <= 15) {
          callback('Adresa autoprevoznika ime mora imati bar 16 znaka!');
          this.setState({v_adresa : false})
          return;
        }
 
        else {
          this.setState({
              adresa : value,
              v_adresa: true
          })
          callback();
          return;
        }
    }
    validateTelefon = (rule, value, callback) => {
        if(value == ""){   
            callback('Molimo Vas da unesite telefon autoprevoznika!');
            this.setState({v_telefon : false})
            return;
        }
        else if (value.length <= 8) {
          callback('Naziv autoprevoznika ime mora imati bar 9 znaka!');
          this.setState({v_telefon : false})
          return;
        }
 
        else {
          this.setState({
              telefon : value,
              v_telefon: true
          })
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

    handleSubmit = (e) => {
        
        e.preventDefault();
        console.log("BIND STATE za fetch");
        const state = this.state;
        console.log("STATE: ", state);
        if(state.v_naziv && state.v_opis && state.v_adresa && state.v_email && state.v_telefon) {
            console.log("USAO U IF");
            fetch('url-dodajAutoprevoznika',{
                mode : 'cors',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    "Accept": "application/json"
                },
                 body: JSON.stringify({
                  naziv : state.naziv,
                  opis : state.opis,
                  adresa : state.adresa,
                  telefon : state.telefon,
                  email  :state.email       
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
                v_naziv: false,
                v_opis : false, 
                v_adresa: false,
                v_telefon: false,
                v_email : false, 
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
                            description="Kompanija je uspjesno registrovana!"
                            type="success"
                            showIcon
                           />
    }

                    
    return (
        <Form onSubmit={this.handleSubmit}>
            <FormItem
                {...formItemLayout}
                label="Naziv:"
     
                
            >
                {getFieldDecorator('naziv', {
                    rules: [
                        {
                        validator : this.validateNaziv,
                        }
                    ]
                })(
                    <Input placeholder ="Unesite naziv autoprevoznika..."/>
                )}
            </FormItem>

            <FormItem
                {...formItemLayout}
                label="Naziv:"
     
                
            >
                {getFieldDecorator('opis', {
                    rules: [
                        {
                        validator : this.validateOpis,
                        }
                    ]
                })(
                   
                    <TextArea placeholder="Opis autoprevoznika..." autosize />
                )}
            </FormItem>  
            <FormItem
                {...formItemLayout}
                label="Adresa:"
     
                
            >
                {getFieldDecorator('adresa', {
                    rules: [
                        {
                        validator : this.validateAdresa,
                        }
                    ]
                })(
                    <Input placeholder ="Unesite adresu autoprevoznika..."/>
                )}
            </FormItem>    
            <FormItem
                {...formItemLayout}
                label="Telefon:"
     
                
            >
                {getFieldDecorator('telefon', {
                    rules: [
                        {
                        validator : this.validateTelefon,
                        }
                    ]
                })(
                    <Input placeholder ="Unesite telefon autoprevoznika..."/>
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
                    <Input  placeholder ="Email autoprevoznika..."/>
                )}
            </FormItem> 


            <Button  type="primary" htmlType="submit">
                Submit
            </Button>
                {responseMessage}
      
        </Form>
    );
  }


}
export default Form.create()(PonudaForm)

