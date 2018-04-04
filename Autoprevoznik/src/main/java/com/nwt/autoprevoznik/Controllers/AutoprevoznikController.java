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
import com.nwt.autoprevoznik.Services.AutoprevoznikService;


@RestController
public class AutoprevoznikController {
	
	@Autowired
	private AutoprevoznikService autoprevoznikService;
	
	
	@RequestMapping("/prevoznici")
	public List<Autoprevoznik> prikaziPrevoznike()
	{
		return autoprevoznikService.prikaziPrevoznike();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/dodajPrevoznika")
	public void dodajPrevoznika(@RequestBody Autoprevoznik a)
	{
		autoprevoznikService.dodajPrevoznika(a);
	}
	
	@RequestMapping("/obrisiPrevoznika/{id}")
	public void ObrisiPrevoznika(@PathVariable int id)
	{
		 autoprevoznikService.obrisiPrevoznika(id);
	}
	
	@RequestMapping("dajprevoznikapoid/{name}")
	public void dajprevoznikapoid(@PathVariable String name)
	{
		autoprevoznikService.dajprevoznikaPoImenu(name);
	}
	

}
