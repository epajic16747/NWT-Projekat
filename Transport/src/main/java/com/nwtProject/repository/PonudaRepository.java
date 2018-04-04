package com.nwtProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import com.nwtProject.model.Ponuda;

@Repository
public interface PonudaRepository extends CrudRepository<Ponuda, Long> {

}

