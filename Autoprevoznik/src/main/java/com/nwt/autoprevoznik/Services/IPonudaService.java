package com.nwt.autoprevoznik.Services;

import java.util.List;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Ponuda;

public interface IPonudaService {

	List<Ponuda> dajSvePonude();
	Ponuda dajPonudu(int idPonude);
	void dodajPonudu(Ponuda ponuda);
	void azurirajPonudu(Ponuda ponuda);
	void obrisiPonudu(int idPonude);
	//public Boolean postojiAutoprevoznik(long idAutoprevoznika);
}
