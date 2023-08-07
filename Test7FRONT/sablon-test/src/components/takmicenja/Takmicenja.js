import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import Axios from "../../apis/Axios";
import {withParams ,withNavigation} from '../../routeconf';
import './../../index.css';


class Takmicenja extends React.Component{

    constructor(props){
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        const search = {
          formatId: "",
         mesto:""
        }

        this.state = {
            takmicenja: [],
            formati: [],
            prijave: [],
            search: search,
            showing: true
        }

    }

    componentDidMount(){
        this.getTakmicenja(0)
        this.getFormati()
    }

    async getTakmicenja(newPageNo){

        let config = {
          params: {
            formatId: this.state.search.formatId,
            mesto: this.state.search.mesto,
            pageNo: newPageNo
          }
        }
        
        try {
            let result = await Axios.get("/takmicenja", config)
            this.pageNo = newPageNo
            this.totalPages = result.headers["total-pages"]
            this.setState({
                takmicenja: result.data
            })
        } catch (error) {
            console.log(error)
        }
    }

    getFormati(){
      Axios.get("/formati")
      .then((res) => {
        this.setState({formati: res.data})
      })
      .catch((error) => {
        console.log(error)
      })
    }

    goToAdd(){
        this.props.navigate("/takmicenja/add")
    }

    goToEdit(id){
      this.props.navigate("/takmicenja/edit" + id)
    }

    goToPrijava(id){

      this.props.navigate("/prijava/novaprijava/" + id)
      
      // let config = {
      //     datumPrijave: "2005-05-05",
      //     disciplina: "tenis", //uneto - treba
      //     takmicarId: id, //treba
      //     takmicarImeIPrezime: ""
      // }

      // OlimpijadaAxios.post("/prijava/novaprijava", config)
      // .then((res) => {
      //  alert("bravo");
      // })
      // .catch((error) => {
      //   console.log(error)
      // })

    }

    deleteFromState(takmicenjeId){
      var takmicenja = this.state.takmicenja
      takmicenja.forEach((element, index) => {
        if(element.id === takmicenjeId){
          takmicenja.splice(index, 1)
          this.setState({takmicenja: takmicenja})
        }
      })
    }

    goToDelete(takmicenjeId){
      Axios.delete("/takmicenja/" + takmicenjeId)
      .then(res => {
        console.log(res)
        alert("Uspesno brisanje takmicenja")
        this.deleteFromState(takmicenjeId)

      })
      .catch(error => {
        console.log(error)
        window.location.reload()
      })

    }

    onInputChange(event) {
      const name = event.target.name;
      const value = event.target.value

      let search = this.state.search;
      search[name] = value;

      this.setState({ search })
  }

//   goToStatistika(){
//     this.props.navigate("/takmicari/statistika")
//   }

    renderSearchForm(){
      return(
      <>
          <Form style={{ width: "100%"}}>
              <Row><Col>
                  <Form.Group>
                      <Form.Label>Mesto odrzavanja</Form.Label>
                      <Form.Control
                          name="mesto"
                          as="input"
                          type="text"
                          onChange={(e)=>this.onInputChange(e)}>
                      </Form.Control>
                  </Form.Group>
              </Col>
              </Row>
             
              <Row>
                <Col>
                  <Form.Group>
                      <Form.Label>Format</Form.Label>
                      <Form.Select
                          name="formatId"
                          onChange={(e)=>this.onInputChange(e)}>
                          <option value=""></option>
                          {this.state.formati.map((format) =>{
                              return(
                                  <option value={format.id}>{format.tip}</option>
                              );
                          })}
                      </Form.Select>
                  </Form.Group>
              </Col>
              </Row>
          </Form>
          <Row><Col>
              <Button className="mt-3" onClick={()=>this.getTakmicenja()}>Search</Button>
              <br/>
              <br/>
          </Col>
          </Row>
      </>
      )
 }



    render(){
        return(
          <Col>
            <Row>Takmicenja</Row>
                <label>
                    <input type="checkbox" onChange={()=>this.setState({showing: !this.state.showing})}/>
                      Search
                </label>
                <div>
                <Row hidden={this.state.showing}>
                    {this.renderSearchForm()}   
                </Row>    
                </div>
                <Row><Col>

                {/* {window.localStorage['role'] == 'ADMIN' ? */}
               {/* [ */}
                <Button onClick={() => this.goToAdd() }>Kreiraj takmicenje</Button>
                {/* <Button onClick={() => this.goToStatistika() }>Statistika</Button> */}
               {/* ] */}
                {/* : null} */}
                </Col></Row>

                <Row><Col>
                
                </Col></Row>
                <Row><Col>

                <Table style={{marginTop: 5}}>
                <thead>
                  <tr>
                    <th>Naziv Takmicenja</th>
                    <th>Mesto odrzavanja</th>
                    <th>Datum pocetka takmicenja</th>
                    <th>Datum zavrsetka takmicenja</th>
                    <th>Format</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.takmicenja.map((takmicenje) => {
                    return (
                      <tr key={takmicenje.id}>
                        <td>{takmicenje.naziv}</td>
                        <td>{takmicenje.mesto}</td>
                        <td>{takmicenje.pocetak}</td>
                        <td>{takmicenje.zavrsetak}</td>
                        <td>{takmicenje.formatTip}</td>
                        {/* {window.localStorage['role'] == 'ADMIN' ? */}
                        {/* [ */}
                         <td><Button variant="warning" onClick={() => this.goToEdit(takmicenje.id)}>Edit</Button></td>
                        <td><Button variant="danger" onClick={() => this.goToDelete(takmicenje.id)}>Delete</Button></td>
                        {/* ] */}
                      {/* : null} */}

                      
                        
                        <td><Button variant="secondary" onClick={() => this.goToPrijava(takmicenje.id)}>Prijavi se</Button></td>
                        
                       
                      </tr>
                    );
                  })}
                </tbody>
              </Table>
              <Button disabled={this.pageNo===0} onClick={()=>this.getTakmicenja(this.pageNo-1)} className="mr-3">Prethodna</Button>
              <Button disabled={this.pageNo==this.totalPages-1} onClick={()=>this.getTakmicenja(this.pageNo+1)} className="mr-3">Sledeca</Button>
              </Col></Row>
        </Col>
        )
    }

}

export default withNavigation(withParams(Takmicenja))