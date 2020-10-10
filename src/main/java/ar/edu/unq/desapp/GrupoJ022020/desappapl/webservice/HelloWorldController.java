package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
	@RequestMapping("/")
    @ResponseBody
    public String home() {
      return "Hello World!";
    }
	
	@GetMapping("/api/version")
	@ResponseBody
	public ResponseEntity<?> getVersion() {
    	String version = "0.2.1";
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("version", version);
		return ResponseEntity.ok().body(resultado);
	}
}
