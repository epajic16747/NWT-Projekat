package com.nwtProject.KorisnikRecenzija.Services;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.KorisnikRecenzija.Models.Recenzija;
import com.nwtProject.KorisnikRecenzija.Repositories.RecenzijaRepozitorij;


@Service
public class RecenzijaService implements IRecenzijaService{
	
	@Autowired
	private RecenzijaRepozitorij recenzijaRepo;

	@Override
    public Boolean postojiPoIdu(long idRecenzija){
	    return recenzijaRepo.existsById(idRecenzija);
    }


    @Override
	public List<Recenzija> dajSveRecenzije(){
		List<Recenzija> listaRecenzija = new ArrayList<>();
		recenzijaRepo.findAll().forEach(e -> listaRecenzija.add(e));
		
		return listaRecenzija;
	}
	@Override
	public Recenzija dajRecenziju(long idRecenzije) {
		Recenzija recenzija = recenzijaRepo.findById(idRecenzije).get();
		return recenzija;
	}
	@Override
	public void dodajRecenziju(Recenzija recenzija) {
		 recenzijaRepo.save(recenzija);
	}
	@Override
	public void azurirajRecenziju(Recenzija recenzija) {
		recenzijaRepo.save(recenzija);
	}
	@Override
	public void obrisiRecenziju(int idRecenzije) {
		recenzijaRepo.delete(dajRecenziju(idRecenzije));
	}


}
