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

import com.nwtProject.Transport.Services.IPutniNalogService;
import com.nwtProject.model.PutniNalog;


@Controller
@RequestMapping("putniNalog")
public class PutniNalogController {
	
	@Autowired
	private IPutniNalogService putniNalogService;
	
	@GetMapping("dajPutniNalog/{id}")
	public ResponseEntity<PutniNalog> dajPutniNalog(@PathVariable("id") Integer id) {
		
		PutniNalog putniNalog = putniNalogService.dajPutniNalog(id);
		return new ResponseEntity<PutniNalog>(putniNalog, HttpStatus.OK);
	}
	
	
	@GetMapping("putniNalozi")
	public ResponseEntity<List<PutniNalog>>dajSvePutneNaloge() {
		List<PutniNalog> listaPutnihNaloga = putniNalogService.dajSvePutneNaloge();
		return new ResponseEntity<List<PutniNalog>>(listaPutnihNaloga, HttpStatus.OK);
	}
	
	@PostMapping("dodajPutniNalog")
	public ResponseEntity<Void> dodajPutniNalog(@RequestBody PutniNalog putniNalog, UriComponentsBuilder builder) {
		
		//Za ovo treba servis vratit true/false
		//Kod je ostavljen cisto  zbog primjera
/*
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		putniNalogService.dodajPutniNalog(putniNalog);
		
		//VIdi u testiranju sta ovaj dio radi
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/putniNalog/{id}").buildAndExpand(putniNalog.getIdPutniNalog()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("azurirajPutniNalog")
	public ResponseEntity<PutniNalog> azurirajPutniNalog(@RequestBody PutniNalog putniNalog) {
		putniNalogService.azurirajPutniNalog(putniNalog);
		return new ResponseEntity<PutniNalog>(putniNalog, HttpStatus.OK);
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiPutniNalog(@PathVariable("id") Integer id) {
		putniNalogService.obrisiPutniNalog(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	


}
