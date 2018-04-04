package com.nwtProject.Kompanija.Controllers;

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

import com.nwtProject.Kompanija.Models.Kompanija;
import com.nwtProject.Kompanija.Services.IKompanijaService;



@Controller
@RequestMapping("kompanija")
public class KompanijaController {
	
	@Autowired
	private IKompanijaService kompanijaService;
	
	@GetMapping("dajKompaniju/{id}")
	public ResponseEntity<Kompanija> dajKompaniju(@PathVariable("id") Integer id) {
		
		Kompanija kompanija = kompanijaService.dajKompaniju(id);
		return new ResponseEntity<Kompanija>(kompanija, HttpStatus.OK);
	}
	
	
	@GetMapping("kompanije")
	public ResponseEntity<List<Kompanija>>dajSveKompanije() {
		List<Kompanija> listaKompanija = kompanijaService.dajSveKompanije();
		return new ResponseEntity<List<Kompanija>>(listaKompanija, HttpStatus.OK);
	}
	
	@PostMapping("dodajKompaniju")
	public ResponseEntity<Void> dodajKompaniju(@RequestBody Kompanija kompanija, UriComponentsBuilder builder) {
		
		//Za ovo treba servis vratit true/false
		//Kod je ostavljen cisto  zbog primjera
/*
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		kompanijaService.dodajKompaniju(kompanija);
		
		//VIdi u testiranju sta ovaj dio radi
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/kompanija/{id}").buildAndExpand(kompanija.getIdKompanije()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("azurirajKompaniju")
	public ResponseEntity<Kompanija> azurirajKompaniju(@RequestBody Kompanija kompanija) {
		kompanijaService.azurirajKompaniju(kompanija);
		return new ResponseEntity<Kompanija>(kompanija, HttpStatus.OK);
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiKompaniju(@PathVariable("id") Integer id) {
		kompanijaService.obrisiKompaniju(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	


}
