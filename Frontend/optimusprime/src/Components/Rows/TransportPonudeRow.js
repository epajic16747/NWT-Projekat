import React, {Component}  from 'react';
import { Row, Col, Button } from 'antd';
import '../../Style/index.css';

export class TransportPonudeRow extends Component {
    
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
                       <h5>Naziv: {details.idPonuda}</h5>   
                        <h5>Cijena: {details.cijena}</h5>
                        <h5>Status transporta: {details.tipVozila}</h5>   
                     </div>
                    </Col>


    
            )
        }
    
    
    }