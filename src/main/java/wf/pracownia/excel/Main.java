package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.cli.Options;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {



	public static void main(String[] args) {
		System.out.println("main");
		
		Calculator calculator = new Calculator();
		Employees employees = new Employees();
		String path = "src/main/resources/";
		calculator.calculateTotalWork(path, employees);
		System.out.println("--");

//		employees.addNewEmployee("Janusz");
//		employees.findEmployeeByName("Janusz").addNewYearToEmployee(2012);
//		
//		employees.findEmployeeByName("Janusz").findYearByCalendarDate(2012).increaseHoursWorkedInMonth(1, 66);
//		employees.findEmployeeByName("Janusz").findYearByCalendarDate(2012).increaseHoursWorkedInMonth(1, 33);
//
//		employees.getEmployeeByOrderId(0).addNewYearToEmployee(2013);
//		employees.getEmployeeByOrderId(0).getYearByOrder(1).increaseHoursWorkedInMonth(0, 10);
//		employees.getEmployeeByOrderId(0).getYearByOrder(1).increaseHoursWorkedInMonth(1, 13);
//
//		employees.addNewEmployee("Grazyna");
//		employees.getEmployeeByOrderId(1).addNewYearToEmployee(2012);
//		employees.getEmployeeByOrderId(1).getYearByOrder(0).increaseHoursWorkedInMonth(1, 333);
//		employees.getEmployeeByOrderId(1).addNewYearToEmployee(2020);
//		employees.getEmployeeByOrderId(1).getYearByOrder(1).increaseHoursWorkedInMonth(3, 666);
//		
//		employees.findEmployeeByName("Janusz").getYearByOrder(0).increaseHoursWorkedInMonth(0, 13);
//		
//		employees.findEmployeeByName("Janusz").findYearByCalendarDate(2012).increaseHoursWorkedInMonth(0, 7);

		for (Employee employee : employees.getEmployees()) {
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

}