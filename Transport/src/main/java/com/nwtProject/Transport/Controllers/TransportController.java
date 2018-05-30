package com.nwtProject.Transport.Controllers;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nwtProject.Transport.Services.ITransportService;
import com.nwtProject.model.Transport;
import com.nwtProject.repository.TransportRepository;



@RestController
@RequestMapping("transport")
public class TransportController {
	
	@Autowired
	private ITransportService transportService;
	
	@GetMapping("dajTransport/{id}")
	public ResponseEntity<Transport> dajTransport(@PathVariable("id") Integer id) {
		
		Transport transport= transportService.dajTransport(id);
		return new ResponseEntity<Transport>(transport, HttpStatus.OK);
	}
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@GetMapping("transporti")
	public ResponseEntity<List<Transport>>dajSveTransporte() {
		List<Transport> listaTransporta = transportService.dajSveTransporte();
		return new ResponseEntity<List<Transport>>(listaTransporta, HttpStatus.OK);
	}
	
	@PostMapping("/transporti")
	public ResponseEntity dodajTransport(@RequestBody Transport transport) {
		
		//Za ovo treba servis vratit true/false
		//Kod je ostavljen cisto  zbog primjera
/*
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		transportService.dodajTransport(transport);
	    rabbitTemplate.convertAndSend("transporti-exchange","transporti.created.#",transport.getIdTransporta() +";" +transport.getCijenaMax()+";"+ transport.getDatum()+ ";"+transport.getIdAutoprevoznika()+";"+ transport.getIdKompanije()+";"+ transport.getNaziv()+";" +";create");
		return new ResponseEntity(transport, HttpStatus.OK);
		//VIdi u testiranju sta ovaj dio radi
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/transporti/{id}").buildAndExpand(transport.getIdTransporta()).toUri());
        //return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("azurirajTransport")
	public ResponseEntity<Transport> azurirajTransport(@RequestBody Transport transport) {
		transportService.azurirajTransport(transport);
		rabbitTemplate.convertAndSend("transporti-exchange","transporti.created.#",transport.getIdTransporta() +";" +transport.getCijenaMax()+";"+ transport.getDatum()+ ";"+transport.getIdAutoprevoznika()+";"+ transport.getIdKompanije()+";"+ transport.getNaziv()+";" +";update");

		return new ResponseEntity<Transport>(transport, HttpStatus.OK);
	}
	
	@DeleteMapping("obrisi/{id}")
	public ResponseEntity<Void> obrisiTransport(@PathVariable("id") Integer id) {
		transportService.obrisiTransport(id);
	    rabbitTemplate.convertAndSend("transporti-exchange", "transporti.deleted.#", id+";delete");

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}	
	
	@GetMapping("dajAktivneTransporte")
	public ResponseEntity<List<Transport>> dajAktivneTransporte()
	{
		List<Transport> aktivniTransporti = transportService.dajAktivneTransporte();
		return new ResponseEntity<List<Transport>>(aktivniTransporti, HttpStatus.OK);
	}
	
	@GetMapping("dajTransportePoKompaniji/{idKompanije}")
	public ResponseEntity<List<Transport>> dajTransportePoKompaniji(@PathVariable("idKompanije") int idKompanije)
	{
		List<Transport> transportiKompanije = transportService.dajTransportePoKompaniji(idKompanije);
		return new ResponseEntity<List<Transport>>(transportiKompanije,HttpStatus.OK);
		
	}
	


}
