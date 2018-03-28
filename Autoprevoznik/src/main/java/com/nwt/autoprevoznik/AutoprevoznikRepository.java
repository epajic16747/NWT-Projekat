package com.nwt.autoprevoznik;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AutoprevoznikRepository extends CrudRepository<Autoprevoznik, Integer> {
	
	@Query("select a from Autoprevoznik a where a.naziv = :naziv")
	Iterable<Autoprevoznik> dajPrevoznikaPoNazivu(@Param("naziv") String naziv);
}