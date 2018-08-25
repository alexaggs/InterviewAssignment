import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class InformationRetrievalTest {

	@Test
	public void testIsAValidIntegerShouldReturnTrue() {
		String testString = "24";
		
		Boolean isAValidInteger = InformationRetrieval.isAValidInteger(testString);
		
		assertEquals(true, isAValidInteger);
	}
	
	@Test
	public void testIsAValidIntegerShouldReturnFalse() {
		String testString = "Not an Integer";
		
		Boolean isAValidInteger = InformationRetrieval.isAValidInteger(testString);
		
		assertEquals(false, isAValidInteger);
	}
	
	@Test
	public void testIsValidNameShouldReturnTrueAndSetNameAccordingly() {
		String name = "Alex Aguilar";
		
		ContactInfo testContact = new ContactInfo();
		
		Boolean isAValidName = false;
		
		try {
			isAValidName = InformationRetrieval.isValidName(name, testContact);
		} catch (IOException e) {
			
		}
		
		assertEquals(true, isAValidName);
		assertEquals(name, testContact.getName());
	}
	
	@Test
	public void testIsValidNameShouldReturnFalseAndNotChangeName() {
		String name = "Not a valid name..";
		
		ContactInfo testContact = new ContactInfo();
		
		Boolean isAValidName = true;
		
		try {
			isAValidName = InformationRetrieval.isValidName(name, testContact);
		} catch (IOException e) {
			isAValidName = false;
		}
		
		assertEquals(false, isAValidName);
		assertEquals("No Valid Name", testContact.getName());
	}
	
	@Test
	public void testSeparatePhoneNumberShouldSeparateNumberCorrectly() {
		String testPhoneNumber = "Phone: 7322378999";
		
		String separatedNumber = InformationRetrieval.separatePhoneNumber(testPhoneNumber);
		
		String expectedOutput = "7322378999";
		
		assertEquals(expectedOutput, separatedNumber);
	}
	
	@Test
	public void testSeparatePhoneNumberShouldNotReturnBlankStringOnBadInput() {
		String testPhoneNumber = "Phone: Bad Input";
		
		String separatedNumber = InformationRetrieval.separatePhoneNumber(testPhoneNumber);
				
		String expectedOutput = "";
		
		assertEquals(expectedOutput, separatedNumber);
	}
	
	@Test
	public void isValidPhoneNumberShouldGetCorrectPhoneNumberAndSetPhoneNumberCorrectly() {
		String testInputOne = "+1 (703) 555-1259";
		String testInputTwo = "732 444 2222";
		String testInputThree = "Phone: (732)777-3333";
		String testInputFour = "908-800-2233";
		
		ContactInfo testContact = new ContactInfo();
		
		Boolean retrieveNumberOne = InformationRetrieval.isValidPhoneNumber(testInputOne, testContact);
		Boolean retrieveNumberTwo = InformationRetrieval.isValidPhoneNumber(testInputTwo, testContact);
		Boolean retrieveNumberThree = InformationRetrieval.isValidPhoneNumber(testInputThree, testContact);
		Boolean retrieveNumberFour = InformationRetrieval.isValidPhoneNumber(testInputFour, testContact);

		assertEquals(true, retrieveNumberOne);
		assertEquals(true, retrieveNumberTwo);
		assertEquals(true, retrieveNumberThree);
		assertEquals(true, retrieveNumberFour);
	}
	
	@Test
	public void isValidPhoneNumberShouldNotGetPhoneNumberWhenInvalid() {
		String testInputFive = "Fax: 2223334444";
		
		ContactInfo testContact = new ContactInfo();

		Boolean retrieveNumberFive = InformationRetrieval.isValidPhoneNumber(testInputFive, testContact);

		assertEquals(false, retrieveNumberFive);
	}
	
	@Test
	public void isValidEmailShouldRetrieveCorrectEmailAndSetEmailAccordingly() {
		String testEmail = "aaguila3@villanova.edu";
		
		ContactInfo testContact = new ContactInfo();
		
		Boolean retrievEmail = InformationRetrieval.isValidEmail(testEmail, testContact);
		
		assertEquals(true, retrievEmail);
		assertEquals(testEmail, testContact.getEmailAddress());
	}
	
	@Test
	public void isValidEmailShouldNotRetrieveCorrectEmailAndNotChangeEmail() {
		String testEmail = "Not.An.Email";
		
		ContactInfo testContact = new ContactInfo();
		
		Boolean retrievEmail = InformationRetrieval.isValidEmail(testEmail, testContact);
		
		assertEquals(false, retrievEmail);
		assertEquals("No Valid Email Address", testContact.getEmailAddress());
	}
}
