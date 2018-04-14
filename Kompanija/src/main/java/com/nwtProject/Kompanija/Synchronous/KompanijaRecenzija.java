package com.nwtProject.Kompanija.Synchronous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nwtPoject.Kompanija.POJO.Recenzija;

@Controller
@RestController
public class KompanijaRecenzija {
	
	@Autowired
	RestTemplate  restTemplateRecenzija;
	
	@RequestMapping(value = "recenzija/dajRecenziju/{id}", method= RequestMethod.GET)
	public Recenzija dajRecenziju(@PathVariable int id) throws Exception{
		
		System.out.println("Trazenje recenzije sa id-em: " + Integer.toString(id));
		Recenzija recenzija = restTemplateRecenzija.getForObject("http://korisnik-recenzija-client/recenzija/dajRecenziju/{id}",Recenzija.class,id);
		return recenzija;
		
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplateRecenzija() {
		return new RestTemplate();
	}
	

}
