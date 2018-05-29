import React, { Component}  from 'react';
import Login from './Login.js'
import RegistrationForm from './RegistrationForm.js'
//import {UserRegistration} from './UserRegistration.js'
//import {Modal, Button, Popover, Tooltip} from 'react-bootstrap'
import {Link, Redirect} from 'react-router-dom'
import { Modal, Button } from 'antd';


export class ModalForm extends Component{

    constructor(props){
        super(props)
        this.state = {
        showModal: true,
        visible : true
        }
    }


    open() {
      this.setState({ showModal: true });
    }


    showModal = () => {
      this.setState({
        visible: true,
      });
    }
    handleOk = (e) => {
      console.log(e);
      this.setState({
        visible: false,
      });
    }
    close = (e) => {
        console.log(e);
        this.setState({
          visible: false,
        });
      }

  render() {

    return (

      <div>
        <Modal
          title={(this.props.forma === "User registration") ? "Forma za registraciju" : "Sign In"}
          visible={this.state.visible}
          onOk={this.handleOk}
          onCancel={this.close}
          footer={[
            <Button onClick={this.close}><Link to="/">Close</Link></Button>
    
            ]}
        >
          {(this.props.forma === "User registration") ? <RegistrationForm /> : <Login />}
          {(this.state.visible == false) ? <Redirect to="/" /> : <div></div>}


        </Modal>
     </div>      
    )
  }
}
//{(this.props.forma === "User registration") ? <UserRegistration key={1}/> : <Login key={2}/>}