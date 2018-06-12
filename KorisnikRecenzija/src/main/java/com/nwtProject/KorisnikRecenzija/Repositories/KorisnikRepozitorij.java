package com.nwtProject.KorisnikRecenzija.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;

public interface KorisnikRepozitorij extends CrudRepository<Korisnik, Long> {

  
    Boolean existsByUsername(String username);
    
    @Query("select k from Korisnik k where k.username=:username and k.password=:password")
	Iterable<Korisnik> findByUsernamePw(@Param("username") String username, @Param("password") String password);
    
    @Query("select k from Korisnik k where k.username=:username")
	Iterable<Korisnik> findByUsername(@Param("username") String username);
    
    
    //@Query("SELECT k FROM korisnik k WHERE k.username=:username and k.password=:password")
    //Korisnik findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    Korisnik findByUsernameAndPassword( String username, String password);
}
