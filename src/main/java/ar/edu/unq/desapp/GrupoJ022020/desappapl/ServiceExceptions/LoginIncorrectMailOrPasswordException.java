package ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions;

public class LoginIncorrectMailOrPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6478853253326968938L;

	public LoginIncorrectMailOrPasswordException() {
		super("ERROR - Incorrect mail or password");
	}
}
