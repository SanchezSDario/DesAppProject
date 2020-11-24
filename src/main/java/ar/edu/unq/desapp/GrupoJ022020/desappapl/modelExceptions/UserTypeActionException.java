package ar.edu.unq.desapp.GrupoJ022020.desappapl.modelExceptions;

public class UserTypeActionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6127352082265416576L;

	public UserTypeActionException() {
		super("ERROR - This action can't be done due to the profile of the user");
	}
}
