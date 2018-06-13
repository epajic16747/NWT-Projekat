import React, {Component}  from 'react';
import {TransportiRow} from '../Rows/TransportiRow';
import { Pagination ,Row,Col} from 'antd';
import axios from 'axios';

import '../../Style/SearchInput.css';
import '../../Style/index.css';


export class TransportiList extends Component{
    constructor() {
        super()
            this.state={
               transporti :[
               ],
               loading: false,
               input : '',
               zahtjev : false
           }

       }

  

    componentWillMount(){

    }

    componentDidMount(){
        var _this = this;
    this.serverRequest = 
      axios
        .get("http://localhost:9040/transport/transporti")
        .then(res => {
        const transporti = res.data;
        this.setState({ transporti });
        this.setState({ zahtjev : true });
        console.log(transporti)
      })
    }


    handleInput = (e) =>{

        this.setState({
                        loading: true,
                        input : e.target.value
        })
        const url = "Korisinici-korisnik/pretraga/" + e.target.value

        if(e.target.value !== ''){
            fetch(url ,{

            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                rijec : e.target.value
                })
            })
            .then(function(response){
                return response.json()
            }).then(json =>{
                console.log('Parsed json', json)
                this.setState({
                    korisnici: json,
                    loading : false,

                })

            })
            .catch(ex =>
                console.log('Zahtjev nije poslan serveru: ', ex)
            )
        }

    }
 
   /* obrisiKompanijuFront  = (index) => {

        const korisnici = {...this.state.korisnici};
        delete korisnici[index];

        this.setState({korisnici})
    };*/

    render(){
        let poruka = null;
        /*
        if(localStorage.getItem('token') === null){
            poruka =<Alert bsStyle="danger">
                          <h4>Nemate potrebne privilegije za pretragu!</h4>
                    </Alert>
        }*/
        if(this.state.zahtjev) {
        return(
             <div >
                <br/>
                <br/>
                {poruka}
                <Row type="flex" className="row_pregled_transporta">
                {
                (Object.keys(this.state.transporti)
                .map(key => <TransportiRow key={key} index = {key} details={this.state.transporti[key]} />))
                }
                </Row>
              
                <Row>
                
                </Row>
            </div>

        )
    }
    else {
        return(<div><h1>Trenutno nema transporta</h1></div>)
    }
    }

}


