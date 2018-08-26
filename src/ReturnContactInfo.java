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
		Boolean stillTesting = true;
		
		while(stillTesting) {
			userInputByLine.clear();
			userInput = "";
			while(scan.hasNextLine()) {
				userInputByLine.add(scan.nextLine());
				if(userInputByLine.contains("")) {
					userInputByLine.remove("");
					break;
				}
				
				if(userInputByLine.contains("Done")) {
					stillTesting = false;
					System.out.println("Process Terminated");
					break;
				}
			}
			
			//We don't want to execute the code again if we terminate the process
			if(!stillTesting) {
				break;
			}
			
			//Putting the user input into a string separated by a new line for each input
			for(String t: userInputByLine) {
				userInput += t + "\n";
			}
			
			ContactInfo contactInformation = BusinessCardParser.getContactInfo(userInput);
			System.out.println(contactInformation.displayInformation());			
		}
		scan.close();
	}
}
