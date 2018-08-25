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
	public void testIsValidNameShouldSetNameAccordingly() {
		String name = "Alex Aguilar";
		
		ContactInfo testContact = new ContactInfo();
		
		try {
			InformationRetrieval.setName(name, testContact);
		} catch (IOException e) {
			
		}
		
		assertEquals(name, testContact.getName());
	}
	
	@Test
	public void testIsValidNameShouldReturnFalseAndNotChangeName() {
		String name = "Not a valid name..";
		
		ContactInfo testContact = new ContactInfo();
		
		try {
			InformationRetrieval.setName(name, testContact);
		} 
		catch (IOException e) {
		}
		
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
		
		ContactInfo testContactOne = new ContactInfo();
		ContactInfo testContactTwo = new ContactInfo();
		ContactInfo testContactThree = new ContactInfo();
		ContactInfo testContactFour = new ContactInfo();
		
		
		InformationRetrieval.setPhoneNumber(testInputOne, testContactOne);
		InformationRetrieval.setPhoneNumber(testInputTwo, testContactTwo);
		InformationRetrieval.setPhoneNumber(testInputThree, testContactThree);
		InformationRetrieval.setPhoneNumber(testInputFour, testContactFour);
		
		String inputOneShouldBe = "17035551259";
		String inputTwoShouldBe = "7324442222";
		String inputThreeShouldBe = "7327773333";
		String inputFourShouldBe = "9088002233";


		assertEquals(testContactOne.getPhoneNumber(), inputOneShouldBe);
		assertEquals(testContactTwo.getPhoneNumber(), inputTwoShouldBe);
		assertEquals(testContactThree.getPhoneNumber(), inputThreeShouldBe);
		assertEquals(testContactFour.getPhoneNumber(), inputFourShouldBe);
	}
	
	@Test
	public void isValidPhoneNumberShouldNotChangePhoneNumberWithInvalidInput() {
		String testInputFive = "Fax: 2223334444";
		
		ContactInfo testContact = new ContactInfo();

		InformationRetrieval.setPhoneNumber(testInputFive, testContact);

		assertEquals(testContact.getPhoneNumber(), "No Valid Phone Number");
	}
	
	@Test
	public void isValidEmailShouldRetrieveCorrectEmailAndSetEmailAccordingly() {
		String testEmail = "aaguila3@villanova.edu";
		
		ContactInfo testContact = new ContactInfo();
		
		InformationRetrieval.setEmail(testEmail, testContact);
		
		assertEquals(testEmail, testContact.getEmailAddress());
	}
	
	@Test
	public void isValidEmailShouldNotRetrieveCorrectEmailAndNotChangeEmail() {
		String testEmail = "Not.An.Email";
		
		ContactInfo testContact = new ContactInfo();
		
		InformationRetrieval.setEmail(testEmail, testContact);
		
		assertEquals("No Valid Email Address", testContact.getEmailAddress());
	}
}
