package wf.pracownia.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {

	public static void main(String[] args) {
		System.out.println("main");
		String file = "src/main/resources/2012/01/Kowalski_Jan.xls";
		
		ExcelLoader excelLoader = new ExcelLoader();
		Calculator calculator = new Calculator();
		Workbook wb = excelLoader.loadExcelFile(file);
		System.out.println(calculator.calculateHoursWorked(wb));
		
	}

}
