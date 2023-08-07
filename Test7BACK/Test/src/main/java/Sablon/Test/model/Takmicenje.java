package Sablon.Test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//Id - identifikator
//Naziv - tekstualna, jedinstvena vrednost
//Mesto održavanja - obavezna vrednost
//Datum početka- obavezna vrednost
//Datum završetka - obavezna vrednost
//Format - veza sa instancom klase Format (jedno takmičenje imati samo jedan
//format, dok više takmičenja može biti istog formata

@Entity
public class Takmicenje {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique=true)
	private String naziv;
	
	@Column(nullable=false)
	private String mesto;
	
	@Column(nullable=false)
	private String pocetak;
	
	@Column(nullable=false)
	private String zavrsetak;
	
	 @ManyToOne
	private Format format;
	 
	 @OneToMany(mappedBy = "takmicenje", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 private List<Prijava> prijave=new ArrayList<>();

	public Takmicenje(Long id, String naziv, String mesto, String pocetak, String zavrsetak, Format format,
			List<Prijava> prijave) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesto = mesto;
		this.pocetak = pocetak;
		this.zavrsetak = zavrsetak;
		this.format = format;
		this.prijave = prijave;
	}
	 
	 public Takmicenje() {
		 
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

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
		if(format !=null && !format.getTakmicenja().contains(this)) {
			format.getTakmicenja().add(this);
		}
	}

	public List<Prijava> getPrijave() {
		return prijave;
	}

	public void setPrijave(List<Prijava> prijave) {
		this.prijave = prijave;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Takmicenje other = (Takmicenje) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Takmicenje [id=" + id + ", naziv=" + naziv + ", mesto=" + mesto + ", pocetak=" + pocetak
				+ ", zavrsetak=" + zavrsetak + ", format=" + format + ", prijave=" + prijave + "]";
	}
	 
	 

}
