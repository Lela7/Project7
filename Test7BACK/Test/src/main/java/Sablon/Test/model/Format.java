package Sablon.Test.model;
//Id - identifikator
//Tip takmičenja - obavezna vrednost (Grand slam, Masters 1000, Masters 500,
//Masters 250)
//Broj učesnika - celobrojna vrednost

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Format {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable=false)
	private String tip;
	
	@Column
	private int brojUcesnika;
	
	@OneToMany(mappedBy = "format", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Takmicenje> takmicenja=new ArrayList<> ();

	public Format(Long id, String tip, int brojUcesnika, List<Takmicenje> takmicenja) {
		super();
		this.id = id;
		this.tip = tip;
		this.brojUcesnika = brojUcesnika;
		this.takmicenja = takmicenja;
	}
	
	
	public Format() {
		
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


	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}


	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Format other = (Format) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Format [id=" + id + ", tip=" + tip + ", brojUcesnika=" + brojUcesnika + ", takmicenja=" + takmicenja
				+ "]";
	}
	
	
	
	
	
	
}
