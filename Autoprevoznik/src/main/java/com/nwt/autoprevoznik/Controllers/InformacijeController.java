package com.nwt.autoprevoznik.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Informacije;
import com.nwt.autoprevoznik.Services.InformacijeService;

@RestController
public class InformacijeController {
	
	@Autowired
	private InformacijeService informacijeService;
	
	@RequestMapping("/informacije")
	public List<Informacije> prikaziPrevoznike()
	{
		return informacijeService.prikaziInformacije();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/dodajinformaciju")
	public void dodajInformaciju(@RequestBody Informacije i)
	{
		informacijeService.dodajInformaciju(i);
	}
	
	@RequestMapping("/obrisiInformacije/{id}")
	public void ObrisiInformacije(@PathVariable int id)
	{
		 informacijeService.obrisiInformacijuId(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/izmijeniinformacije")
	public void izmijeniInformaciju(@RequestBody Informacije i)
	{
		informacijeService.izmijeniInformaciju(i);
	}
	}
	
	


