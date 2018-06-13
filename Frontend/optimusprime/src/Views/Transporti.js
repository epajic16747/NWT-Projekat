import React, { Component}  from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';
import AutoprevoznikRegistration from '../Components/Forms/AutoprevoznikRegistration.js';
import {TransportiList} from '../Components/Liste/TransportiList.js';
import { Link } from 'react-router-dom'

import '../Style/Layout.css';

const { Header, Footer, Sider, Content } = Layout;


 export class Transporti extends Component {

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
                        <h1 align="center">Pregled transporta: </h1>
                    <Row>
                     <Col span={24} ><TransportiList/></Col>

                  </Row>
                  <Row>
                     <Link to="/transportponude" className="pregled_ponuda_btn">Pregled ponuda</Link>
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


