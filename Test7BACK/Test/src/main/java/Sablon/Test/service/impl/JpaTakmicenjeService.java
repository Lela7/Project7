package Sablon.Test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Takmicenje;
import Sablon.Test.repository.TakmicenjeRepository;
import Sablon.Test.service.TakmicenjeService;

@Service
public class JpaTakmicenjeService implements TakmicenjeService{
	
	@Autowired
	private TakmicenjeRepository takmicenjeRepository;

	@Override
	public Takmicenje findOne(Long id) {
		return takmicenjeRepository.findOneById(id);
	}

	@Override
	public Page<Takmicenje> findAll(Integer pageNo) {
		return takmicenjeRepository.findAll( PageRequest.of(pageNo, 2));
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		Takmicenje takmicenje =findOne(id);
		if(takmicenje != null) {
			takmicenje.getFormat().getTakmicenja().remove(takmicenje);
			takmicenjeRepository.delete(takmicenje);
			return takmicenje;
		}
		return null;
	}

	@Override
	public Page<Takmicenje> find(String mesto, Long formatId, Integer pageNo) {
		if (mesto == null) {
			mesto="";
		}
		
		if (formatId == null) {
			return takmicenjeRepository.findByMestoIgnoreCaseContains(mesto, PageRequest.of(pageNo, 2));
		}
		
		return takmicenjeRepository.findByMestoIgnoreCaseContainsAndFormatId(mesto, formatId, PageRequest.of(pageNo, 2));
	}
	
	

}
