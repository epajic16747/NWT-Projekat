package org.transport.autoprevoznik.autoprevoznik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.transport.autoprevoznik.autoprevoznik.dao.AutoprevoznikDao;


@SpringBootApplication
public class AutoprevoznikApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutoprevoznikApplication.class, args);
	}
}
