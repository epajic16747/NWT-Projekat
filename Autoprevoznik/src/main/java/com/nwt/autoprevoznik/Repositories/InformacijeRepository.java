package com.nwt.autoprevoznik.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nwt.autoprevoznik.Models.Autoprevoznik;
import com.nwt.autoprevoznik.Models.Informacije;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface InformacijeRepository extends CrudRepository<Informacije, Integer> {
	
	
}