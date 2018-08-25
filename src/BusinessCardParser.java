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
	
	/*
	 * Sets the contact information based on the input
	 */
	public static void setContactInfo(String[] lines, ContactInfo contact) throws IOException {
		for(String line : lines) {
			if(contact.getName().equals("No Valid Name")) {
				retrieveName(line, contact);
			}
			
			if(contact.getPhoneNumber().equals("No Valid Phone Number")) {
				retrievePhoneNumber(line, contact);
			}
			
			if(contact.getEmailAddress().equals("No Valid Email Address")) {
				retrieveEmailAddress(line, contact);
			}
		}
	}
	
	/*
	 * Gets the Name based off the input
	 */
	public static void retrieveName(String line, ContactInfo contact) throws IOException {
		InformationRetrieval.setName(line, contact);
	}
	
	/*
	 * Gets the Phone Number based off the input
	 */
	public static void retrievePhoneNumber(String line, ContactInfo contact) {
		InformationRetrieval.setPhoneNumber(line, contact);
	}
	
	/*
	 * Gets the Email Address based off the input
	 */
	public static void retrieveEmailAddress(String line, ContactInfo contact) {
		InformationRetrieval.setEmail(line, contact);
	}
}