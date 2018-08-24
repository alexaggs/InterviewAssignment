import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReturnContactInfo {

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		List<String> userInputByLine = new ArrayList<String>();	
		String userInput = "";
		
		while(scan.hasNextLine()) {
			userInputByLine.add(scan.nextLine());
			if(userInputByLine.contains("")) {
				userInputByLine.remove("");
				break;
			}
		}
		scan.close();
		
		//Putting the user input into a string separated by a new line for each input
		for(String t: userInputByLine) {
			userInput += t + "\n";
		}
		
		ContactInfo contactInformation = BusinessCardParser.getContactInfo(userInput);
		System.out.println(contactInformation.displayInformation());
	}
}
