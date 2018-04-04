package com.nwtProject.KorisnikRecenzija.Services;

import java.util.List;


import com.nwtProject.KorisnikRecenzija.Models.Recenzija;
public interface IRecenzijaService {
	
	
	//CRUD za recenziju
	
	List<Recenzija> dajSveRecenzije();
	Recenzija dajRecenziju(long idRecenzije);
	void dodajRecenziju(Recenzija recenzija);
	void azurirajRecenziju(Recenzija recenzija);
	void obrisiRecenziju(int idRecenzije);

}
