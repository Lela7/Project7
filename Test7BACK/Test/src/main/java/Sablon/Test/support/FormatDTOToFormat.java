package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Format;
import Sablon.Test.service.FormatService;
import Sablon.Test.web.dto.FormatDTO;

@Component
public class FormatDTOToFormat implements Converter<FormatDTO, Format>{

	@Autowired
	private FormatService formatService;
	
	
	@Override
	public Format convert(FormatDTO dto) {
		Format format;
		
		if(dto.getId()== null) {
			format = new Format();
		} else {
			format=formatService.findOne(dto.getId());
	}
	
	if(format !=null) {
		format.setId(dto.getId());
		format.setTip(dto.getTip());
		format.setBrojUcesnika(dto.getBrojUcesnika());
		
		
	}
		
	return format;
	

}
}
