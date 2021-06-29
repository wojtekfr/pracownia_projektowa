package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;

import wf.pracownia.excel.model.Day;
import wf.pracownia.excel.model.Month;
import wf.pracownia.excel.model.Year;

public class Main {

	public static void main(String[] args) throws ParseException {

		System.out.println("main");
		

		
// procesowanie lini komend. Pewnie nie powinno być całew main, ale jesli umieszczłem je gdzie indziej  sypał błedami o braku zmiennej args
		String pathFromCommandLine = null;
		Options options = new Options();
		Option filename = OptionBuilder.withArgName("file").hasArg().withDescription("file for processing")
				.create("filename");
		options.addOption(filename);
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine line = parser.parse(options, args);
			if (line.hasOption("filename")) {
				pathFromCommandLine = line.getOptionValue("filename");
			}
		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}
	
		
		
		
		Calculator calculator = new Calculator();
		Employees employees = new Employees();
		Utilities utils = new Utilities();
		
		
		String path;
		if (pathFromCommandLine!= null) {
			path = pathFromCommandLine;}
		else {
			path = "src\\main\\resources";
			//path = utils.askForPath();
		}
		
		calculator.calculateDailyWorkWorEachDayforEachEmployee(path, employees);
		System.out.println("--");
		Map<String, Double> resultsByEmployee = calculator.calculateTotalsByEmployee(employees);
		System.out.println(resultsByEmployee);
		calculator.calculateTotalsByMonths(employees);
		Map<String, Double> resultsByMonth = calculator.calculateTotalsByMonths(employees);
		System.out.println(resultsByMonth);
		Map<String, Double> resultsByDay = calculator.calculateTotalsByDay(employees);
		System.out.println(resultsByDay);

		SortByValue sv = new SortByValue(resultsByEmployee);
		System.out.println("posortowane " + sv.sort());	
		SortByValue sv2 = new SortByValue(resultsByMonth);
		System.out.println("posortowane " + sv2.sort());	
		SortByValue sv3 = new SortByValue(resultsByDay);
		System.out.println("posortowane " + sv3.sort());
		
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

//		for (Employee employee : employees.getEmployees()) {
//			System.out.println(employee.getName());
//			for (Year year : employee.getYearsWhenEmployeeWorked()) {
//				System.out.println("Rok " + year.getCalendarYear());
//				for (Month month : year.getMonths()) {
//					System.out.println("Miesiąc " + month.getMonthNumber());
//					int counter = 0;
//					for (Day day : month.getDays()) {
//						System.out.println("dzień : " + day.getDayNumber() + " : " + day.getHoursWorked());
//						counter++;
//					}
//				}
//
//			}

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
