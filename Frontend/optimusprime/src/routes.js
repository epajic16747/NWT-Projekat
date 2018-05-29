import React from 'react'
import { Switch, Route, BrowserRouter} from 'react-router-dom'
import {ModalForm} from './Components/Forms/ModalForm.js'
import {Home} from './Views/Home.js';



 export const routes = ( 
    
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Home}/> 
            <Route path="/signIn" render={(props) =>( <ModalForm {...props} forma={""}/>)}/>         
            <Route path="/signUp" render={(props) =>( <ModalForm {...props} forma={"User registration"}/>)}/>     

        </Switch>
    </BrowserRouter>

)
/*


<Route component={NotFound}></Route>

            <Route path="/signIn" render={(props) =>( <ModalForm {...props} forma={""}/>)}/>
            <Route path="/signUp" render={ (props) => (<ModalForm  {...props} forma={"User registration"}/>)}/>   
             <Route exact path="/" render={(props) =>( <ModalForm {...props} forma={""}/>)}/> 
*/