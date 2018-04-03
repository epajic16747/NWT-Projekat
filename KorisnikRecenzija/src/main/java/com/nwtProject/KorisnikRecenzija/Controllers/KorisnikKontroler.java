package com.nwtProject.KorisnikRecenzija.Controllers;



import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;
import com.nwtProject.KorisnikRecenzija.Services.IKorisnikService;

@Controller
@RequestMapping("korisnik")
public class KorisnikKontroler {

	@Autowired
	private IKorisnikService korisnikService;
	
	@GetMapping("dajKorisnika/{id}")
	public ResponseEntity<Korisnik> dajKorisnika(@PathVariable("id") Integer id) {
		
		Korisnik korisnik = korisnikService.dajKorisnika(id);
		return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
	}
 
}
