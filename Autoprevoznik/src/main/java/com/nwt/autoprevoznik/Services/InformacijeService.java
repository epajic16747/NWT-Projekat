package com.nwt.autoprevoznik.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.autoprevoznik.Models.Informacije;
import com.nwt.autoprevoznik.Repositories.InformacijeRepository;

@Service
public class InformacijeService implements IInformacijeService {
	
	@Autowired
	private InformacijeRepository informacijeRepository;

	@Override
	public List<Informacije> prikaziInformacije() {
		List<Informacije> listaInformacija = new ArrayList<>();
		informacijeRepository.findAll().forEach(a-> listaInformacija.add(a));
		return listaInformacija;
	}

	@Override
	public Informacije dajInformaciju(int idInformacije) {
		Informacije informacije = informacijeRepository.findById(idInformacije).get();
		return informacije;
	}

	@Override
	public void dodajInformacije(Informacije informacije) {
		informacijeRepository.save(informacije);
		
	}

	@Override
	public void azurirajInformaciju(Informacije informacije) {
		informacijeRepository.save(informacije);
		
	}

	@Override
	public void obrisiInformaciju(int idInformacije) {
		informacijeRepository.delete(dajInformaciju(idInformacije));
		
	}

	
	
	

}
