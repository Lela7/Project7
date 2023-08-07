package Sablon.Test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sablon.Test.model.Format;
import Sablon.Test.model.Takmicenje;
import Sablon.Test.service.FormatService;
import Sablon.Test.support.FormatDTOToFormat;
import Sablon.Test.support.FormatToFormatDTO;
import Sablon.Test.web.dto.FormatDTO;
import Sablon.Test.web.dto.TakmicenjeDTO;

@RestController
@RequestMapping(value = "/api/formati", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FormatController {
	
	@Autowired
	private FormatService formatService;
	
	@Autowired
	private FormatToFormatDTO toFormatDTO;
	
	@Autowired
	private FormatDTOToFormat toFormat;
	
	
	
	

	  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FormatDTO> create(@Valid @RequestBody FormatDTO formatDTO){
	       Format format=toFormat.convert(formatDTO);
	       
	       Format sacuvanFormat = formatService.save(format);

	        return new ResponseEntity<>(toFormatDTO.convert(sacuvanFormat), HttpStatus.CREATED);
	    }
	
	
	 @GetMapping
		public ResponseEntity<List<FormatDTO>> getAll() {
			
			List<Format> formati = formatService.findAll();
		
			return new ResponseEntity<>(toFormatDTO.convert(formati), HttpStatus.OK);
		}
	 
	 
	 
	    @ExceptionHandler(value = DataIntegrityViolationException.class)
	    public ResponseEntity<Void> handle() {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	

}
