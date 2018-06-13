package com.nwtProject.Kompanija.Services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwtProject.Kompanija.Models.Transport;
import com.nwtProject.Kompanija.Repositories.TransportRepozitorij;

import ch.qos.logback.classic.Logger;


@Service
public class TransportService implements ITransportService {
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TransportRepozitorij transportRepo;
	
	@Override
	public List<Transport> dajSveTransporte(){
		
		List<Transport> listaTransporta= new ArrayList<>();
		transportRepo.findAll().forEach(e -> listaTransporta.add(e));
		
		return listaTransporta;
	}
	
	@Override
	public Transport dajTransport(long idTransporta) {
		Transport transport = transportRepo.findById(idTransporta).get();
		return transport;
	}
	
	@Override
	public void dodajTransport(Transport transport) {
		
		transportRepo.save(transport);

	}


	@Override
	public Boolean postojiTransport(Transport t){
		return transportRepo.existsById(t.getIdTransporta());
	}

	@Override
	public void azurirajTransport(Transport transport) {

		transportRepo.save(transport);
	}

	@Override
	public void obrisiTransport(int idTransporta) {
		transportRepo.delete(dajTransport(idTransporta));
	
	}
	

	
	@RabbitListener(queues="transports.queue")
	  public void receive(String message) {

		ObjectMapper objectMapper = new ObjectMapper();
		  objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		  TypeReference<Transport> mapType = new TypeReference<Transport>() {};

		  Transport transport = new Transport();
		  //transport = message;


		 try {
			  
			  
		     transport = objectMapper.readValue(message, mapType);
		    
		  } catch (IOException e) {
		      logger.info("eror");
		 }
		  
		  
		  transportRepo.save(transport);
		  
		 
		}
		
	   

}
