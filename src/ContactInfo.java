
public class ContactInfo {
	
	private String name, email, phoneNumber;
	
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
		return "Name: " + this.getName() + "\nEmail: " + this.getEmailAddress() + "\nPhone: " + this.getPhoneNumber();
	}

}
