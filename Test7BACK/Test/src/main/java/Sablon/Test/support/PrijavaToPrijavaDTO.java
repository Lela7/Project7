package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Prijava;
import Sablon.Test.web.dto.PrijavaDTO;

@Component
public class PrijavaToPrijavaDTO implements Converter<Prijava, PrijavaDTO>{

	@Override
	public PrijavaDTO convert(Prijava prijava) {
		PrijavaDTO prijavaDTO =new PrijavaDTO ();
		
		prijavaDTO.setId(prijava.getId());
		prijavaDTO.setDrzava(prijava.getDrzava());
		prijavaDTO.setKontakt(prijava.getKontakt());
		prijavaDTO.setDatumPrijave(prijava.getDatumPrijave());
		prijavaDTO.setTakmicenjeId(prijava.getTakmicenje().getId());
		prijavaDTO.setTakmicenjeNaziv(prijava.getTakmicenje().getNaziv());
		
		return prijavaDTO;
		
	}
	
	public List<PrijavaDTO> convert (List <Prijava> prijave) {
			List<PrijavaDTO> prijaveDTO =new ArrayList<>();
			
			for(Prijava prijava : prijave) {
				prijaveDTO.add(convert(prijava));
			}
			return prijaveDTO;
	}
	
	

}
