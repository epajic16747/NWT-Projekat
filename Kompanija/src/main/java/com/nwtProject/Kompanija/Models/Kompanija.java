package com.nwtProject.Kompanija.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name="Kompanija")
public class Kompanija {

	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idKompanije")
    private Long idKompanije;
    
    @NotNull
    @Size(min=3, max=45)
	@Column(name="naziv")
    private String naziv;
	
    @Size(min=100, max=1000)
	@Column(name="opis")
    private String opis;
	
    @NotNull
    @Size(min=10, max=250)
	@Column(name="adresa")
    private String adresa;
	
    @NotNull
    @Size(min=11, max=15)
	@Column(name="telefon")
    private String telefon;
	
    @Size(min=20, max=100)
	@Column(name="email")
    private String email;
	
	public Kompanija() {}
	public Kompanija(Long idKompanije, String naziv, String opis, String adresa, String telefon, String email) {
		super();
		this.idKompanije = idKompanije;
		this.naziv = naziv;
		this.opis = opis;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
	}
	public Long getIdKompanije() {
		return idKompanije;
	}
	public void setIdKompanije(Long idKompanije) {
		this.idKompanije = idKompanije;
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
    @Override
    public String toString() {
        return String.format(
                "Kompanija[idKompanije=%d, naziv='%s', opis='%s' , adresa = '%s', telefon='%s', email = '%s']",
                idKompanije, naziv, opis, adresa, telefon, email);
    }
	
}
