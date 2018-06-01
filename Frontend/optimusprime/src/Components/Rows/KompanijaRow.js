import React, {Component}  from 'react';
import { Row, Col, Button } from 'antd';

export class KompanijaRow extends Component {
    
        constructor(props){
            super();
            this.props = props;
        }
        //Ovo se izvrsava nakon prvog rendera
        componentWillMount(){
            this.style={
                backgroundColor: '#949ba8',
                marginTop: '25px',
                borderRadius: '25px'
            }
        }
        obrisiKompaniju = () => {
    
            if(localStorage.getItem('token') !== null) {
                this.setState({loading: true})            
                const url = "http://localhost:8080/kompanija/obrisi/" + this.props.details.korisnikId;
                fetch(url ,{
                
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                  },
                  body: JSON.stringify({
                    id : this.props.details.korisnikId
                  })
                })
                .catch(ex =>
                    console.log('Zahtjev nije poslan serveru: ', ex)
                )
            }   
            this.setState({loading: false}) 
            console.log('index:',this.props.index)
            this.props.obrisiKorisnikaFront(this.props.index);
        }
    
      
        render(){
            const {details} = this.props
            return (
                <Row>
                    <Col span={8}>
                        <h4>Naziv kompanije : {details.naziv} </h4>
                        <h5>Opis: {details.opis}</h5>
                        <h5>Adresa: {details.adresa}</h5>
                        <h5>Telefon" {details.telefon}</h5>
                        <h5>Email: {details.email}</h5>
     
                                                                    
                    </Col>
                    <Col span={8}></Col>
                    <Col span={8}>
 
                        <br />               
                        <Button type="danger"   style={{marginTop: '8px',width : '170px'}} onClick={this.obrisiKompaniju} >Obrisi</Button>
                    </Col>
                </Row>


    
            )
        }
    
    
    }