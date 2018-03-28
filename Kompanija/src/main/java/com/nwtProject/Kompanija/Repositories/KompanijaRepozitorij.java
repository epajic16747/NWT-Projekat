package com.nwtProject.Kompanija.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nwtProject.Kompanija.Models.Kompanija;


public interface KompanijaRepozitorij extends CrudRepository<Kompanija, Long> {

    List<Kompanija> findByNaziv(String naziv);
}