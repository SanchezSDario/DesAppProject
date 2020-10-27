package ar.edu.unq.desapp.GrupoJ022020.desappapl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DesappAplApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DesappAplApplication.class, args);
	}

}
