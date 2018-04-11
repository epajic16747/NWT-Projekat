package com.nwtProject.repository;

import java.util.List;
import com.nwtProject.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Long> {

}

