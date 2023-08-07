package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Takmicenje;
import Sablon.Test.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO>{
	
	public TakmicenjeDTO convert (Takmicenje takmicenje) {
	TakmicenjeDTO takmicenjeDTO= new TakmicenjeDTO();
	
	takmicenjeDTO.setId(takmicenje.getId());
	takmicenjeDTO.setNaziv(takmicenje.getNaziv());
	takmicenjeDTO.setMesto(takmicenje.getMesto());
	takmicenjeDTO.setPocetak(takmicenje.getPocetak());
	takmicenjeDTO.setZavrsetak(takmicenje.getZavrsetak());
	takmicenjeDTO.setFormatId(takmicenje.getFormat().getId());
	takmicenjeDTO.setFormatTip(takmicenje.getFormat().getTip());
	
	return takmicenjeDTO;
	}
	
	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja) {
		List<TakmicenjeDTO> takmicenjaDTO =new ArrayList<>();
		
		for(Takmicenje takmicenje : takmicenja) {
			takmicenjaDTO.add(convert(takmicenje));
		}
		
		return takmicenjaDTO;
	}
	

}
