package lab3;

/**
 *
 * @author wsuetholz
 * @version 1.0
 */
public class InvalidNameLengthException extends IllegalArgumentException {
    private static final String exceptionString = "Name Length Invalid!";
    
    public InvalidNameLengthException() {
	super (exceptionString);
    }

    public InvalidNameLengthException(String s) {
	super(exceptionString);
    }

    public InvalidNameLengthException(String message, Throwable cause) {
	super(exceptionString, cause);
    }

    public InvalidNameLengthException(Throwable cause) {
	super(exceptionString, cause);
    }
}
