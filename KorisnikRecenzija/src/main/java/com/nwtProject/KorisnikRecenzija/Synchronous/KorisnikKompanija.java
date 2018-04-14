package com.nwtProject.KorisnikRecenzija.Synchronous;



import java.io.IOException;

import org.apache.http.HttpEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.MediaType;
import com.nwtProject.KorisnikRecenzija.POJO.Kompanija;


@Controller
@RestController
public class KorisnikKompanija {
	
	
	@Autowired
	RestTemplate restTemplateKompanija;
	
    @RequestMapping(value = "kompanija/dajKompaniju/{id}", method = RequestMethod.GET)
    public Kompanija dajKompaniju(@PathVariable int id) throws Exception
    {
        System.out.println("Trazenje kompanije  " + Integer.toString(id));
        
       
        Kompanija kompanija = restTemplateKompanija.getForObject("http://kompanija-client/kompanija/dajKompaniju/{id}",Kompanija.class,id);
        return kompanija;		
    }
    
    

    @Bean
    @LoadBalanced
    public RestTemplate restTemplateKompanija() {
        return new RestTemplate();
    }
}
