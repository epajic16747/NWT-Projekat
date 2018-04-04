package com.nwtProject.Kompanija.Services;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.Kompanija.Models.Transport;
import com.nwtProject.Kompanija.Repositories.TransportRepozitorij;


@Service
public class TransportService implements ITransportService {

	
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
	public void azurirajTransport(Transport transport) {
		transportRepo.save(transport);
	}
	@Override
	public void obrisiTransport(int idTransporta) {
		transportRepo.delete(dajTransport(idTransporta));
	
	}
}
