import React from "react";
import { Row, Col, Button, Table, Form, Tab } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import {withParams ,withNavigation} from '../../routeconf';

class Prijava extends React.Component{

    constructor(props){
        super(props)

        let prijava = {
            drzava: "",
            kontak: "",
            datumPrijave: ""
            
        }

        this.state = { prijava: prijava}
    }

    // componentDidMount(){
    //     this.getTakmicari()
    // }

    // async getTakmicari(){
    //     try {
    //         let result = await OlimpijadaAxios.get("/takmicari")
    //         let takmicari = result.data
    //         console.log("ucitavanje drzava")
    //     } catch (error) {
    //         console.log(error)
    //     }
    // }

    create(){
        var params = {
            "drzava": this.state.drzava,
            "kontakt": this.state.kontakt,
            "datumPrijave": this.state.datumPrijave,

            "takmicenjeId": this.state.takmicenjeId,
        }

        Axios.post("/prijave", params)
        .then(res => {
            console.log(res)
            alert("bravo");
        })
        .catch(error => {
            console.log(error)
        })
    }

    // async create(e){
    //     e.preventDefault()

        
    //     let prijava = this.state.prijava
    //     let prijavaDTO = {
    //         datumPrijave: prijava.datumPrijave,
    //         disciplina: prijava.disciplina,
    //         takmicarId: prijava.takmicarId,
    //         takmicarImeIPrezime: prijava.takmicarImeIPrezime
    //     }

    //     OlimpijadaAxios.post("/prijava/novaprijava", prijavaDTO)
    //     .then((res) => {
    //         this.props.navigate("/takmicari")
    //         console.log(res)
    //     })
    //     .catch((error) => {
    //         console.log(error)
    //     })
             
    // }

    valueInputChanged(event) {
        let input = event.target;

        let name = input.name;
        let value = input.value;

        let prijava = this.state.prijava;
        prijava[name] = value;

        this.setState({ prijava: prijava });
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Prijava</h1>

                        <Form>
                            <Form.Group>
                                <Form.Label>Email</Form.Label>
                                <Form.Control
                                    id="kontakt" name="kontakt" type="email" onChange={(event) => this.valueInputChanged(event)} /> <br />
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Drzava</Form.Label>
                                <Form.Control
                                    id="drzava" name="drzava"  onChange={(event) => this.valueInputChanged(event)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Datum prijave</Form.Label>
                                <Form.Control
                                    id="datumPrijave" name="datumPrijave" onChange={(event) => this.valueInputChanged(event)} /> <br />
                            </Form.Group>

                            <Button onClick={(e) => { this.create(e); }}>Prijavi se</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }


}

export default withNavigation(Prijava);