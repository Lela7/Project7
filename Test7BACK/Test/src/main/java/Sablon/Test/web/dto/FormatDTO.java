package Sablon.Test.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import Sablon.Test.model.Takmicenje;

public class FormatDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

	@NotBlank
	private String tip;
	
	
	private int brojUcesnika;
	
	
//	private List<Takmicenje> takmicenja=new ArrayList<> ();
//	
//	public List<Takmicenje> getTakmicenja() {
//		return takmicenja;
//	}
//
//	public void setTakmicenja(List<Takmicenje> takmicenja) {
//		this.takmicenja = takmicenja;
//	}

	
	public FormatDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrojUcesnika() {
		return brojUcesnika;
	}

	public void setBrojUcesnika(int brojUcesnika) {
		this.brojUcesnika = brojUcesnika;
	}

	
	
}
