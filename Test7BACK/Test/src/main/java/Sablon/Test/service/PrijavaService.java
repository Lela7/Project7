package Sablon.Test.service;

import java.util.List;

import Sablon.Test.model.Prijava;

public interface PrijavaService {

	Prijava findOne(Long id);
	
	List<Prijava> findAll();
	
	Prijava save (Prijava prijava);
	
//	Prijava update (Prijava prijava);
//	
//	Prijava delete(Long id);
}
