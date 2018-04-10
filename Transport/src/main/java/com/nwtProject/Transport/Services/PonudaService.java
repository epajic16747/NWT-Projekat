package com.nwtProject.Transport.Services;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.model.Ponuda;
import com.nwtProject.repository.PonudaRepository;


@Service
public class PonudaService implements IPonudaService {
	
	@Autowired
	private PonudaRepository ponudaRepo;
	
	@Override
	public List<Ponuda> dajSvePonude(){
		
		List<Ponuda> listaPonuda= new ArrayList<>();
		ponudaRepo.findAll().forEach(e -> listaPonuda.add(e));
		
		return listaPonuda;
	}
	
	@Override
	public Ponuda dajPonudu(long idPonude) {
		Ponuda ponuda = ponudaRepo.findById(idPonude).get();
		return ponuda;
	}
	
	@Override
	public void dodajPonudu(Ponuda ponuda) {
		
	    ponudaRepo.save(ponuda);

	}
	@Override
	public void azurirajPonudu(Ponuda ponuda) {
	    ponudaRepo.save(ponuda);
	}
	@Override
	public void obrisiPonudu(long idPonude) {
	    ponudaRepo.delete(dajPonudu(idPonude));
	
	}

}
