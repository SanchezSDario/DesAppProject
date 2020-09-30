package ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions;

public class FactorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1874143948863439720L;

	public FactorException() {
		super("ERROR - Factor must be between 0 and 100000");
	}
}
