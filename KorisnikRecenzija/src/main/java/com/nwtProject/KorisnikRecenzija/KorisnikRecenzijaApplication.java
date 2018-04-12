package com.nwtProject.KorisnikRecenzija;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;



import com.nwtProject.KorisnikRecenzija.Models.Korisnik;
import com.nwtProject.KorisnikRecenzija.Models.Recenzija;
import com.nwtProject.KorisnikRecenzija.Repositories.KorisnikRepozitorij;
import com.nwtProject.KorisnikRecenzija.Repositories.RecenzijaRepozitorij;

@SpringBootApplication
public class KorisnikRecenzijaApplication {

	
	//private static final Logger log = LoggerFactory.getLogger(KorisnikRecenzijaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KorisnikRecenzijaApplication.class, args);
	}
	
	
	
	
    @Bean

    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder.build();

    }
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 Projektni zadatak 1
	 
	@Bean
	public CommandLineRunner demo(KorisnikRepozitorij repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Korisnik((long) 1,"a","Jack", "Bauer",1, 1));
			repository.save(new Korisnik((long) 2,"a","Jack", "Bauer1",1, 1));
			repository.save(new Korisnik((long) 3,"a","Jack", "Bauer2",1, 1));
			repository.save(new Korisnik((long) 4,"a","Jack", "Bauer3",1, 1));
			repository.save(new Korisnik((long) 5,"a","Jack", "Bauer4",1, 1));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Korisnik customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByUsername("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
	@Bean
	public CommandLineRunner demo1(RecenzijaRepozitorij repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Recenzija((long) 1,"a",5 ,1, 1));
			repository.save(new Recenzija((long) 2,"b",4 ,2, 2));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Recenzija customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(customer -> {
					log.info("Recenzija found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByOcjena(5).forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customerocjena bauer : repository.findByOcjena("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}	*/
}


//Eureka service client 

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
