package com.nwtProject.KorisnikRecenzija;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;
import com.nwtProject.KorisnikRecenzija.Repositories.KorisnikRepozitorij;

@SpringBootApplication
public class KorisnikRecenzijaApplication {

	
	private static final Logger log = LoggerFactory.getLogger(KorisnikRecenzijaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KorisnikRecenzijaApplication.class);
	}
	
	@Bean
	public CommandLineRunner demo(KorisnikRepozitorij repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Korisnik((long) 10000,"a","Jack", "Bauer",1, 1));
			repository.save(new Korisnik((long) 10001,"a","Jack", "Bauer",1, 1));
			repository.save(new Korisnik((long) 10002,"a","Jack", "Bauer",1, 1));
			repository.save(new Korisnik((long) 10003,"a","Jack", "Bauer",1, 1));
			repository.save(new Korisnik((long) 10004,"a","Jack", "Bauer",1, 1));

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
}
