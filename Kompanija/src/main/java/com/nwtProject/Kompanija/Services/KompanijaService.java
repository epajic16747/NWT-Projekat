package com.nwtProject.Kompanija.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.Kompanija.Models.Kompanija;
import com.nwtProject.Kompanija.Repositories.KompanijaRepozitorij;


@Service
public class KompanijaService implements IKompanijaService {

	
	@Autowired
	private KompanijaRepozitorij kompanijaRepo;
	
	@Override
	public List<Kompanija> dajSveKompanije(){
		
		List<Kompanija> listaKompanija= new ArrayList<>();
		kompanijaRepo.findAll().forEach(e -> listaKompanija.add(e));
		
		return listaKompanija;
	}
	
	@Override
	public Kompanija dajKompaniju(long idKompanije) {
		Kompanija kompanija = kompanijaRepo.findById(idKompanije).get();
		return kompanija;
	}
	
	@Override
	public void dodajKompaniju(Kompanija kompanija) {
		
		kompanijaRepo.save(kompanija);

	}
	@Override
	public void azurirajKompaniju(Kompanija kompanija) {
	    kompanijaRepo.save(kompanija);
	}
	@Override
	public void obrisiKompaniju(int idKompanije) {
	    kompanijaRepo.delete(dajKompaniju(idKompanije));
	
	}

}
