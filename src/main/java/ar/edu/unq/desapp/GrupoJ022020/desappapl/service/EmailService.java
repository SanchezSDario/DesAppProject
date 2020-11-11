package ar.edu.unq.desapp.GrupoJ022020.desappapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Donation;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.Project;
import ar.edu.unq.desapp.GrupoJ022020.desappapl.model.User;

@Component
@Service
@Transactional
public class EmailService{

	@Autowired
    private JavaMailSender mailSender;
	@Autowired
    private DonationService donationService;
	@Autowired
    private ProjectService projectService;
	@Autowired
    private UserService userService;

    public void sendEmail(String[] to, String subject, String content) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);
       
        mailSender.send(email);
    }
    
    @Scheduled(cron = "0 0 9 * * 2", zone = "America/Argentina/Buenos_Aires")
    public void sendTop10DonationsAndTop10Cities() {
    	String mostExpensiveDonationsMessage = "Mejores donaciones: \n";
    	String citiesWithOldestDonationsDateMessage = "Proyectos que no han recibido donaciones hace tiempo: \n";
    	for(Donation donation : donationService.getExpensiveDonations()) {
    		mostExpensiveDonationsMessage += "Cantidad donada: " + donation.getAmount() + ". Fecha de donacion: " + donation.getDonationDate() + "\n";
    	}
    	for(Project project: projectService.getProjectsWithOldestDonationDate()) {
    		String ultimaFechaDeDonacionProyecto;
    		try {
				ultimaFechaDeDonacionProyecto = project.getDonationWithEarlierDonationDate().getDonationDate().toString();
			} catch (Exception e) {
				ultimaFechaDeDonacionProyecto = "Sin donaciones registradas";
			}
    		citiesWithOldestDonationsDateMessage += "Proyecto: " + project.getName() + ". Ultima fecha de donacion registrada: " + ultimaFechaDeDonacionProyecto + "\n";
    	}
    	 
	    List<String> recipientsList = new ArrayList<String>();
    	for(User user : this.userService.findAll()) {
    		recipientsList.add(user.getMail());
    	}
    	String[] recipients = new String[recipientsList.size()];
	    
    	this.sendEmail(recipientsList.toArray(recipients), 
	    			   "Informe diario de mejores donaciones y proyectos que no recibieron donaciones hace tiempo", 
	    			   "Informe diario \n\n" + mostExpensiveDonationsMessage + "\n" + citiesWithOldestDonationsDateMessage);
    }
    
    public void sendProjectClosedEmail(Long projectId) {
    	Project closedProject = projectService.findByID(projectId);
    	List<User> donorUsers = userService.findAll().stream().filter(user -> user.getProjectsDonatedTo().contains(closedProject)).collect(Collectors.toList());
    	String donorUsersMessage = "Gracias a todos los usuarios que colaboraron con el proyecto!\n";
    	List<String> recipientsList = new ArrayList<String>();
    	for(User user : donorUsers){
    		donorUsersMessage += "Usuario: " + user.getNickName() + "\n";
    		recipientsList.add(user.getMail());
    	}
    	 
    	String[] recipients = new String[recipientsList.size()];
	    
    	this.sendEmail(recipientsList.toArray(recipients), 
	    			   "Cierre de proyecto " + closedProject.getName(), 
	    			   "El proyecto " + closedProject.getName() + " finalizó" + "\n\n" + donorUsersMessage);
    }
}