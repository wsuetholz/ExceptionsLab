package lab3;

/**
 *
 * @author wsuetholz
 * @version 1.0
 */
public class InvalidNameLengthException extends IllegalArgumentException {
    private static String exceptionString = "Name Length Invalid!";
    
    public InvalidNameLengthException() {
	super (exceptionString);
    }

    public InvalidNameLengthException(String s) {
	super(exceptionString + "\n" + s);
    }

    public InvalidNameLengthException(String message, Throwable cause) {
	super(exceptionString + "\n" + message, cause);
    }

    public InvalidNameLengthException(Throwable cause) {
	super(exceptionString, cause);
    }
}
