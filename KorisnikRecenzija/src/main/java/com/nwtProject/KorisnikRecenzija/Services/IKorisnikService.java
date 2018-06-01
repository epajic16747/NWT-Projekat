package com.nwtProject.KorisnikRecenzija.Services;
import java.util.List;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;

public interface IKorisnikService {

	
	//CRUD za korisnika
	
	List<Korisnik> dajSveKorisnike();
	Korisnik dajKorisnika(long idKorisnika);
	void dodajKorisnika(Korisnik korisnik);
	void azurirajKorisnika(Korisnik korisnik);
	void obrisiKorisnika(int idKorisnika);
	boolean postojiKorisnikPoIdu(long idKorisnika);
	boolean postojiKorisnikPoUsername(String username);
	boolean postojiKorisnikPoUsernamePw(String username,String pass);
	//boolean postojiKorisnik(String username, String pass);
	
}
