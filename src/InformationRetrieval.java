import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import org.omg.CORBA.portable.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.util.regex.Matcher;

/*
 * This class is used to identify the correct name, email, and phone number 
 */

public class InformationRetrieval {

	// Regular expression for identifying if the pattern of the String matches an email pattern
	private static final String REGULAR_EXPRESSION_FOR_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	/*
	 * Regular expression for identifying if the pattern of the String matches an
	 * phone number This expression limits the phone number up to 25 characters and
	 * works for different phone number formats
	 */
	private static final String REGULAR_EXPRESSION_FOR_PHONE_NUMBER = "^\\+?[0-9. ()-]{10,25}$";

	private static Pattern p;

	private static Matcher matchPattern;

	/*
	 * Checks if the current line is a valid email
	 */
	public static void setEmail(String email, ContactInfo contact) {
		String lines[] = email.split("\\s+");

		Boolean isValidEmail = false;

		for (String word : lines) {
			p = Pattern.compile(REGULAR_EXPRESSION_FOR_EMAIL, Pattern.CASE_INSENSITIVE);
			matchPattern = p.matcher(word);
			isValidEmail = matchPattern.matches();
			if (isValidEmail) {
				contact.setEmail(word);
			}
		}
	}

	/*
	 * Checks if the current line is a valid phone number
	 */
	public static void setPhoneNumber(String number, ContactInfo contact) {
		Boolean isValidPhoneNumber = false;

		// If the number isn't a fax, then we want to continue to check if it is a valid
		// phone number
		if (!number.contains("Fax")) {
			number = separatePhoneNumber(number);
			p = Pattern.compile(REGULAR_EXPRESSION_FOR_PHONE_NUMBER, Pattern.CASE_INSENSITIVE);
			matchPattern = p.matcher(number);
			isValidPhoneNumber = matchPattern.matches();
			if (isValidPhoneNumber) {
				number = number.replaceAll("[()]", "");
				number = number.replaceAll("[-]", "");
				number = number.replaceAll("\\s+","");
				contact.setPhoneNumber(number);	
			}
		}
	}
	
	/*
	 * This method is to separate the actual number from any other text on the same line.
	 * This comes into play when you have an input that has the text "Phone:" in it or
	 * something similar
	 */
	public static String separatePhoneNumber(String number) {
		char num = 0;
		String seperatedNumber = "";
		try {
			for(char c: number.toCharArray()) {
				if(isAValidInteger(String.valueOf(c))) {
					num = c;
					break;
				}
			}
			seperatedNumber = number.substring(number.indexOf(num), number.length());
		} catch(Exception e) {
			
		}
		return seperatedNumber;
	}
	
	/*
	 * Checks if the current line is a valid name
	 */
	public static void setName(String name, ContactInfo contact) throws IOException {		
		//Accessing the pre-trained model file to identify names
        FileInputStream is = new FileInputStream("en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(is);
        is.close();
                
        NameFinderME nameFinder = new NameFinderME(model);
        
        String[] sentence = name.split("\\s+");
 
        Span nameSpans[] = nameFinder.find(sentence);
        //Converting the Spans to the corresponding name(s)
        String names[] = Span.spansToStrings(nameSpans, sentence);
        for(String s: names) {
            //The model we are using sometimes recognizes integers as a name, so this is a check to see if the recognized name is an Integer or not
        	if(!isAValidInteger(s)) {
        		contact.setName(s);
        	}
        }
	}
	
	/*
	 * Checks if the String can be parsed into an Integer 
	 */
	public static boolean isAValidInteger(String s) {
		Boolean exceptionCaught = true;

		try {
    		Integer.parseInt(s);
    	} catch(Exception e) {
    		exceptionCaught = false;
    	}
		
		return exceptionCaught;
	}

}
