import React from "react";
import Axios from "../../apis/Axios";
import { Button, Col, Form, Row } from 'react-bootstrap';
import { withNavigation, withParams } from '../../routeconf'

class EditTakmicenje extends React.Component{

    state = {
        takmicenjeId: -1,
        takmicenjeNaziv: "",
        takmicenjeMesto: "",
        takmicenjePocetak: "",
        takmicenjeZavrsetak: "",
        takmicenjeFormatId: "",
        formati: []
    }

    componentDidMount(){
        var id = this.props.params.id
        this.getFormati()
        this.getTakmicenjeById(id)
    }

    async getFormati(){
        try {
            let result = await Axios.get("/formati")
            let formati = result.data
            this.setState({formati: formati})
            console.log("test1")
        } catch (error) {
            console.log(error)
            alert("Ne mogu se naci formati")
        }
    }

    getTakmicenjeById(takmicenjeId){
        Axios.get("/takmicenja/" + takmicenjeId)
        .then(res => {
            console.log(res)
            this.setState({
                takmicenjeId: res.data.id,
                takmicenjeNaziv: res.data.naziv,
                takmicenjeMesto: res.data.mesto,
                takmicenjePocetak: res.data.pocetak,
                takmicenjeZavrsetak: res.data.zavrsetak,
                takmicenjeFormatId: res.data.formatId,
                takmicenjeFormatTip: res.data.formatTip
            })
        })
        .catch(error => {
            console.log(error)
        })
    }

    edit(takmicenjeId){
        var params = {
            "id": this.state.takmicenjeId,
            "naziv": this.state.takmicenjeNaziv,
            "mesto": this.state.takmicenjeMesto,
            "pocetak": this.state.takmicenjePocetak,
            "zavrsetak": this.state.takmicenjeZavrsetak,
            "formatId": this.state.takmicenjeFormatId,
            // "formatTip": this.state.takmicenjeFormatTip
        }
    Axios.put("/takmicenja/" + this.state.takmicenjeId, params)
        .then(res => {
            console.log(res)
            this.props.navigate("/takmicenja")
        })
        .catch(error => {
            console.log(error)
        })
    }

    onNazivChange(e){
        console.log(e.target.value)
        this.setState({takmicenjeNaziv: e.target.value})
    }

    onMestoChange(e){
        console.log(e.target.value)
        this.setState({takmicenjeMesto: e.target.value})
    }

    onPocetakChange(e){
        console.log(e.target.value)
        this.setState({takmicenjePocetak: e.target.value})
    }


    onZavrsetakChange(e){
        console.log(e.target.value)
        this.setState({takmicenjeZavrsetak: e.target.value})
    }

    formatSelectionChanged(e){
        let formatId = e.target.value
        let format = this.state.formati.find((format) => format.id == formatId)

        this.state.takmicenjeFormatId = format.id
        // this.state.takmicenjeFormatTip = format.tip
    }

    render(){
        return (
            <>
            <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
            <h1>Izmena takmicenja</h1>
            <Form>
                    <Form.Group>
                    <Form.Label htmlFor="naziv">Naziv</Form.Label>
                    <Form.Control id="naziv" name="naziv" value={this.state.takmicenjeNaziv} onChange={(e) => this.onNazivChange(e)}/> <br/>
                    </Form.Group>

                    <Form.Group>
                    <Form.Label htmlFor="mesto">Mesto</Form.Label>
                    <Form.Control id="mesto" name="mesto" type="text" value={this.state.takmicenjeMesto} onChange={(e) => this.onMestoChange(e)}/> <br/>
                    </Form.Group>

                    <Form.Group>
                    <Form.Label htmlFor="pocetak">Pocetak</Form.Label>
                    <Form.Control id="pocetak" name="pocetak" value={this.state.takmicenjePocetak} onChange={(e) => this.onPocetakChange(e)}/> <br/>
                    </Form.Group>


                    <Form.Group>
                    <Form.Label htmlFor="zavrsetak">Zavrsetak</Form.Label>
                    <Form.Control id="zavrsetak" name="zavrsetak" value={this.state.takmicenjeZavrsetak} onChange={(e) => this.onZavrsetakChange(e)}/> <br/>
                    </Form.Group>


                    <Form.Group>
                    <Form.Label htmlFor="formatId">Format</Form.Label>
                    <Form.Control as="select" id="formatId"  onChange={event=>this.formatSelectionChanged(event)}>
                        <option>{this.state.takmicenjeFormatId}</option>
                        {
                            this.state.formati.map((format) => {
                                return(
                                    <option key={format.id} value={format.id}>{format.tip}</option>
                                )
                            })
                        }
                    </Form.Control><br/>
                   </Form.Group>
                <Button onClick={() => this.edit(this.state.takmicenjeId)}>Edit</Button>
                </Form>
                </Col>
                <Col></Col>
            </Row>
            </>
        )
    }



}

export default withParams(withNavigation(EditTakmicenje))