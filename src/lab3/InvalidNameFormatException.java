package lab3;

/**
 *
 * @author wsuetholz
 * @version 1.0
 */
public class InvalidNameFormatException extends IllegalArgumentException {
    private static String exceptionString = "Name Format Invalid!";
    
    public InvalidNameFormatException() {
	super (exceptionString);
    }

    public InvalidNameFormatException(String s) {
	super(exceptionString + "\n" + s);
    }

    public InvalidNameFormatException(String message, Throwable cause) {
	super(exceptionString + "\n" + message, cause);
    }

    public InvalidNameFormatException(Throwable cause) {
	super(exceptionString, cause);
    }
}
