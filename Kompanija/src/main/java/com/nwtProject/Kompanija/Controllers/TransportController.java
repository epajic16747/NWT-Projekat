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

import com.nwtProject.Kompanija.Services.ITransportService;
import com.nwtProject.Kompanija.Models.Transport;



@Controller
@RequestMapping("kompanijaTransport")
public class TransportController {
	
	@Autowired
	private ITransportService transportService;
	
	@GetMapping("dajTransport/{id}")
	public ResponseEntity<Transport> dajTransport(@PathVariable("id") Integer id) {
		try {
			Transport transport = transportService.dajTransport(id);
			return new ResponseEntity<Transport>(transport, HttpStatus.OK);
		}
		catch(Exception ex){
			HttpHeaders header = new HttpHeaders();
			header.add("error", ex.getMessage());
			return new ResponseEntity<Transport>(header, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("transporti")
	public ResponseEntity<List<Transport>>dajSveTransporte() {
		List<Transport> listaTransporta = transportService.dajSveTransporte();
		return new ResponseEntity<List<Transport>>(listaTransporta, HttpStatus.OK);
	}
	
	@PostMapping("dodajTransport")
	public ResponseEntity<Void> dodajTransport(@RequestBody Transport transport, UriComponentsBuilder builder) {
		
		try {
			transportService.dodajTransport(transport);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/ponuda/{id}").buildAndExpand(transport.getIdTransporta()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		catch (Exception ex){
			HttpHeaders header = new HttpHeaders();
			header.add("error", ex.getMessage());
			return new ResponseEntity<Void>(header, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("azurirajTransport")
	public ResponseEntity<Transport> azurirajTransport(@RequestBody Transport transport) {
		if(transportService.postojiTransport(transport)){

			transportService.azurirajTransport(transport);
			return new ResponseEntity<Transport>(transport, HttpStatus.OK);
		}
		else
		{
			HttpHeaders header = new HttpHeaders();
			header.add("error", "Ne postoji transport sa odabranim id-em!");
			return new ResponseEntity<Transport>(header, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiTransport(@PathVariable("id") Integer id) {
		try{
			transportService.obrisiTransport(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		catch(Exception ex){
			HttpHeaders header = new HttpHeaders();
			header.add("error", ex.getMessage());
			return new ResponseEntity<Void>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
