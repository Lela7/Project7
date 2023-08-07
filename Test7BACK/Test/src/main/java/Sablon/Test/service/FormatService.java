package Sablon.Test.service;


import java.util.List;

import Sablon.Test.model.Format;

public interface FormatService {
	
	Format findOne(Long id);
	
	List<Format> findAll();

	Format save(Format format);
	
	

}
