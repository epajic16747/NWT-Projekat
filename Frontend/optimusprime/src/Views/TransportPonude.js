import React, { Component}  from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';
import AutoprevoznikRegistration from '../Components/Forms/AutoprevoznikRegistration.js';
import {TransportPonudeList} from '../Components/Liste/TransportPonudeList.js';
import { Router, Route, IndexRoute, hashHistory, browserHistory } from 'react-router'
import '../Style/Layout.css';
import { Link } from 'react-router-dom'

const { Header, Footer, Sider, Content } = Layout;


 export class TransportPonude extends Component {

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
                        <h1 align="center">Pregled ponuda: </h1>
                    <Row>
                     <Col span={24} ><TransportPonudeList/></Col>

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


