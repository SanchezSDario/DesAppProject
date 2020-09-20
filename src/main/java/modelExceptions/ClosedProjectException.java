package modelExceptions;

public class ClosedProjectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8639552361460601579L;

	public ClosedProjectException() {
		super("ERROR - Project is closed");
	}
}
