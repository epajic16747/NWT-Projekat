package com.nwtProject.Transport.Services;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.model.Transport;
import com.nwtProject.repository.TransportRepository;


@Service
public class TransportService implements ITransportService {

	
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
		
		transportRepo.save(transport);

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
	
	
	
}
