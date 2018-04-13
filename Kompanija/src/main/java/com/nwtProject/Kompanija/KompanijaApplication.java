package com.nwtProject.Kompanija;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nwtProject.Kompanija.Models.Kompanija;
import com.nwtProject.Kompanija.Models.Transport;
import com.nwtProject.Kompanija.Repositories.KompanijaRepozitorij;
import com.nwtProject.Kompanija.Repositories.TransportRepozitorij;




@EnableEurekaClient
@SpringBootApplication
public class KompanijaApplication {

	
	//private static final Logger log = LoggerFactory.getLogger(KompanijaApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(KompanijaApplication.class,args);
	}
	
	/*
    @Bean

    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder.build();

    }*/
	/*
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
	}	*/
}
/*
@RestController
class ServiceInstanceRestController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(
          @PathVariable String applicationName) {
      return this.discoveryClient.getInstances(applicationName);
  }
}*/