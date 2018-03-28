package com.nwtProject.KorisnikRecenzija.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nwtProject.KorisnikRecenzija.Models.Recenzija;


public interface RecenzijaRepozitorij extends CrudRepository<Recenzija, Long> {

    List<Recenzija> findByOcjena(int ocjena);
}

