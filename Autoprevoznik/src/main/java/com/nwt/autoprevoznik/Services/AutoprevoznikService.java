package com.nwt.autoprevoznik.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Repositories.AutoprevoznikRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class AutoprevoznikService {
	
	@Autowired
	private AutoprevoznikRepository autoprevoznikRepository;

	
	public List<Autoprevoznik> prikaziPrevoznike()
	{
		List<Autoprevoznik> lista = new ArrayList();
		autoprevoznikRepository.findAll().forEach(lista::add);
		return lista;
		
	}
	
	public void dodajPrevoznika(Autoprevoznik a)
	{
		autoprevoznikRepository.save(a);
		
	}
	
	public Autoprevoznik dajprevoznikaPoImenu(String naziv)
	{
		List<Autoprevoznik> prevoznici = (List<Autoprevoznik>) autoprevoznikRepository.dajPrevoznikaPoNazivu(naziv);
		return prevoznici.get(0);
		
	}
	
	public void obrisiPrevoznika(int id)
	{
		autoprevoznikRepository.deleteById(id);
		
	}
	
	public void updatePrevoznika(int id, Autoprevoznik a)
	{
		autoprevoznikRepository.save(a);
	}

}
