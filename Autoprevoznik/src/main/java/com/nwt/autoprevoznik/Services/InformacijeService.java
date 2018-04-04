package com.nwt.autoprevoznik.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Informacije;
import com.nwt.autoprevoznik.Repositories.AutoprevoznikRepository;
import com.nwt.autoprevoznik.Repositories.InformacijeRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class InformacijeService {
	
	@Autowired
	private InformacijeRepository informacijeRepository;

	public List<Informacije> prikaziInformacije()
	{
		List<Informacije> lista = new ArrayList();
		informacijeRepository.findAll().forEach(lista::add);
		return lista;
		
	}
	
	public void dodajInformaciju(Informacije i)
	{
		informacijeRepository.save(i);
	}
	
	public void obrisiInformaciju(Informacije i)
	{
		informacijeRepository.delete(i);
	}
	
	public void obrisiInformacijuId(int id)
	{
		informacijeRepository.deleteById(id);
	}
	
	public void izmijeniInformaciju(Informacije i)
	{
		informacijeRepository.save(i);
	}
}
