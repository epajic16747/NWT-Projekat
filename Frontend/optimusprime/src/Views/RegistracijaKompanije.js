import React, { Component}  from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';
import KompanijaRegistration from '../Components/Forms/KompanijaRegistration.js';

import '../Style/Layout.css';

const { Header, Footer, Sider, Content } = Layout;


 export class RegistracijaKompanije extends Component {

    constructor(){
      super()

      localStorage.setItem("initialLoading", "true");     
          
    }

      
    //To do validacija na tipa korisnika admin ide posebno
      render() {

        
        return (
            <div>
                <Layout> 
                    <Sider style={{'width' : '50px'}}>Left Sider</Sider>
            
                
                <Layout>
                    <MainMenuUser />

                    <Content>
                        <h1 align="center">Registracija kompanije</h1>
                    <Row>
                    <Col span={12} offset={6}><KompanijaRegistration/></Col>
                  </Row>
                    </Content>
                    <FooterC/>
                </Layout>
                    <Sider>Right Sider</Sider>
                </Layout>
          </div>
        );
    }
  


}


