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

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.nwtProject.KorisnikRecenzija.Exceptions.KorisnikNotFoundException;
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
		if (korisnik == null)
		      throw new KorisnikNotFoundException("id-" + id);
/*
		    Resource<Student> resource = new Resource<Student>(student.get());

		    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());

		    resource.add(linkTo.withRel("all-students"));*/
		return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
	}
	
	
	@GetMapping("korisnici")
	public ResponseEntity<List<Korisnik>>dajSveKorisnike() {
		List<Korisnik> listaKorisnika = korisnikService.dajSveKorisnike();
		return new ResponseEntity<List<Korisnik>>(listaKorisnika, HttpStatus.OK);
	}
	
	@PostMapping("dodajKorisnika")
	public ResponseEntity<Void> dodajKorisnika(@RequestBody Korisnik korisnik, UriComponentsBuilder builder) {
		
		//Za ovo treba servis vratit true/false
		//Kod je ostavljen cisto  zbog primjera
/*
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		korisnikService.dodajKorisnika(korisnik);
		
		//VIdi u testiranju sta ovaj dio radi
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/korisnik/{id}").buildAndExpand(korisnik.getIdKorisnika()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("azurirajKorisnika")
	public ResponseEntity<Korisnik> azurirajKorisnika(@RequestBody Korisnik korisnik) {
		korisnikService.azurirajKorisnika(korisnik);
		return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiKorisnika(@PathVariable("id") Integer id) {
		korisnikService.obrisiKorisnika(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
