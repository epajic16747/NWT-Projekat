package com.nwtProject.Kompanija;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nwtProject.Kompanija.Models.Kompanija;
import com.nwtProject.Kompanija.Models.Transport;
import com.nwtProject.Kompanija.Repositories.KompanijaRepozitorij;
import com.nwtProject.Kompanija.Repositories.TransportRepozitorij;





@SpringBootApplication
public class KompanijaApplication {

	
	private static final Logger log = LoggerFactory.getLogger(KompanijaApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(KompanijaApplication.class);
	}
	
	
	@Bean
	public CommandLineRunner demo(KompanijaRepozitorij repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Kompanija((long) 1,"a","Jack", "Bauer","2", "4"));
			repository.save(new Kompanija((long) 2,"a2","Jack2", "Bauer2","2", "4"));
			repository.save(new Kompanija((long) 3,"a3","Jack3", "Bauer3","2", "4"));
			repository.save(new Kompanija((long) 4,"a4","Jack4", "Bauer4","2", "4"));
			repository.save(new Kompanija((long) 5,"a5","Jack5", "Bauer5","2", "4"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Kompanija customer : repository.findAll()) {
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
			repository.findByNaziv("a").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
	
	@Bean
	public CommandLineRunner demo1(TransportRepozitorij repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Transport((long) 1,(double)500,"datum1" ,1, "dobar",1, "a"));
	

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Transport customer : repository.findAll()) {
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
			repository.findByNaziv(5).forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customerocjena bauer : repository.findByOcjena("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}	
}
