package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Prijava;
import Sablon.Test.service.PrijavaService;
import Sablon.Test.service.TakmicenjeService;
import Sablon.Test.web.dto.PrijavaDTO;

@Component
public class PrijavaDTOToPrijava implements Converter<PrijavaDTO, Prijava>{
	
	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private TakmicenjeService takmicenjeService;

	@Override
	public Prijava convert(PrijavaDTO dto) {
		
		Prijava prijava;
		
		if(dto.getId()==null) {
			prijava=new Prijava();
		}else {
			prijava=prijavaService.findOne(dto.getId());
		}
		
		if(prijava != null) {
			prijava.setId(dto.getId());
			prijava.setDrzava(dto.getDrzava());
			prijava.setKontakt(dto.getKontakt());
			prijava.setDatumPrijave(dto.getDatumPrijave());
			prijava.setTakmicenje(takmicenjeService.findOne(dto.getTakmicenjeId()));
		}
		return prijava;
	}
	
	

}
