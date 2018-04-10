package com.nwtProject.Transport.Services;

import java.util.List;


import com.nwtProject.model.Ponuda;

public interface IPonudaService {
	
	//CRUD za ponudu
	
	List<Ponuda> dajSvePonude();
	Ponuda dajPonudu(long idPonude);
	void dodajPonudu(Ponuda ponuda);
	void azurirajPonudu(Ponuda ponuda);
	void obrisiPonudu(long idPonude);

}
