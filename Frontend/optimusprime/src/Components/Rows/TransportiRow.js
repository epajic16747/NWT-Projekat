import React, {Component}  from 'react';
import { Row, Col, Button } from 'antd';
import '../../Style/index.css';

export class TransportiRow extends Component {
    
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
        /*obrisiKorisnika = () => {
    
            if(localStorage.getItem('token') !== null) {
                this.setState({loading: true})            
                const url = "http://localhost:8080/korisnik/obrisi/" + this.props.details.korisnikId;
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
        }*/
    
      
        render(){
            const {details} = this.props
            return (
                    <Col span={6}  className="col_pregled_transporta">
                      <div className="wrap_"> 
                       <h5>Naziv: {details.naziv}</h5>   
                        <h5>Cijena: {details.cijenaMax}</h5>
                        <h5>Status transporta: {details.status}</h5>   
                        <h5>Datum transporta : {details.datum} </h5>
                        <h5>ID transporta : {details.idTransporta} </h5>
                     </div>
                    </Col>


    
            )
        }
    
    
    }