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
class AutoprevoznikRegistration extends Component {

    constructor(){
      super()
      this.state={   
          
          cijena_max : '',
          datum : '',
          autoprevoznik : ['NWT Autoprevoznik', 'In time express', 'DHL', 'Euro express', 'Sarajevo transport'],
          status: '',
          kompanija : ['NWT Autoprevoznik', 'In time express', 'DHL', 'Euro express', 'Sarajevo transport'],
          naziv: '',


          //Validacija
          v_cijena_max: false,
          v_datum : false, 
          v_autoprevoznik: false,
          v_status: false,
          v_kompanija : false, 
          v_naziv: false,


          inicijalnoStanje : true,
          uspjesnaRegistracija : false
      }
    }
    validateCijenaMax = (rule, value, callback) => {
        
        if(value == ""){   
            callback('Molimo Vas da unesite naziv maksimalnu cijenu!');
            this.setState({v_naziv : false})
            return;
        }
        else if (value < 0) {
          callback('Maksimalna cijena ne moze biti negativna');
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
    validateStatus = (rule,value, callback) => {
        if(value == ""){   
            callback('Molimo Vas da unesite opis status transporta!');
            this.setState({v_opis: false})
            return;
        }
        else if (value !== 'aktivna' || value !== 'neaktivna') {
          callback('Stutus mora biti aktivna ili neaktivna!');
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
                            description="Greska prilikom unosa transporta! Molimo provjerite vase unose!"
                            type="error"
                            showIcon
                          />   
    }
    else {
        responseMessage = <Alert
                            message="Dodavanje transporta uspjesno!"
                            description="Transport usjesno dodan!"
                            type="success"
                            showIcon
                           />
    }

                    
    return (
        <Form onSubmit={this.handleSubmit}>
            <FormItem
                {...formItemLayout}
                label="Maksimalna cijena transporta:"
     
                
            >
                {getFieldDecorator('naziv', {
                    rules: [
                        {
                        validator : this.validateCijenaMax,
                        }
                    ]
                })(
                    <Input placeholder ="Maksimalna cijena transporta..."/>
                )}
            </FormItem>

            <FormItem
                {...formItemLayout}
                label="Datum transporta:"
     
                
            >
                {getFieldDecorator('opis', {
                    rules: [
                        {
                        validator : this.validateOpis,
                        }
                    ]
                })(
                   
                    <DatePicker />
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
export default Form.create()(AutoprevoznikRegistration)

