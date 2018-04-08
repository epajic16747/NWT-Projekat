package com.nwtProject.KorisnikRecenzija.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;
import com.nwtProject.KorisnikRecenzija.Repositories.KorisnikRepozitorij;

@Service
public class KorisnikService implements IKorisnikService{
	
	
	@Autowired
	private KorisnikRepozitorij korisnikRepo;
	
	@Override
	public List<Korisnik> dajSveKorisnike(){
		
		List<Korisnik> listaKorisnika = new ArrayList<>();
		korisnikRepo.findAll().forEach(e -> listaKorisnika.add(e));
		
		return listaKorisnika;
	}
	
	@Override
	public Korisnik dajKorisnika(long idKorisnika) {
		Korisnik korisnik = korisnikRepo.findById(idKorisnika).get();

		return korisnik;
	}
	
	@Override
	public void dodajKorisnika(Korisnik korisnik) {
		
	    korisnikRepo.save(korisnik);

	}
	@Override
	public void azurirajKorisnika(Korisnik korisnik) {
	    korisnikRepo.save(korisnik);
	}
	@Override
	public void obrisiKorisnika(int idKorisnika) {
	    korisnikRepo.delete(dajKorisnika(idKorisnika));
		
	}
}
