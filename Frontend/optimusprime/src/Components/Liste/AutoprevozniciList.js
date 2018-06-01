import React, {Component}  from 'react';
import {AutoprevoznikRow} from '../Rows/AutoprevoznikRow';

import '../../Style/SearchInput.css';


export class AutoprevozniciList extends Component{
    constructor() {
        super()
            this.state={
               korisnici :{
                   "0" : { "naiziv" : "A1", "email" : "enis.pajic1@gmail.com", "adresa" : "Trg Barcelone 6", "telefon" : "064-588-578"},
                   "1" : { "naiziv" : "A2", "email" : "enis.pajic2@gmail.com", "adresa" : "Trg Barcelone 60", "telefon" : "063-588-578"},
                   "2" : { "naiziv" : "A3", "email" : "enis.pajic3@gmail.com", "adresa" : "Trg Barcelone 60", "telefon" : "062-588-578"},
                   "3" : { "naiziv" : "A5", "email" : "enis.pajic4@gmail.com", "adresa" : "Trg Barcelone 60", "telefon" : "061-568-578"},
                   "4" : { "naiziv" : "A6", "email" : "enis.pajic5@gmail.com", "adresa" : "Trg Barcelone 60", "telefon" : "060-588-578"},
                   "5" : { "naiziv" : "A7", "email" : "enis.pajic6@gmail.com", "adresa" : "Trg Barcelone 60", "telefon" : "058-588-578"}
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
 
    obrisiAutoprevoznikaFront  = (index) => {

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
                <input  className="userSearch" type="text" name="search" placeholder="Unesite ime kompanije..." value={this.state.input} onChange={(e) => this.handleInput(e)}/>
                <br/>
                <br/>
                {poruka}
                {
                (Object.keys(this.state.korisnici)
                .map(key => <AutoprevoznikRow key={key} index = {key} details={this.state.korisnici[key]} obrisiAutoprevoznikaFront = {this.obrisiAutoprevoznikaFront } />))
                }

            </div>

        )
    }

}


