package ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.service.EmailService;

@RestController
@EnableAutoConfiguration
public class EmailController {

	@Autowired
    private EmailService emailService;

	@GetMapping("/api/email/closeProject")
	@ResponseBody
    public void sendMail(@RequestParam Long projectId) {
		emailService.sendProjectClosedEmail(projectId);
	}
}
