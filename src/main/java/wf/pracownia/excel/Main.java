package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.Options;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {



	public static void main(String[] args) {
		System.out.println("main");
		
		
		
		Calculator calculator = new Calculator();
		Employees employees = new Employees();
		
		
		String path = "src/main/resources/";
		calculator.calculateDailyWorkWorEachDayforEachEmployee(path, employees);
		System.out.println("--");
		Map<String, Double> resultsByEmployee = calculator.calculateTotalsByEmployee(employees);
		System.out.println(resultsByEmployee);
		calculator.calculateTotalsByMonths(employees);
		Map<Date, Double> resultsByMonth = calculator.calculateTotalsByMonths(employees);
		System.out.println(resultsByMonth);
		
//	employees.addNewEmployee("Janusz");
//	employees.findEmployeeByName("Janusz").addNewYearToEmployee(2012);
//		
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2012).addNewMonthToYear(0);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2012).getMonth(0).addNewDay(0);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2012).getMonth(0).findDaybyCalendarNumber(0).increaseHoursWorked(0, 10);
//	
//	employees.findEmployeeByName("Janusz").addNewYearToEmployee(2012);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2012).addNewMonthToYear(0);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2012).getMonth(0).addNewDay(0);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2012).getMonth(0).findDaybyCalendarNumber(0).increaseHoursWorked(0, 10);
//	
//	employees.findEmployeeByName("Janusz").addNewYearToEmployee(2013);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2013).addNewMonthToYear(0);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2013).getMonth(0).addNewDay(0);
//	employees.findEmployeeByName("Janusz").findYearByCalendarYear(2013).getMonth(0).findDaybyCalendarNumber(0).increaseHoursWorked(0, 10);
//	
//	employees.addNewEmployee("Grazyna");
//	employees.findEmployeeByName("Grazyna").addNewYearToEmployee(2012);
//	employees.findEmployeeByName("Grazyna").findYearByCalendarYear(2012).addNewMonthToYear(0);
//	employees.findEmployeeByName("Grazyna").findYearByCalendarYear(2012).getMonth(0).addNewDay(0);
//	employees.findEmployeeByName("Grazyna").findYearByCalendarYear(2012).getMonth(0).findDaybyCalendarNumber(0).increaseHoursWorked(0, 10);
//
//	

		for (Employee employee : employees.getEmployees()) {
			System.out.println(employee.getName());
			for (Year year : employee.getYearsWhenEmployeeWorked()) {
				System.out.println("Rok " + year.getCalendarYear());
				for (Month month : year.getMonths()) {
				 System.out.println("Miesiąc " + month.getMonthNumber());
				 int counter = 0;
				 for (Day day : month.getDays()) {
					System.out.println("dzień : " + day.getDayNumber() + " : " + day.getHoursWorked());
					counter++;
				}
			}
	
		}



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
}

