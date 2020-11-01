package ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions;

public class LoginIncorrectMailUserNameOrPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6478853253326968938L;

	public LoginIncorrectMailUserNameOrPasswordException() {
		super("ERROR - Incorrect mail, username or password");
	}
}
