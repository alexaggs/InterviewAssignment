import java.io.IOException;

public class BusinessCardParser {

	public static ContactInfo getContactInfo(String document) throws IOException {
		//Splits the string up by each line
		String lines[] = document.split("\\r?\\n");
		
		/*
		 * Setting default values for the ContactInfo object in case there were no valid names, email addressed or phone numbers found
		 */
		String emailInvalid = "No Valid Email Address";
		String phoneInvalid = "No Valid Phone Number";
		String nameInvalid = "No Valid Name";
		ContactInfo contact = new ContactInfo(nameInvalid, emailInvalid, phoneInvalid);
		
		setContactInfo(lines, contact);
		
		return contact;
	}
	
	public static void setContactInfo(String[] lines, ContactInfo contact) throws IOException {
		for(String line : lines) {
			if(contact.getName().equals("No Valid Name")) {
				BusinessCardParser.retrieveName(line, contact);
			}
			
			if(contact.getPhoneNumber().equals("No Valid Phone Number")) {
				BusinessCardParser.retrievePhoneNumber(line, contact);
			}
			
			if(contact.getEmailAddress().equals("No Valid Email Address")) {
				BusinessCardParser.retrieveEmailAddress(line, contact);
			}
		}
	}
	
	public static void retrieveName(String line, ContactInfo contact) throws IOException {
		InformationRetrieval.isValidName(line, contact);
	}
	
	public static void retrievePhoneNumber(String line, ContactInfo contact) {
		InformationRetrieval.isValidPhoneNumber(line, contact);
	}
	
	public static void retrieveEmailAddress(String line, ContactInfo contact) {
		InformationRetrieval.isValidEmail(line, contact);
	}
}