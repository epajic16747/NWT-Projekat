package com.nwtProject.Transport;


//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/*
import com.nwtProject.model.Ponuda;
import com.nwtProject.model.Transport;
import com.nwtProject.model.PutniNalog;
import com.nwtProject.repository.PonudaRepository;
import com.nwtProject.repository.TransportRepository;
import com.nwtProject.repository.PutniNalogRepository;
*/
@SpringBootApplication
@ComponentScan({"com.nwtProject"})
//@EntityScan("com.nwtProject")
@EnableJpaRepositories("com.nwtProject.repository")
public class TransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
	}
	
	
	/*
	 @Autowired
	    private TransportRepository transportRepository;
	 @Autowired
	    private PonudaRepository ponudaRepository;
	 @Autowired
	    private PutniNalogRepository putninalogRepository;

	
	

	
	
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
		public CommandLineRunner transportBean(TransportRepository repository) {
			return (args) -> {
				// save a couple of transports
				repository.save(new Transport(1, 250.3, "03.01.2017",2, "slobodan", 12, "Transport robe"));
			};
			}
	   
	   
	   @Bean
		public CommandLineRunner ponudaBean(PonudaRepository ponudarepository) {
			return (args) -> {
				
				ponudarepository.save(new Ponuda(1, 339.80 , "automobil",1, 2));
			};
			}
	   @Bean
		public CommandLineRunner putninalogBean(PutniNalogRepository putninalogrepository) {
			return (args) -> {
				
				putninalogrepository.save(new PutniNalog(1, "Živinice -> Sarajevo",3, "dfd"));
			};
		}*/
}
