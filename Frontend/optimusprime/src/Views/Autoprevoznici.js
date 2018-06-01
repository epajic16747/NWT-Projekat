import React, {Component} from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';

import {AutoprevozniciList} from '../Components/Liste/AutoprevozniciList.js';


import '../Style/Layout.css';


const { Header, Footer, Sider, Content } = Layout;


export class Autoprevoznici extends Component{

    constructor(){
        super()
         
      }
 
    render(){

        return(
            <div>
                <Layout> 
                    <Sider></Sider>                
                <Layout>
                    <MainMenuUser />

                    <Content>
                        <h1 align="center">Autoprevoznici</h1>
                    <Row>
                    <Col span={18} offset={6}><AutoprevozniciList/></Col>
                </Row>
                    </Content>
                    <FooterC/>
                </Layout>
                    <Sider></Sider>
                </Layout>
            </div>
      
        )
    }

}

