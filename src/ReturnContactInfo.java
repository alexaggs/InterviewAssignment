import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReturnContactInfo {

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		List<String> token = new ArrayList<String>();	
		String userInput = "";
		
		while(scan.hasNextLine()) {
			token.add(scan.nextLine());
			if(token.contains("")) {
				token.remove("");
				break;
			}
		}
		scan.close();
		for(String t: token) {
			userInput += t + "\n";
		}
		
		ContactInfo contactInformation = BusinessCardParser.getContactInfo(userInput);
		System.out.println(contactInformation.displayInformation());
	}
}
