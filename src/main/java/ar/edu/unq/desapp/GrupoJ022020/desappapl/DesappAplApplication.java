package ar.edu.unq.desapp.GrupoJ022020.desappapl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DesappAplApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DesappAplApplication.class, args);
	}

}
