package com.nwtProject.Kompanija.Synchronous;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.nwtProject.Kompanija.Models.Transport;

public class KompanijaTransport {
	
	@Autowired
	RestTemplate restTemplateKompanijaTransport;
	
	@RequestMapping(value="transport/dajTransportePoKompaniji/{idKompanije}", method = RequestMethod.GET)
	public List<Transport> dajTransportePoKompaniji(@PathVariable int idKompanije)
	{
		ResponseEntity<Transport[]> response = restTemplateKompanijaTransport.getForEntity("http://transport-client/transport/dajTransportePoKompaniji/{idKompanije}",Transport[].class,idKompanije);
		
		return Arrays.asList(response.getBody());
		
	}
	

}
