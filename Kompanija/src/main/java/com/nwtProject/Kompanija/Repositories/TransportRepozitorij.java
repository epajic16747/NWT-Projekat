package com.nwtProject.Kompanija.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nwtProject.Kompanija.Models.Transport;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepozitorij extends CrudRepository<Transport, Long> {

    List<Transport> findByNaziv(int naziv);
}