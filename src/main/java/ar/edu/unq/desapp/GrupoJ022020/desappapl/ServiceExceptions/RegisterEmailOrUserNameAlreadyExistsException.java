package ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions;

public class RegisterEmailOrUserNameAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8838661835230514496L;

	public RegisterEmailOrUserNameAlreadyExistsException() {
		super("ERROR - Email or username already exists");
	}
}
