package com.nwtProject.KorisnikRecenzija.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;

public interface KorisnikRepozitorij extends CrudRepository<Korisnik, Long> {

  
    Boolean existsByUsername(String username);

	static Optional<Korisnik> findByUsername(String username) {
		// TODO Auto-generated method stub
		
		return KorisnikRepozitorij.findByUsername(username);
	}
}
