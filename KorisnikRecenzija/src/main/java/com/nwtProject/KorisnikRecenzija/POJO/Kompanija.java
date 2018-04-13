package com.nwtProject.KorisnikRecenzija.POJO;


public class Kompanija {


    private Long idKompanije;
  
    private String naziv;
	

    private String opis;
	

    private String adresa;

    private String telefon;
	

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
