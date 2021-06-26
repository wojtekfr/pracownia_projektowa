package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.cli.Options;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {

	public static void main(String[] args) {
		System.out.println("main");
		
		ExcelLoader excelLoader = new ExcelLoader();
		Calculator calculator = new Calculator();
		
		String path = "src/main/resources/";
		float allHoursWorked = 0;
		ArrayList<File> excelFiles = excelLoader.FindAllExcleFiles(path);
		
		for (File file: excelFiles) {
				
		Workbook wb = excelLoader.loadExcelFile(file);
		System.out.println("przed  " + allHoursWorked);
		allHoursWorked += calculator.calculateHoursWorked(wb);
		System.out.println("po  " + allHoursWorked);
		}
		
		System.out.println(allHoursWorked);
		
//		
//		
//		
//		System.out.println();
//		File folder = new File("C:\\studia\\java\\pracownia\\src\\main\\resources");
//		File[] listOfFiles = folder.listFiles();
//
//		
//		for (File filex : listOfFiles) {
//		    System.out.print(filex.getName() + " ");
//		   
//		   // System.out.print(Utilities.getExtension(filex.getName()));
//		    System.out.println(filex.getName().endsWith("xlsx"));
//		    System.out.println();
//		}
//		
//		System.out.println();
		//String aaa = Utilities.getExtensionByStringHandling("qqqq.xxxxxx");
	//	System.out.println(aaa);
		
	}

}
