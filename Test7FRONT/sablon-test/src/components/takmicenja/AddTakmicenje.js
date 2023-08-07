import React from 'react';
import { Row, Col, Form, Button } from "react-bootstrap";
import Axios from '../../apis/Axios';
import {withParams ,withNavigation} from '../../routeconf';

class AddTakmicenje extends React.Component{

    constructor(props){
        super(props)

        let takmicenje = {
            naziv: "",
            mesto: "",
            pocetak: "",
            zavrsetak: "",
            drzavaNaziv: ""
        }

        this.state = { takmicenje: takmicenje, formati: []}
    }

    componentDidMount(){
        this.getFormati()
    }

    async getFormati(){
        try {
            let result = await Axios.get("/formati")
            let formati = result.data
            this.setState({formati: formati})
            console.log("ucitavanje formata")
        } catch (error) {
            console.log(error)
        }
    }

    async create(e){
        e.preventDefault()

        try {
            let takmicenje = this.state.takmicenje
            let takmicenjeDTO = {
                naziv: takmicenje.naziv,
               mesto:takmicenje.mesto,
                pocetak: takmicenje.pocetak,
                zavrsetak: takmicenje.zavrsetak,
                formatId: takmicenje.formatId
            }

            let response = await Axios.post("/takmicenja", takmicenjeDTO)
            this.props.navigate("/takmicenja")
        } catch (error) {
            alert("Ne moze se sacuvati takmicenje")
        }
    }

    valueInputChanged(e) {
        let input = e.target;

        let name = input.name;
        let value = input.value;

        let takmicenje = this.state.takmicenje;
        takmicenje[name] = value;

        this.setState({ takmicenje: takmicenje });
    }

    formatSelectionChanged(e){
        let formatId = e.target.value
        let format = this.state.formati.find((format) => format.id == formatId)

        let takmicenje = this.state.takmicenje
        takmicenje.formatId = format.id
        takmicenje.formatTip = format.tip

        this.setState({ takmicenje: takmicenje})
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Dodaj takmicenje</h1>

                        <Form>
                            <Form.Group>
                                <Form.Label>Naziv takmicenje</Form.Label>
                                <Form.Control
                                    id="naziv" name="naziv" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Mesto odrzavanja</Form.Label>
                                <Form.Control type="text" id="mesto" name="mesto" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Datum pocetka</Form.Label>
                                <Form.Control id="pocetak" name="pocetak" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Datum zavrsetka</Form.Label>
                                <Form.Control id="zavrsetak" name="zavrsetak" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Format</Form.Label>
                                <Form.Select name="format" onChange={event => this.formatSelectionChanged(event)}>
                                    <option></option>
                                    {
                                        this.state.formati.map((format) => {
                                            return (
                                                <option key={format.id} value={format.id}>{format.tip}</option>
                                            )
                                        })
                                    }
                                </Form.Select><br />
                            </Form.Group>

                            <Button onClick={(event) => { this.create(event); }}>Kreiraj takmicenje</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }

}

export default withNavigation(AddTakmicenje);