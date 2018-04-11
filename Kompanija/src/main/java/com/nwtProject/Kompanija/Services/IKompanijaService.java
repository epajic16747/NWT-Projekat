package com.nwtProject.Kompanija.Services;

import java.util.List;

import com.nwtProject.Kompanija.Models.Kompanija;


public interface IKompanijaService {

	
	List<Kompanija> dajSveKompanije();
	Kompanija dajKompaniju(long idKompanije);
	void dodajKompaniju(Kompanija kompanija);
	void azurirajKompaniju(Kompanija kompanija);
	void obrisiKompaniju(int idKompanije);
	public Boolean postojiKompanija(long idKompanije);
}
