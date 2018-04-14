package com.nwt.autoprevoznik.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Autoprevoznik")
public class Autoprevoznik {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idAutoprevoznika")
    private Long idAutoPrevoznika;
	
	@NotNull
    @Size(min=5, max=45)
	@Column(name="naziv")
	private String naziv;
	
	@NotNull
    @Size(min=5, max=100)
	@Column(name="opis")
	private String opis;
	
	@NotNull
	@Column(name="adresa")
	private String adresa;
	
	
	@NotNull
	@Column(name="telefon")
	private String telefon;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	public Long getIdAutoPrevoznika() {
		return idAutoPrevoznika;
	}
	public void setIdAutoPrevoznika(Long idAutoPrevoznika) {
		this.idAutoPrevoznika = idAutoPrevoznika;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		this.email = email;
	}

	
	protected Autoprevoznik() {}
	public Autoprevoznik(Long idAutoprevoznika, String naziv, String opis, String adresa, String telefon,
			String email)
	{
		this.idAutoPrevoznika=idAutoprevoznika;
		this.naziv=naziv;
		this.adresa=adresa;
		this.opis=opis;
		this.telefon=telefon;
		this.email=email;
		
	}

}