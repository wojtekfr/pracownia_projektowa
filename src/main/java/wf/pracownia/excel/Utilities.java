package wf.pracownia.excel;


import java.util.Scanner;



public class Utilities {



	public String parseNameFromFile(String fileName) {

		String[] fileNameFirstSplit = fileName.split("_");
		String[] fileNameSecondSplit = fileNameFirstSplit[1].split("\\.");
		
		String employeeName = fileNameFirstSplit[0] + " " + fileNameSecondSplit[0];
		return employeeName;
		
	}
	
	public String askForPath() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter path contaning files for processing");
		return scanner.nextLine();
	}
	
}
