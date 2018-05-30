package com.nwt.autoprevoznik.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nwt.autoprevoznik.Models.Ponuda;
import com.nwt.autoprevoznik.Repositories.PonudaRepository;

@Service
public class PonudaService implements IPonudaService {

	private PonudaRepository ponudaRepository;
	@Override
	public List<Ponuda> dajSvePonude() {
		List<Ponuda> listaPonuda = new ArrayList<>();
		ponudaRepository.findAll().forEach(a->listaPonuda.add(a));
		return listaPonuda;
		
	}

	@Override
	public Ponuda dajPonudu(int idPonude) {
		Ponuda ponuda = ponudaRepository.findById(idPonude).get();
		return ponuda;
	}

	@Override
	public void dodajPonudu(Ponuda ponuda) {
		ponudaRepository.save(ponuda);
		
	}

	@Override
	public void azurirajPonudu(Ponuda ponuda) {
		ponudaRepository.save(ponuda);
		
	}

	@Override
	public void obrisiPonudu(int idPonude) {
		ponudaRepository.delete(dajPonudu(idPonude));
		
	}

}
