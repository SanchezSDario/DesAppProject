package ar.edu.unq.desapp.GrupoJ022020.desappapl.ServiceExceptions;

public class InvalidEmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322157295916671831L;

	public InvalidEmailException() {
		super("ERROR - Email is invalid");
	}
}
