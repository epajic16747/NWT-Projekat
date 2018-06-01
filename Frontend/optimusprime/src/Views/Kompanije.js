import React, {Component} from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';

import {KompanijeList} from '../Components/Liste/KompanijeList.js';


import '../Style/Layout.css';


const { Header, Footer, Sider, Content } = Layout;


export class Kompanije extends Component{

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
                        <h1 align="center">Kompanije</h1>
                    <Row>
                    <Col span={18} offset={6}><KompanijeList/></Col>
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

