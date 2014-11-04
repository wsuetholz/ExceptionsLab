package lab3;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
 
    private static final int MIN_NAME_LEN = 2;
    private static final int ALLOWED_NAME_PARTS = 2;
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     * @throws InvalidNameException if fullName is null
     * @throws InvalidNameLengthException if fullName is too short.  Must be at least 2 characters long
     * @throws InvalidNameFormatException if fullName doesn't have the correct number of parts.  Must have 2 parts.
     */
    public String extractLastName(String fullName) throws IllegalArgumentException {
        if (fullName == null) {
	    throw new InvalidNameException();
	}
        if (fullName.length() < MIN_NAME_LEN) {
	    throw new InvalidNameLengthException();
	}
        String[] nameParts = fullName.split(" ");
	if (nameParts.length != ALLOWED_NAME_PARTS) {
	    throw new InvalidNameFormatException();
	}
        return nameParts[LAST_NAME_IDX].replace('_', ' ');
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     * @throws InvalidNameException if fullName is null
     * @throws InvalidNameLengthException if fullName is too short.  Must be at least 2 characters long
     * @throws InvalidNameFormatException if fullName doesn't have the correct number of parts.  Must have 2 parts.
     */
    public String extractFirstName(String fullName) throws IllegalArgumentException {
        if (fullName == null) {
	    throw new InvalidNameException();
	}
        if (fullName.length() < MIN_NAME_LEN) {
	    throw new InvalidNameLengthException();
	}
        String[] nameParts = fullName.split(" ");
	if (nameParts.length < ALLOWED_NAME_PARTS) {
	    throw new InvalidNameFormatException();
	}
        return nameParts[FIRST_NAME_IDX].replace('_', ' ');
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     * @throws InvalidNameException if fullName is null
     */
    public int getNameLength(String name) throws IllegalArgumentException {
        if (name == null) {
	    throw new InvalidNameException();
	}
        return name.length();
    }
    
}
