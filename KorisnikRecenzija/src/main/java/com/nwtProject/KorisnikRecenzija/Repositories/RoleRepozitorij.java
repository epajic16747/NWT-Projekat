package com.nwtProject.KorisnikRecenzija.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.nwtProject.KorisnikRecenzija.Models.Role;
import java.util.Optional;


	
public interface RoleRepozitorij extends CrudRepository<Role, Long> {
		public enum  RoleName {
	  	    ROLE_USER,
	  	    ROLE_ADMIN
	  	}
	   Optional<Role> findByName(RoleName roleName);
}