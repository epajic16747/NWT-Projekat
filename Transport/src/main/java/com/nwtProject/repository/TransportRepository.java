package com.nwtProject.repository;

import java.util.List;
import com.nwtProject.model.Transport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Long> {

	@Query("select t from Transport t where t.status = :status")
	Iterable<Transport> dajAktivne(@Param("status") String status);
}

