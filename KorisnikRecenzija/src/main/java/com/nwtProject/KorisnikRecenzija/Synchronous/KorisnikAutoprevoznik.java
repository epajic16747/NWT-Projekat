package com.nwtProject.KorisnikRecenzija.Synchronous;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nwtProject.KorisnikRecenzija.POJO.Autoprevoznik;


@Controller
@RestController
public class KorisnikAutoprevoznik {

	
	@Autowired
	RestTemplate restTemplateAutoprevoznik;
	
    @RequestMapping(value = "autoprevoznik/dajAutoprevoznika/{id}", method = RequestMethod.GET)
    public Autoprevoznik dajAutoprevoznika(@PathVariable int id) throws Exception
    {
        System.out.println("Trazenje kompanije  " + Integer.toString(id));
        
       
        Autoprevoznik autoprevoznik = restTemplateAutoprevoznik.getForObject("http://autoprevoznik-client/autoprevoznik/dajAutoprevoznika/{id}",
        		Autoprevoznik.class,id);
        return autoprevoznik;		
    }
    
    

    @Bean
    @LoadBalanced
    public RestTemplate restTemplateAutoprevoznik() {
        return new RestTemplate();
    }
}
