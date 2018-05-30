package com.nwt.autoprevoznik.Synchronous;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.nwt.autoprevoznik.POJO.Recenzija;
import com.nwt.autoprevoznik.POJO.Transport;

public class AutoprevoznikTransport {
	
	
	
	@Autowired
	RestTemplate  restTemplateTransportAutoprevoznik;
	
	@RequestMapping(value = "transport/dajAktivneTransporte", method= RequestMethod.GET)
	public List<Transport> dajAktivneTransporte() throws Exception{
		
		ResponseEntity<Transport[]> response = restTemplateTransportAutoprevoznik.getForEntity("http://transport-client/transport/dajAktivneTransporte",Transport[].class);
		
		return Arrays.asList(response.getBody());
		
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplateTransport() {
		return new RestTemplate();
	}

}
