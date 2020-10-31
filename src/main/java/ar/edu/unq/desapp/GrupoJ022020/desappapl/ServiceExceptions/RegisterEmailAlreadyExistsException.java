package ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions;

public class RegisterEmailAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8838661835230514496L;

	public RegisterEmailAlreadyExistsException() {
		super("ERROR - Email already exists");
	}
}
