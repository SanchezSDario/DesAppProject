package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
}
