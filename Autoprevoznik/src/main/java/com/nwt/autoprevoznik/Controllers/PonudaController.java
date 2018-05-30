package com.nwt.autoprevoznik.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.nwt.autoprevoznik.Models.Informacije;
import com.nwt.autoprevoznik.Models.Ponuda;
import com.nwt.autoprevoznik.Services.PonudaService;

@RestController
public class PonudaController {
	
	@Autowired
	private PonudaService ponudaService;
	
	
	
	@GetMapping("ponude")
	public ResponseEntity<List<Ponuda>>dajSvePonude() {
		List<Ponuda> listaPonuda = ponudaService.prikaziPonude();
		return new ResponseEntity<List<Ponuda>>(listaPonuda, HttpStatus.OK);
	}
	
	@GetMapping("dajPonudu/{id}")
	public ResponseEntity<Ponuda> dajPonudu(@PathVariable("id") Integer id) {
		try{
            Ponuda ponuda = ponudaService.dajPonudu(id);
            return new ResponseEntity<Ponuda>(ponuda, HttpStatus.OK);

        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Ne postoji ponuda sa trazenim id-om");
        }
	}
	
	@PostMapping("dodajPonudu")
	public ResponseEntity<Void> dodajPonudu(@RequestBody Ponuda p, UriComponentsBuilder builder)
	{

        try {
            ponudaService.dodajPonudu(p);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/ponude/{id}").buildAndExpand(p.getPonudaId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        catch (ConstraintViolationException ex){
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException("Podaci ne ispunjavaju validaciju!");
        }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException("Desila  se greska prilikom spasavanja ponude u bazu!");
        }
			
	}
	
	
	@PutMapping("azurirajPonudu")
	public ResponseEntity<Ponuda> azurirajPonudu(@RequestBody Ponuda ponuda) {
    
	    try {
            ponudaService.azurirajPonudu(ponuda);
            return new ResponseEntity<Ponuda>(ponuda, HttpStatus.OK);
        }
        catch (Exception ex){
	        throw new IllegalArgumentException(ex.getMessage());
        }
	}
	
		
	
	@DeleteMapping("obrisiPonudu/{id}")
	public ResponseEntity<Void> obrisiPonudu(@PathVariable("id") Integer id) {
	    try {
            ponudaService.obrisiPonuduId(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException ex)
        {
            throw new IllegalArgumentException("Ne postoji odabrana informacija!");

        }
        catch(Exception ex){

	        throw new IllegalArgumentException("Desila se greska pri brisanju ponude!");
        }
	}	

	
	
	
	
	
	
}

