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
import com.nwtProject.KorisnikRecenzija.Models.Recenzija;
import com.nwtProject.KorisnikRecenzija.Services.IRecenzijaService;


@Controller
@RequestMapping("recenzija")
public class RecenzijaKontroler {
	
	
	@Autowired
	private IRecenzijaService recenzijaService;
	
	@GetMapping("dajRecenziju/{id}")
	public ResponseEntity<Recenzija> dajRecenziju(@PathVariable("id") Integer id) {
		
		Recenzija recenzija = recenzijaService.dajRecenziju(id);
		return new ResponseEntity<Recenzija>(recenzija, HttpStatus.OK);
	}
	
	
	@GetMapping("recenzije")
	public ResponseEntity<List<Recenzija>>dajSveRecenzije() {
		List<Recenzija> listaRecenzija = recenzijaService.dajSveRecenzije();
		return new ResponseEntity<List<Recenzija>>(listaRecenzija, HttpStatus.OK);
	}
	
	
	@PostMapping("dodajRecenziju")
	public ResponseEntity<Void> dodajRecenziju(@RequestBody Recenzija recenzija, UriComponentsBuilder builder) {
		
		//Za ovo treba servis vratit true/false
		//Kod je ostavljen cisto  zbog primjera
/*
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		recenzijaService.dodajRecenziju(recenzija);
		
		//VIdi u testiranju sta ovaj dio radi
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/recenzija/{id}").buildAndExpand(recenzija.getIdRecenzije()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("azurirajRecenziju")
	public ResponseEntity<Recenzija> azurirajRecenziju(@RequestBody Recenzija recenzija) {
		recenzijaService.azurirajRecenziju(recenzija);
		return new ResponseEntity<Recenzija>(recenzija, HttpStatus.OK);
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiRecenziju(@PathVariable("id") Integer id) {
		recenzijaService.obrisiRecenziju(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
