package ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions;

public class ClosedProjectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8639552361460601579L;

	public ClosedProjectException() {
		super("ERROR - Project is closed");
	}
}
