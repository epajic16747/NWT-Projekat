import React from 'react'
import { Switch, Route, BrowserRouter} from 'react-router-dom'
import {ModalForm} from './Components/Forms/ModalForm.js'
import {Home} from './Views/Home.js';
import App from './Components/App.js';
import {UserRegistration} from './Views/UserRegistration.js';
import {RegistracijaKompanije} from './Views/RegistracijaKompanije.js';
import {RegistracijaAutoprevoznika} from './Views/RegistracijaAutoprevoznika.js';
import {RegistracijaTransporta} from './Views/RegistracijaTransporta.js'
import {Korisnici} from './Views/Korisnici.js';
import { Kompanije } from './Views/Kompanije';
import { Autoprevoznici } from './Views/Autoprevoznici';



 export const routes = ( 
    
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={App}/> 
            <Route path="/home" component={Home}/> 
            <Route path="/signIn" render={(props) =>( <ModalForm {...props} forma={""}/>)}/>         
            <Route path="/registracijaKorisnika" component={UserRegistration}/>     
            <Route path="/kreirajKompaniju" component={RegistracijaKompanije}/>     
            <Route path="/kreirajAutoprevoznika" component={RegistracijaAutoprevoznika}/>   
            <Route path="/kreirajTransport" component={RegistracijaTransporta}/>   
            <Route path="/korisnici" component={Korisnici}/>    
            <Route path="/kompanije" component={Kompanije} />           
            <Route path="/autoprevoznici" component={Autoprevoznici} />


        </Switch>
    </BrowserRouter>

)
/*


<Route component={NotFound}></Route>

            <Route path="/signIn" render={(props) =>( <ModalForm {...props} forma={""}/>)}/>
            <Route path="/signUp" render={ (props) => (<ModalForm  {...props} forma={"User registration"}/>)}/>   
             <Route exact path="/" render={(props) =>( <ModalForm {...props} forma={""}/>)}/> 
*/