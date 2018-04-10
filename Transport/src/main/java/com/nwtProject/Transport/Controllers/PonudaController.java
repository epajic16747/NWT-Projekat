package com.nwtProject.Transport.Controllers;

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

import com.nwtProject.Transport.Services.IPonudaService;
import com.nwtProject.model.Ponuda;



@Controller
@RequestMapping("ponuda")
public class PonudaController {
	
	
	@Autowired
	private IPonudaService ponudaService;
	
	@GetMapping("dajPonudu/{id}")
	public ResponseEntity<Ponuda> dajPonudu(@PathVariable("id") long id) {
		
		Ponuda ponuda = ponudaService.dajPonudu(id);
		return new ResponseEntity<Ponuda>(ponuda, HttpStatus.OK);
	}
	
	
	@GetMapping("ponude")
	public ResponseEntity<List<Ponuda>>dajSvePonude() {
		List<Ponuda> listaPonuda = ponudaService.dajSvePonude();
		return new ResponseEntity<List<Ponuda>>(listaPonuda, HttpStatus.OK);
	}
	
	@PostMapping("dodajKorisnika")
	public ResponseEntity<Void> dodajPonudu(@RequestBody Ponuda ponuda, UriComponentsBuilder builder) {
		
		//Za ovo treba servis vratit true/false
		//Kod je ostavljen cisto  zbog primjera
/*
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		ponudaService.dodajPonudu(ponuda);
		
		//VIdi u testiranju sta ovaj dio radi
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/ponuda/{id}").buildAndExpand(ponuda.getIdPonuda()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("azurirajPonudu")
	public ResponseEntity<Ponuda> azurirajPonudu(@RequestBody Ponuda ponuda) {
		ponudaService.azurirajPonudu(ponuda);
		return new ResponseEntity<Ponuda>(ponuda, HttpStatus.OK);
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiPonudu(@PathVariable("id") long id) {
		ponudaService.obrisiPonudu(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
