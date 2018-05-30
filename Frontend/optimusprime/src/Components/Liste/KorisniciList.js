import React, {Component}  from 'react';
import {KorisnikRow} from '../Rows/KorisnikRow';

import '../../Style/SearchInput.css';


export class KorisniciList extends Component{
    constructor() {
        super()
            this.state={
               korisnici :{
                   "0" : { "korisnickoIme" : "Test", "email" : "enis.pajic1@gmail.com", "sifra" : "15674346"},
                   "1" : { "korisnickoIme" : "Test", "email" : "enis.pajic1@gmail.com", "sifra" : "15674346"},
                   "2" : { "korisnickoIme" : "Test", "email" : "enis.pajic1@gmail.com", "sifra" : "15674346"},
                   "3" : { "korisnickoIme" : "Test", "email" : "enis.pajic1@gmail.com", "sifra" : "15674346"}
               },
               loading: false,
               input : ''
           }
       }
    componentWillMount(){

    }

    componentDidMount(){

       // if(localStorage.getItem('token') !== null) {
            this.setState({loading: true})
            const url = "Korisinici inicijalna";
            fetch(url ,{

            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id : 0
            })
            })
            .then(function(response){
                return response.json()
            }).then(json =>{

                console.log('Parsed json', json)
                this.setState({
                    korisnici: json,
                    loading : false
                })

            })
            .catch(ex =>
                console.log('Zahtjev nije poslan serveru: ', ex)
            )
       // }
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
 
    obrisiKorisnikaFront = (index) => {

        const korisnici = {...this.state.korisnici};
        delete korisnici[index];

        this.setState({korisnici})
    };

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
                <input  className="userSearch" type="text" name="search" placeholder="Unesite ime korisnika..." value={this.state.input} onChange={(e) => this.handleInput(e)}/>
                <br/>
                <br/>
                {poruka}
                {
                (Object.keys(this.state.korisnici)
                .map(key => <KorisnikRow key={key} index = {key} details={this.state.korisnici[key]} obrisiKorisnikaFront = {this.obrisiKorisnikaFront} />))
                }

            </div>

        )
    }

}


