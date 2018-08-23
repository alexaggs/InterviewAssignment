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
				InformationRetrieval.isValidName(line, contact);
			}
			
			if(contact.getPhoneNumber().equals("No Valid Phone Number")) {
				InformationRetrieval.retrievePhoneNumber(line, contact);
			}
			
			if(contact.getEmailAddress().equals("No Valid Email Address")) {
				InformationRetrieval.retrieveEmail(line, contact);
			}
		}
	}
}