package lab3;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private static int MAX_TRIES = 10; 
    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        
        String fullName = null;
        String lastName = null;
	int numTries = 0;
        String prompt = "Please First and Last Name.  If you have a name portion \nthat is two words, then seperate them by the '_' character.\n\nEnter full name:";

	while (numTries++ < MAX_TRIES && lastName == null) {
	    try {
		fullName = JOptionPane.showInputDialog(prompt);
		lastName = nameService.extractLastName(fullName);
	    } catch (IllegalArgumentException ex) {
		JOptionPane.showMessageDialog(null, "Problem with Input!\n" + ex.getMessage());    
	    }
	}

	if (lastName != null && lastName.length() > 0) {
	    String msg = "Your last name is: " + lastName;
	    JOptionPane.showMessageDialog(null, msg);
	}
        
        
    }
     
}
