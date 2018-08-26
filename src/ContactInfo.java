
public class ContactInfo {
	
	private String name, email, phoneNumber;
	
	public ContactInfo() {
		this.email = "No Valid Email Address";
		this.phoneNumber = "No Valid Phone Number";
		this.name = "No Valid Name";
	}
	
	public ContactInfo(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return email;
	}
	
	public String displayInformation() {
		return "Name: " + this.getName() + "\nPhone: " + this.getPhoneNumber() + "\nEmail: " + this.getEmailAddress();
	}
}
