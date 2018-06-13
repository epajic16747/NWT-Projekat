package com.nwtProject.Transport.Services;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwtProject.model.Transport;
import com.nwtProject.repository.TransportRepository;


@Service
public class TransportService implements ITransportService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private RabbitTemplate rabbitTemplate;
    private final Exchange exchange;
    
	public TransportService(RabbitTemplate rabbitTemplate, Exchange exchange) {
		this.rabbitTemplate = rabbitTemplate;
		this.exchange = exchange;
	}

	@Autowired
	private TransportRepository transportRepo;
	
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
		logger.info("asdasdqqq");
		
		
		
		String routingKey = "customer.created";
		   String message="sasa";
		   rabbitTemplate.convertAndSend(
	               exchange.getName(),routingKey,  serializeToJson(transportRepo.save(transport)));
		logger.info("asdasddasd");

	}
	

	
	 private String serializeToJson(Transport transport) {
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonInString = "";

	        try {
	            jsonInString = mapper.writeValueAsString(transport);
	        } catch (JsonProcessingException e) {
	            logger.info(String.valueOf(e));
	        }

	        logger.debug("Serialized message payload: {}", jsonInString);

	        return jsonInString;
	    }
	
	
	@Override
	public void azurirajTransport(Transport transport) {
		transportRepo.save(transport);
	}
	@Override
	public void obrisiTransport(int idTransporta) {
		transportRepo.delete(dajTransport(idTransporta));
	
	}
	
	@Override
	public List<Transport> dajAktivneTransporte()
	{
		List<Transport> aktivniTransporti =(List<Transport>) transportRepo.dajAktivne("aktivan");
		return aktivniTransporti;
		
	}
	
	@Override
	public List<Transport> dajTransportePoKompaniji(int idKompanije)
	{
	 List<Transport> transportiKompanije = (List<Transport>) transportRepo.dajTransportePoKompaniji(idKompanije);
	 return transportiKompanije;
	}
	
}
