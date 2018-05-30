import React, {Component} from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';

import {KorisniciList} from '../Components/Liste/KorisniciList.js';


import '../Style/Layout.css';


const { Header, Footer, Sider, Content } = Layout;


export class Korisnici extends Component{

    constructor(){
        super()
         
      }
 
    render(){

        return(
            <div>
                <Layout> 
                    <Sider style={{'width' : '50px'}}>Left Sider</Sider>                
                <Layout>
                    <MainMenuUser />

                    <Content>
                        <h1 align="center">Korisnici</h1>
                    <Row>
                    <Col span={18} offset={6}><KorisniciList/></Col>
                </Row>
                    </Content>
                    <FooterC/>
                </Layout>
                    <Sider>Right Sider</Sider>
                </Layout>
            </div>
      
        )
    }

}

