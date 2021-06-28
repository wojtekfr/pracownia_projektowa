package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.cli.Options;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {

	static ArrayList<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {
		System.out.println("main");

		ExcelLoader excelLoader = new ExcelLoader();
		Calculator calculator = new Calculator();

		employees.add(new Employee("Janusz"));
		findEmployeeByName("Janusz").addNewYearToEmployee(2012);
		
		findEmployeeByName("Janusz").findYearByCalendarDate(2012).increaseHoursWorkedInMonth(1, 66);
		findEmployeeByName("Janusz").findYearByCalendarDate(2012).increaseHoursWorkedInMonth(1, 33);

		employees.get(0).addNewYearToEmployee(2013);
		employees.get(0).getYearByOrder(1).increaseHoursWorkedInMonth(0, 10);
		employees.get(0).getYearByOrder(1).increaseHoursWorkedInMonth(1, 13);

		employees.add(new Employee("Grazyna"));
		employees.get(1).addNewYearToEmployee(2012);
		employees.get(1).getYearByOrder(0).increaseHoursWorkedInMonth(1, 333);
		employees.get(1).addNewYearToEmployee(2020);
		employees.get(1).getYearByOrder(1).increaseHoursWorkedInMonth(3, 666);
		
		findEmployeeByName("Janusz").getYearByOrder(0).increaseHoursWorkedInMonth(0, 13);
		
		findEmployeeByName("Janusz").findYearByCalendarDate(2012).increaseHoursWorkedInMonth(0, 7);

		for (Employee employee : employees) {
			System.out.println(employee.getName());
			for (Year year : employee.getYearsWhenEmployeeWorked()) {
				System.out.println(year.getCalendarYear());
				int counter = 0;
				for (double hours : year.getHoursWorkedInGivenMonth()) {
					System.out.println("miesiac : " + counter + " : " + hours);
					counter++;
				}
			}
	
		}

		System.out.println();
		
		System.out.println();
		String path = "src/main/resources/";
		double totalHoursWorked = 0;
		ArrayList<File> excelFiles = excelLoader.FindAllExcleFiles(path);

		for (File file : excelFiles) {

			Workbook wb = excelLoader.loadExcelFile(file);
			System.out.println("przed  " + totalHoursWorked);
			totalHoursWorked += calculator.calculateTotalHoursWorked(wb);
			System.out.println("po  " + totalHoursWorked);
		}

		System.out.println(totalHoursWorked);

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
		// String aaa = Utilities.getExtensionByStringHandling("qqqq.xxxxxx");
		// System.out.println(aaa);

	}
	public static Employee findEmployeeByName(String name) {
		for (Employee employee : employees) {
		if (employee.getName().equals(name)) {
			return employee;
		}
		}
		return null;
	}
}