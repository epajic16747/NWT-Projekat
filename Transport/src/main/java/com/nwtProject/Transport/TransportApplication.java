package com.nwtProject.Transport;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
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

	        Transport transport = new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe");
	        Transport transport2 = new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe");
	        Transport transport3 = new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe");

            transport.setCijenaMax(29.00);
            transport.setNaziv("Mirza prevoz");
            transport.setStatus("slobodan");
           
	        transportRepository.save(transport);
	        transportRepository.save(transport2);
	        transportRepository.save(transport3);
            transportRepository.notify();
	        // ======================================
		 
	    }
	   
	   @Bean
		public CommandLineRunner demo(TransportRepository repository) {
			return (args) -> {
				// save a couple of transports
				repository.save(new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe"));
				repository.save(new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe"));
				repository.save(new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe"));
				
			};
			}
}
