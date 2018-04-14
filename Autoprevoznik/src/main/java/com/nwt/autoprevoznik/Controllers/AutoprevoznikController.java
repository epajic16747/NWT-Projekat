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
import com.nwt.autoprevoznik.Services.AutoprevoznikService;
import com.nwt.autoprevoznik.Services.IAutoprevoznikService;



@Controller
@RequestMapping("autoprevoznik")
public class AutoprevoznikController {
	
	@Autowired
	private IAutoprevoznikService autoprevoznikService;
	
	@GetMapping("dajAutoprevoznika/{id}")
	public ResponseEntity<Autoprevoznik> dajAutoprevoznika(@PathVariable("id") Integer id) {
		try{
            Autoprevoznik autoprevoznik = autoprevoznikService.dajAutoprevoznika(id);
            return new ResponseEntity<Autoprevoznik>(autoprevoznik, HttpStatus.OK);

        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Ne postoji autoprevoznik sa trazenim id-om");
        }
	}
	
	
	@GetMapping("autoprevoznici")
	public ResponseEntity<List<Autoprevoznik>>dajSveAutoprevozike() {
		List<Autoprevoznik> listaAutoprevoznika = autoprevoznikService.dajAutoprevoznike();
		return new ResponseEntity<List<Autoprevoznik>>(listaAutoprevoznika, HttpStatus.OK);
	}
	
	@PostMapping("dodajAutoprevoznika")
	public ResponseEntity<Void> dodajAutoprevoznika(@RequestBody Autoprevoznik autoprevoznik, UriComponentsBuilder builder) {
		
		
           try {
               autoprevoznikService.dodajAutoprevoznika(autoprevoznik);
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/korisnik/{id}").buildAndExpand(autoprevoznik.getIdAutoPrevoznika()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
           }
           catch (ConstraintViolationException ex){
               System.out.println(ex.getMessage());
               throw new IllegalArgumentException("Podaci ne ispunjavaju validaciju!");
           }
            catch (Exception ex) {
               System.out.println(ex.getMessage());
               throw new IllegalArgumentException("Desila  se greska prilikom spasavanja autoprevoznika u bazu!");
           }
        
   
	}
	
	@PutMapping("azurirajKAutoprevoznika")
	public ResponseEntity<Autoprevoznik> azurirajAutoprevoznika(@RequestBody Autoprevoznik autoprevoznik) {
    
	    try {
            autoprevoznikService.azurirajAutoprevoznika(autoprevoznik);
            return new ResponseEntity<Autoprevoznik>(autoprevoznik, HttpStatus.OK);
        }
        catch (Exception ex){
	        throw new IllegalArgumentException(ex.getMessage());
        }
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiAutoprevoznika(@PathVariable("id") Integer id) {
	    try {
            autoprevoznikService.obrisiAutoprevoznika(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException ex)
        {
            throw new IllegalArgumentException("Ne postoji odabrani autoprevoznik!");

        }
        catch(Exception ex){

	        throw new IllegalArgumentException("Desila se greska pri brisanju autoprevoznika!");
        }
	}	

}
