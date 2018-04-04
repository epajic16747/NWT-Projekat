package com.nwtProject.Kompanija.Services;

import java.util.List;

import com.nwtProject.Kompanija.Models.Transport;

public interface ITransportService {
	List<Transport> dajSveTransporte();
	Transport dajTransport(long idTransporta);
	void dodajTransport(Transport transport);
	void azurirajTransport(Transport transport);
	void obrisiTransport(int idTransport);
}
