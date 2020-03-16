
public class BadBadValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadBadValueException(String message) {
		super(message);
	}

	public BadBadValueException() {
		super("Negatif number");
	}

}
