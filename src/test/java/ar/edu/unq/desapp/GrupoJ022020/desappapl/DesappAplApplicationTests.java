package ar.edu.unq.desapp.GrupoJ022020.desappapl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesappAplApplicationTests {

	//Just a test
	@Test
	void contextLoads() {
		String [] args = new String[1];
	    args[0] = "test";
		DesappAplApplication.main(args);
	}

}
