package com.nwtProject.KorisnikRecenzija.Controllers;

import java.util.List;
import java.util.*;

import com.nwtProject.KorisnikRecenzija.Services.KorisnikService;
import org.hibernate.criterion.IlikeExpression;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.nwtProject.KorisnikRecenzija.Exceptions.KorisnikNotFoundException;
import com.nwtProject.KorisnikRecenzija.Models.Korisnik;
import com.nwtProject.KorisnikRecenzija.Services.IKorisnikService;

import javax.validation.ConstraintViolationException;

@Controller
@RequestMapping("korisnik")
public class KorisnikKontroler {

	@Autowired
	private IKorisnikService korisnikService;
	
	@GetMapping("dajKorisnika/{id}")
	public ResponseEntity<Korisnik> dajKorisnika(@PathVariable("id") Integer id) {
		try{
            Korisnik korisnik = korisnikService.dajKorisnika(id);
            return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);

        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Ne postji korisnik sa trazenim id-em");
        }
	}
	@GetMapping(value = "/user/{username}/pass/{pass}")
	public ResponseEntity<Boolean> postojilikorisnik
	  (@PathVariable("username") String username, @PathVariable("pass") String pass) {
	    return new ResponseEntity<Boolean>(korisnikService.postojiKorisnikPoUsernamePw(username,pass),HttpStatus.OK);
	}
	
	

	@GetMapping("korisnici")
	public ResponseEntity<List<Korisnik>>dajSveKorisnike() {
		List<Korisnik> listaKorisnika = korisnikService.dajSveKorisnike();
		return new ResponseEntity<List<Korisnik>>(listaKorisnika, HttpStatus.OK);
	}
	
	@PostMapping("dodajKorisnika")
	public ResponseEntity<Void> dodajKorisnika(@RequestBody Korisnik korisnik, UriComponentsBuilder builder) {
		
		if(!korisnikService.postojiKorisnikPoUsername(korisnik.getUsername())) {
           try {
               korisnikService.dodajKorisnika(korisnik);
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/korisnik/{id}").buildAndExpand(korisnik.getIdKorisnika()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
           }
           catch (ConstraintViolationException ex){
               System.out.println(ex.getMessage());
               throw new IllegalArgumentException("Podaci ne ispunjavaju validaciju!");
           }
            catch (Exception ex) {
               System.out.println(ex.getMessage());
               throw new IllegalArgumentException("Desila  se greska pri spasavaanju novog korisnika u bazu!");
           }
        }
        else
            throw new IllegalArgumentException("Korisnicko ime nije jednistveno!");
	}
	
	@PutMapping("azurirajKorisnika")
	public ResponseEntity<Korisnik> azurirajKorisnika(@RequestBody Korisnik korisnik) {
        if(!korisnikService.postojiKorisnikPoIdu(korisnik.getIdKorisnika()))
            throw new IllegalArgumentException("Odabrani korisnik ne postoji!");
	    try {
            korisnikService.azurirajKorisnika(korisnik);
            return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
        }
        catch (Exception ex){
	        throw new IllegalArgumentException(ex.getMessage());
        }
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiKorisnika(@PathVariable("id") Integer id) {
	    try {
            korisnikService.obrisiKorisnika(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException ex)
        {
            throw new IllegalArgumentException("Ne postoji odabrani korisnik!");

        }
        catch(Exception ex){
//	        System.out.println(ex.getClass().getCanonicalName());
	        throw new IllegalArgumentException("Desila se greska pri brisanju korisnika!");
        }
	}	
}
