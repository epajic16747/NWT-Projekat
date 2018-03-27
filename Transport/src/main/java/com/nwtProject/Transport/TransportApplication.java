package com.nwtProject.Transport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nwtProject.model.Transport;
import com.nwtProject.repository.TransportRepository;

@SpringBootApplication
@ComponentScan({"com.nwtProject"})
@EntityScan("com.nwtProject")
@EnableJpaRepositories("com.nwtProject.repository")
public class TransportApplication {

	 @Autowired
	    private TransportRepository transportRepository;

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
	}
	
	
	   public void run(String... args) throws Exception {
	        // Cleanup Database tables
	        

	        // ======================================

	        Transport transport = new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe");
	       

	        transportRepository.save(transport);

	        // ======================================

	    }
}
