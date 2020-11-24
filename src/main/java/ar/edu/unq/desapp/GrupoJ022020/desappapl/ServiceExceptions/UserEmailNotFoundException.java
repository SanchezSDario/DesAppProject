package ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserEmailNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2532809505986732360L;
	
	public UserEmailNotFoundException() {
		super("ERROR - User email not found");
	}

}
