package Sablon.Test.web.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


import Sablon.Test.model.Prijava;

public class TakmicenjeDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
	
	@NotBlank
	private String naziv;
	
	@NotBlank
	private String mesto;
	
	@NotBlank
	private String pocetak;
	
	@NotBlank
	private String zavrsetak;
	
	private Long formatId;
	private String formatTip;
	 
	
//	 private List<Prijava> prijave=new ArrayList<>();
//	 
//	public List<Prijava> getPrijave() {
//			return prijave;
//		}
//
//		public void setPrijave(List<Prijava> prijave) {
//			this.prijave = prijave;
//		}
		
		
	 
	 public TakmicenjeDTO() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPocetak() {
		return pocetak;
	}

	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}

	public String getZavrsetak() {
		return zavrsetak;
	}

	public void setZavrsetak(String zavrsetak) {
		this.zavrsetak = zavrsetak;
	}

	public Long getFormatId() {
		return formatId;
	}

	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}

	public String getFormatTip() {
		return formatTip;
	}

	public void setFormatTip(String formatTip) {
		this.formatTip = formatTip;
	}


	 
	 


}
