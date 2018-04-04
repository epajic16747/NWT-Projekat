package com.nwt.autoprevoznik.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.autoprevoznik.Models.Ponuda;
import com.nwt.autoprevoznik.Services.PonudaService;

@RestController
public class PonudaController {
	
	@Autowired
	private PonudaService ponudaService;
	
	@RequestMapping("/ponude")
	public List<Ponuda> prikazisvePonude()
	{
		return ponudaService.prikaziPonude();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/dodajponudu")
	public void dodajPonudu(@RequestBody Ponuda p)
	{
		ponudaService.dodajPonudu(p);
	}
	
	@RequestMapping("/obrisiPonudu/{id}")
	public void ObrisiPonudu(@PathVariable int id)
	{
		 ponudaService.obrisiIPonuduId(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/izmijeniponudu")
	public void izmijeniPonudu(@RequestBody Ponuda p)
	{
	 ponudaService.izmijeniPonudu(p);
	}
	}

