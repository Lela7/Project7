package Sablon.Test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Sablon.Test.model.Prijava;
import Sablon.Test.service.PrijavaService;
import Sablon.Test.support.PrijavaDTOToPrijava;
import Sablon.Test.support.PrijavaToPrijavaDTO;

import Sablon.Test.web.dto.PrijavaDTO;


@RestController
@RequestMapping(value = "/api/prijave", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrijavaController {

	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private PrijavaToPrijavaDTO toPrijavaDTO;
	
	@Autowired
	private PrijavaDTOToPrijava toPrijava;
	
	
	// @PreAuthorize("hasRole('USER')")
	    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PrijavaDTO> create(@Valid @RequestBody PrijavaDTO prijavaDTO){
		 
	        Prijava prijava = toPrijava.convert(prijavaDTO);
	        Prijava sacuvanaPrijava = prijavaService.save(prijava);

	        return new ResponseEntity<>(toPrijavaDTO.convert(sacuvanaPrijava), HttpStatus.CREATED);
	    }
	
//		 @GetMapping
//		public ResponseEntity<List<PrijavaDTO>> getAll() {			
//			List<Prijava> prijave = prijavaService.findAll();		
//			return new ResponseEntity<>(toPrijavaDTO.convert(prijave), HttpStatus.OK);
//		}
//	 
	 
	 
	    @ExceptionHandler(value = DataIntegrityViolationException.class)
	    public ResponseEntity<Void> handle() {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	
	
}
