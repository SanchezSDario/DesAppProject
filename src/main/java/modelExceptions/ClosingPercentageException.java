package modelExceptions;

public class ClosingPercentageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054449452266323878L;

	public ClosingPercentageException() {
		super("ERROR - Percentage must be between 50% and 100%");
	}
}
