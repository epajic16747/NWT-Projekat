package com.nwt.autoprevoznik.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Informacije;
import com.nwt.autoprevoznik.Models.Ponuda;
import com.nwt.autoprevoznik.Repositories.AutoprevoznikRepository;
import com.nwt.autoprevoznik.Repositories.PonudaRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class PonudaService {
	
	@Autowired
	private PonudaRepository ponudaRepository;
	
	public List<Ponuda> prikaziPonude()
	{
		List<Ponuda> lista = new ArrayList();
		ponudaRepository.findAll().forEach(lista::add);
		return lista;
		
	}
	
	public void dodajPonudu(Ponuda p)
	{
		ponudaRepository.save(p);
	}
	
	
	public void obrisiPonudu(Ponuda p)
	{
		ponudaRepository.delete(p);
	}
	
	public void obrisiIPonuduId(int id)
	{
		ponudaRepository.deleteById(id);
	}
	
	public void izmijeniPonudu(Ponuda p)
	{
		ponudaRepository.save(p);
	}

}
