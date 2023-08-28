package Sablon.Test.web.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;



public class PrijavaDTO {
	
	@Positive(message = "Id mora biti pozitivan broj.")
	 private Long id;
	 
	//@NotBlank
	 private String drzava;
	 
	@NotBlank
	 private String kontakt;
	 
	@NotBlank
	 private String datumPrijave;
	 
	//@NotBlank
	 private Long takmicenjeId;
	 
	 private String takmicenjeNaziv;
	 
	 public PrijavaDTO() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(String datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

	public String getTakmicenjeNaziv() {
		return takmicenjeNaziv;
	}

	public void setTakmicenjeNaziv(String takmicenjeNaziv) {
		this.takmicenjeNaziv = takmicenjeNaziv;
	}
	 
	 

}
