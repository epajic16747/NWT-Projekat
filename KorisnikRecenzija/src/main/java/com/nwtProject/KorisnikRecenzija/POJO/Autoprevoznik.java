package com.nwtProject.KorisnikRecenzija.POJO;



public class Autoprevoznik {
	

    private int idAutoPrevoznika;
	private String naziv;
	private String opis;
	private String adresa;
	private String telefon;
	private String email;

	
	protected Autoprevoznik() {}
	public Autoprevoznik(int idAutoprevoznika, String naziv, String opis, String adresa, String telefon,
			String email)
	{
		this.idAutoPrevoznika=idAutoprevoznika;
		this.naziv=naziv;
		this.adresa=adresa;
		this.opis=opis;
		this.telefon=telefon;
		this.email=email;
		
	}

	
	public int getIdAutoPrevoznika() {
		return idAutoPrevoznika;
	}
	
	public void setIdAutoPrevoznika(int idAutoPrevoznika) {
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
}
