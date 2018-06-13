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
          autoprevoznikArray : ['NWT Autoprevoznik', 'In time express', 'DHL', 'Euro express', 'Sarajevo transport'],
          status: '',
          kompanija : ['NWT Autoprevoznik', 'In time express', 'DHL', 'Euro express', 'Sarajevo transport'],
          naziv: '',


          //Validacija
          v_cijena_max: false,
          v_datum : true, 
          v_autoprevoznik: true,
          v_status: true,
          v_kompanija : true, 
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
              cijena_max : value,
              v_cijena_max: true
          })
          callback();
          return;
        }

        
    }
    validateNaziv = (rule,value, callback) => {
        if(value == ""){   
            callback('Molimo Vas da unesite naziv status transporta!');
            this.setState({v_opis: false})
            return;
        }
        else if (value.lenth < 5) {
          callback('Naziv transporta mora biti barem 5 znakova!');
          this.setState({v_opis : false})
          return;
        }
      
        else {
          this.setState({
              naziv: value,
              v_naziv : true
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
        if(state.v_naziv && state.v_cijena_max) {
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
                {getFieldDecorator('max_cijena', {
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
                {getFieldDecorator('datum_transporta', {
                })(
                   
                    <DatePicker />
                )}
            </FormItem>  
            <FormItem
                {...formItemLayout}
                label="Autoprevoznik:"
     
                
            >
                {getFieldDecorator('autoprevoznik', {
                })(
                    <Select>
                    {this.state.autoprevoznikArray.map((ime) => {
                        return <Option value={ime}>{ime}</Option>
                    })}
                  </Select>
                )}
            </FormItem>    
            <FormItem
                {...formItemLayout}
                label="Status:"
     
                
            >
                    {getFieldDecorator('status', {
                    })(
                        <Select>
                            <Option value="aktivan">aktivan</Option>
                            <Option value="neaktivan">neaktivan</Option>

                      </Select>
                    )}
            </FormItem>                                
                            
            <FormItem
                {...formItemLayout}
                label="Kompanija:"                
            >
                {getFieldDecorator('kompanija', 
                {
                })(
                    <Select>
                    {this.state.kompanija.map((ime) => {
                        return <Option value={ime}>{ime}</Option>
                    })}
                  </Select>
                )}
            </FormItem> 

            <FormItem
                {...formItemLayout}
                label="Naziv transporta:"
     
                
            >
                {getFieldDecorator('naziv transporta', {
                    rules: [
                        {
                        validator : this.validateNaziv,
                        }
                    ]
                })(
                    <Input placeholder ="Naziv transporta..."/>
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

