import React, { Component}  from 'react';
import { MainMenuUser } from '../Components/Menus/MainMenuUser';
import { FooterC } from '../Components/Menus/FooterC';
import { Row, Col } from 'antd';
import { Layout } from 'antd';
import { Card } from 'antd';


import '../Style/Layout.css';

const { Header, Footer, Sider, Content } = Layout;
const { Meta } = Card;

 export class Home extends Component {

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
                        <Row>
                        <h1 align="center">Welcome to E-parfumerija!</h1>
                        <p align="center">Ukoliko tražite vaš savršen parfem ovo je pravo mjesto za Vas</p>
                        </Row>
                        <Row>
                            <Col span={8}>
                                <Card
                                    hoverable
                                    style={{ width: 240 }}
                                    cover={<img alt="example"  /*src={require('../assets/PageImages/HomeCarouselPictures/Info1.jpg')} *//>}
                                >
                                    <Meta
                                    title= "Coco Chanel"
                                    description="Sjecas li se kao nekad"
                                    />
                                </Card>
                                <h5>Lorem Ipsum is simply dummy text of the printing and typesetting indummy text ever since the 1500s, when any
                                     of type and scrambled it to make a type 
                                    specimen book. It has survived not only five centuries, but also the leap into electroni</h5>                                
                            </Col>
                            <Col span={8}> 
                                <Card
                                    hoverable
                                    style={{ width: 240 }}
                                    cover={<img alt="example" /*src={require('../assets/PageImages/HomeCarouselPictures/Info2.jpg')}*/ />}
                                >
                                    <Meta
                                    title="Idealan poklon za ?"
                                    description="Jefitni i brzo"
                                    />
                                </Card>
                                <h5>Lorem Ipsum is simply dummy text of the printing and typesetting indummy text ever since the 1500s, when any
                                     of type and scrambled it to make a type 
                                    specimen book. It has survived not only five centuries, but also the leap into electroni</h5>                                
                            </Col>
                            <Col span={8}>
                                <Card
                                    hoverable
                                    style={{ width: 240 }}
                                    cover={<img alt="example" /* src={require('../assets/PageImages/HomeCarouselPictures/Info3.jpg')}*/ />}
                                >
                                    <Meta
                                    title="Bla bla bla"
                                    description="bla bla"
                                    />
                                </Card>
                                <h5>Lorem Ipsum is simply dummy text of the printing and typesetting indummy text ever since the 1500s, when any
                                     of type and scrambled it to make a type 
                                    specimen book. It has survived not only five centuries, but also the leap into electroni</h5>
                            </Col>
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


