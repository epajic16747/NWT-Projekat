package com.nwt.autoprevoznik.Services;

import java.util.List;

import com.nwt.autoprevoznik.Models.Autoprevoznik;



public interface IAutoprevoznikService {
	List<Autoprevoznik> dajAutoprevoznike();
	Autoprevoznik dajAutoprevoznika(long idAutoprevoznika);
	void dodajAutoprevoznika(Autoprevoznik autoprevoznik);
	void azurirajAutoprevoznika(Autoprevoznik autoprevoznik);
	void obrisiAutoprevoznika(int idAutoprevoznika);
	//public Boolean postojiAutoprevoznik(long idAutoprevoznika);

}
