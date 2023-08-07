package Sablon.Test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import Sablon.Test.model.Takmicenje;
import Sablon.Test.service.TakmicenjeService;
import Sablon.Test.support.TakmicenjeDTOToTakmicenje;
import Sablon.Test.support.TakmicenjeToTakmicenjeDTO;
import Sablon.Test.web.dto.TakmicenjeDTO;

@RestController
@RequestMapping(value = "/api/takmicenja", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TakmicenjeController {
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private TakmicenjeToTakmicenjeDTO toTakmicenjeDTO;
	
	@Autowired
	private TakmicenjeDTOToTakmicenje toTakmicenje;
	
	// @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TakmicenjeDTO> getOne(@PathVariable Long id){
        Takmicenje takmicenje = takmicenjeService.findOne(id);

        if(takmicenje != null) {
            return new ResponseEntity<>(toTakmicenjeDTO.convert(takmicenje), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<TakmicenjeDTO>> getAll(
    		 // @RequestParam(required=false) Long id,
            @RequestParam(required=false) String naziv,
            @RequestParam(required=false) String mesto,
            @RequestParam(required=false) String pocetak,
            @RequestParam(required=false) String zavrsetak,
            @RequestParam(required=false) Long formatId,
           @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){

        Page<Takmicenje> page;
        try{
            
            page = takmicenjeService.find(mesto, formatId, pageNo);
        }catch (Exception e){
            page = takmicenjeService.findAll(pageNo);
        }
        
       
        

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toTakmicenjeDTO.convert(page.getContent()), headers, HttpStatus.OK);
    }
	
	
	
	  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TakmicenjeDTO> create(@Valid @RequestBody TakmicenjeDTO takmicenjeDTO){
	        Takmicenje takmicenje=toTakmicenje.convert(takmicenjeDTO);

	        if(takmicenje.getFormat() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Takmicenje sacuvanoTakmicenje = takmicenjeService.save(takmicenje);

	        return new ResponseEntity<>(toTakmicenjeDTO.convert(sacuvanoTakmicenje), HttpStatus.CREATED);
	    }
	  
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TakmicenjeDTO> update(@PathVariable Long id, @Valid @RequestBody TakmicenjeDTO takmicenjeDTO){

	        if(!id.equals(takmicenjeDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Takmicenje takmicenje = toTakmicenje.convert(takmicenjeDTO);

	        if(takmicenje.getFormat() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Takmicenje sacuvanoTakmicenje = takmicenjeService.update(takmicenje);

	        return new ResponseEntity<>(toTakmicenjeDTO.convert(sacuvanoTakmicenje),HttpStatus.OK);
	    }

	   // @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
	        Takmicenje obrisanoTakmicenje = takmicenjeService.delete(id);

	        if(obrisanoTakmicenje != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	  
	  
	  @ExceptionHandler(value = DataIntegrityViolationException.class)
	    public ResponseEntity<Void> handle() {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }


	
	

}
