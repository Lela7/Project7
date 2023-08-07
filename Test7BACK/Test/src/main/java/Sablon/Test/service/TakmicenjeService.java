package Sablon.Test.service;

import org.springframework.data.domain.Page;

import Sablon.Test.model.Takmicenje;

public interface TakmicenjeService {
	
	Takmicenje findOne(Long id);
	
	Page<Takmicenje> findAll(Integer pageNo);
	
	Takmicenje save (Takmicenje takmicenje);
	
	Takmicenje update(Takmicenje takmicenje);
	
	Takmicenje delete(Long id);
	
	Page<Takmicenje> find(String mesto, Long formatId, Integer pageNo);

}
