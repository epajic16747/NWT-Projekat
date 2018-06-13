import React, {Component}  from 'react';
import {TransportPonudeRow} from '../Rows/TransportPonudeRow';
import { Pagination ,Row,Col} from 'antd';
import axios from 'axios';

import '../../Style/SearchInput.css';
import '../../Style/index.css';


export class TransportPonudeList extends Component{
    constructor() {
        super()
            this.state={
               ponude :[
               ],
               loading: false,
               input : ''
           }

       }

  

    componentWillMount(){

    }

    componentDidMount(){
        var _this = this;
    this.serverRequest = 
      axios
        .get("http://localhost:9040/ponuda/ponude")
        .then(res => {
        const ponude = res.data;
        this.setState({ ponude });
        console.log(ponude)
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

        return(
             <div >
                <br/>
                <br/>
                {poruka}
                <Row type="flex" className="row_pregled_transporta">
                {
                (Object.keys(this.state.ponude)
                .map(key => <TransportPonudeRow key={key} index = {key} details={this.state.ponude[key]} />))
                }
                </Row>
              
                <Row>
                
                </Row>
            </div>

        )
    }

}


