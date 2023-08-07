package Sablon.Test.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Format;
import Sablon.Test.repository.FormatRepository;
import Sablon.Test.service.FormatService;

@Service
public class JpaFormatService implements FormatService {
	
	@Autowired
	private FormatRepository formatRepository;

	@Override
	public Format findOne(Long id) {
		return formatRepository.findOneById(id);
	}

	@Override
	public List<Format> findAll() {
		return formatRepository.findAll();	
		}

	@Override
	public Format save(Format format) {
		return formatRepository.save(format);
	}
	

}
