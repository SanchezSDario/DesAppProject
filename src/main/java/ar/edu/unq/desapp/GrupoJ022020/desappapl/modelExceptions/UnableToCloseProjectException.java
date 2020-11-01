package ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions;

public class UnableToCloseProjectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4633899026642325693L;

	public UnableToCloseProjectException() {
		super("ERROR - Project can't be closed in it's actual status");
	}
}
