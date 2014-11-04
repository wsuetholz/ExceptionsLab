package lab3;

/**
 *
 * @author wsuetholz
 * @version 1.0
 */
public class InvalidNameException extends IllegalArgumentException {
    private static final String exceptionString = "Name Parameter Invalid!";
    
    public InvalidNameException() {
	super (exceptionString);
    }

    public InvalidNameException(String s) {
	super(exceptionString + "\n" + s);
    }

    public InvalidNameException(String message, Throwable cause) {
	super(exceptionString + "\n" + message, cause);
    }

    public InvalidNameException(Throwable cause) {
	super(exceptionString, cause);
    }
}
