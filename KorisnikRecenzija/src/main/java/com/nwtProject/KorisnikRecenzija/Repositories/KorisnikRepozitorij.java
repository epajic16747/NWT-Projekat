package com.nwtProject.KorisnikRecenzija.Repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;

public interface KorisnikRepozitorij extends CrudRepository<Korisnik, Long> {

    List<Korisnik> findByUsername(String username);
}
