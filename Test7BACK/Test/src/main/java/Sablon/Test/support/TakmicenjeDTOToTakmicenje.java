package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Takmicenje;
import Sablon.Test.service.FormatService;
import Sablon.Test.service.TakmicenjeService;
import Sablon.Test.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeDTOToTakmicenje implements Converter<TakmicenjeDTO, Takmicenje>{
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private FormatService formatService;
	
	
	@Override
	public Takmicenje convert(TakmicenjeDTO dto) {
		
		Takmicenje takmicenje;
		
		if(dto.getId()==null) {
			takmicenje=new Takmicenje ();
		} else {
			takmicenje=takmicenjeService.findOne(dto.getId());
		}
		
		if(takmicenje !=null) {
			takmicenje.setId(dto.getId());
			takmicenje.setNaziv(dto.getNaziv());
			takmicenje.setMesto(dto.getMesto());
			takmicenje.setPocetak(dto.getPocetak());
			takmicenje.setZavrsetak(dto.getZavrsetak());
			takmicenje.setFormat(formatService.findOne(dto.getFormatId()));
		}
		return takmicenje;
		
	}

}
