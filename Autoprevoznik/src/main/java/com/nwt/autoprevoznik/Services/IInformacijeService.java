package com.nwt.autoprevoznik.Services;

import java.util.List;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Informacije;

public interface IInformacijeService {

	List<Informacije> prikaziInformacije();
	Informacije dajInformaciju(int idInformacije);
	void dodajInformacije(Informacije informacije);
	void azurirajInformaciju(Informacije informacije);
	void obrisiInformaciju(int idInformacije);
	//public Boolean postojiAutoprevoznik(long idAutoprevoznika);
	
}
