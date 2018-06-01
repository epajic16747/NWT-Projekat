package com.nwt.autoprevoznik.Controllers;


import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Informacije;
import com.nwt.autoprevoznik.Services.InformacijeService;
@Controller
@RequestMapping("informacije")
public class InformacijeController {
	
	@Autowired
	private InformacijeService informacijeService;
	
	
	@GetMapping("informacije")
	public ResponseEntity<List<Informacije>>dajSveInformacije() {
		List<Informacije> listaInformacija = informacijeService.prikaziInformacije();
		return new ResponseEntity<List<Informacije>>(listaInformacija, HttpStatus.OK);
	}

	@GetMapping("dajInformacije/{id}")
	public ResponseEntity<Informacije> dajInformacije(@PathVariable("id") Integer id) {
		try{
            Informacije informacije = informacijeService.dajInformaciju(id);
            return new ResponseEntity<Informacije>(informacije, HttpStatus.OK);

        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Ne postoje informacije sa trazenim id-om");
        }
	}
	
	
	@PostMapping("dodajInformaciju")
	public ResponseEntity<Void> dodajInformaciju(@RequestBody Informacije i, UriComponentsBuilder builder)
	{

        try {
            informacijeService.dodajInformacije(i);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/informacije/{id}").buildAndExpand(i.getInformacijeId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        catch (ConstraintViolationException ex){
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException("Podaci ne ispunjavaju validaciju!");
        }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException("Desila  se greska prilikom spasavanja informacija u bazu!");
        }
			
	}
	
	@PutMapping("azurirajInformaciju")
	public ResponseEntity<Informacije> azurirajInformaciju(@RequestBody Informacije informacija) {
    
	    try {
            informacijeService.azurirajInformaciju(informacija);
            return new ResponseEntity<Informacije>(informacija, HttpStatus.OK);
        }
        catch (Exception ex){
	        throw new IllegalArgumentException(ex.getMessage());
        }
	}
	
	
	
	@DeleteMapping("obrisiInformacije/{id}")
	public ResponseEntity<Void> obrisiInformacije(@PathVariable("id") Integer id) {
	    try {
            informacijeService.obrisiInformaciju(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException ex)
        {
            throw new IllegalArgumentException("Ne postoji odabrana informacija!");

        }
        catch(Exception ex){

	        throw new IllegalArgumentException("Desila se greska pri brisanju informacije!");
        }
	}	

	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/izmijeniinformacije")
	public void izmijeniInformaciju(@RequestBody Informacije i)
	{
		informacijeService.azurirajInformaciju(i);
	}
	}
	
	


