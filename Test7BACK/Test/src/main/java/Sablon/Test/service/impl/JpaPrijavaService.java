package Sablon.Test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Prijava;
import Sablon.Test.repository.PrijavaRepository;
import Sablon.Test.service.PrijavaService;

@Service
public class JpaPrijavaService implements PrijavaService{
	
	@Autowired
	private PrijavaRepository prijavaRepository;

	@Override
	public Prijava findOne(Long id) {
		return prijavaRepository.findOneById(id);
	}

	@Override
	public List<Prijava> findAll() {
		return prijavaRepository.findAll();
	}

	@Override
	public Prijava save(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}
	
	

}
