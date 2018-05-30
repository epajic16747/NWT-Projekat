package com.nwtProject.Transport.Services;

import java.util.List;


import com.nwtProject.model.Transport;

public interface ITransportService {
	
	List<Transport> dajSveTransporte();
	Transport dajTransport(long idTransporta);
	void dodajTransport(Transport transport);
	void azurirajTransport(Transport transport);
	void obrisiTransport(int idTransport);
	List<Transport> dajAktivneTransporte();
}
