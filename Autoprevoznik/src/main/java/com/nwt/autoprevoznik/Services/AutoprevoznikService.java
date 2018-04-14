package com.nwt.autoprevoznik.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Repositories.AutoprevoznikRepository;


import java.util.List;
import java.util.ArrayList;

@Service
public class AutoprevoznikService implements IAutoprevoznikService {
	
	
	@Autowired
	private AutoprevoznikRepository autoprevoznikRepo;
	
	@Override
	public List<Autoprevoznik>  dajAutoprevoznike(){
		
		List<Autoprevoznik> listaAutoprevoznika = new ArrayList<>();
		autoprevoznikRepo.findAll().forEach(e -> listaAutoprevoznika.add(e));
		
		return listaAutoprevoznika;
	}
	
	@Override
	public Autoprevoznik dajAutoprevoznika(long idAutoprevoznika) {
		Autoprevoznik autoprevoznik = autoprevoznikRepo.findById(idAutoprevoznika).get();

		return autoprevoznik;
	}
	
	@Override
	public void dodajAutoprevoznika(Autoprevoznik autoprevoznik) {
		
	    autoprevoznikRepo.save(autoprevoznik);

	}
	@Override
	public void azurirajAutoprevoznika(Autoprevoznik autoprevoznik) {
	    autoprevoznikRepo.save(autoprevoznik);
	}

	@Override
	public void obrisiAutoprevoznika(int idAutoprevoznika) {
	    autoprevoznikRepo.delete(dajAutoprevoznika(idAutoprevoznika));
		
	}



}
