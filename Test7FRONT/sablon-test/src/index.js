import React from "react";
import {createRoot} from "react-dom/client";
import { Route, Link, HashRouter as Router, Routes, Navigate } from 'react-router-dom';
import { Navbar, Nav, Button, Container} from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login';
import {logout} from './services/auth';


import Prijava from "./components/takmicenja/Prijava";
import Takmicenja from "./components/takmicenja/Takmicenja";
import AddTakmicenje from "./components/takmicenja/AddTakmicenje";
import EditTakmicenje from "./components/takmicenja/EditTakmicenje";


class App extends React.Component{

    render(){
        const jwt = window.localStorage['jwt'];
    
        if (jwt){
          return(
            <>
            <Router>
            <Navbar expand bg="dark" variant="dark">
                            <Navbar.Brand as={Link} to="/">
                                Home
                            </Navbar.Brand>
                            <Nav>
                            <Nav.Link as={Link} to="/takmicenja">
                            Takmicenja
                            </Nav.Link>
                            <Button onClick={()=>logout()}>Logout</Button>
                            </Nav>
                        </Navbar>
                        <Container style={{paddingTop:"10px"}}>
                        <Routes>
                            <Route path="/" element={<Home/>}/>
                            <Route path="/login" element={<Navigate replace to='/'/>}/>
                            <Route path="/takmicenja" element={<Takmicenja/>} />  
                            <Route path="/takmicenja/add" element={<AddTakmicenje/>} /> 
                            <Route path="/takmicenja/edit:id" element={<EditTakmicenje/>} /> 
                            {/* <Route path="/formati" element={<Formati/>} />  */}
                            <Route path="/prijava/novaprijava/:id" element={<Prijava/>} />                       
                            <Route path='*' element={<Navigate replace to='/'/>} />
                        </Routes>
                        </Container>
            </Router>
            </>
          );
        }else{
          return(
            <>
            <Router>
            <Navbar expand bg="dark" variant="dark">
                            <Navbar.Brand as={Link} to="/">
                                Home
                            </Navbar.Brand>
                            <Nav>
                            <Nav.Link as={Link} to="/takmicenja">
                                 Takmicenja
                            </Nav.Link>
                            <Nav.Link as={Link} to="/login">
                                Login
                            </Nav.Link>
                            </Nav>
                        </Navbar>
                        <Container style={{paddingTop:"10px"}}>
                        <Routes>
                            <Route path="/" element={<Home/>}/>
                            <Route path="/login" element={<Login/>}/>
                            <Route path="/takmicenja" element={<Takmicenja/>} />                              
                            <Route path='*' element={<Navigate replace to='/'/>} />
                        </Routes>
                        </Container>
            </Router>
            </>);
        }
    }
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
  <App/>,
);