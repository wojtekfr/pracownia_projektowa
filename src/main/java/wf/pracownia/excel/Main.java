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

import wf.pracownia.excel.model.Employees;
import wf.pracownia.excel.model.calendar.Day;
import wf.pracownia.excel.model.calendar.Month;
import wf.pracownia.excel.model.calendar.Year;

public class Main {

	public static void main(String[] args) throws ParseException {
// procesowanie lini komend. Pewnie nie powinno być całe w main, ale jesli umieszczłem je gdzie indziej  sypał błedami o braku zmiennej args


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

			System.err.println("Parsing command line parameters failed.  Reason: " + exp.getMessage());
		}

		Calculator calculator = new Calculator();
		Employees employees = new Employees();
		Printer printer = new Printer();
		ExcelLoader excelLoader = new ExcelLoader();
		Utilities utilities = new Utilities();

		String path;
		if (pathFromCommandLine != null) {
			path = pathFromCommandLine;

		} else {
			path = utilities.askForPath();
		}

		if (!excelLoader.isPathCorrect(path)) {
			System.out.println("Provided path is not correct");
			return;
		}

		boolean doesFolderContainExcelFiles = calculator.calculateDailyWorkWorEachDayforEachEmployee(path, employees);
		if (!doesFolderContainExcelFiles) {
			System.out.println("No excel files found in provided path");
			return;
		}

		Map<String, Double> resultsByEmployee = calculator.calculateTotalsByEmployee(employees);
		Map<String, Double> resultsByMonth = calculator.calculateTotalsByMonths(employees);
		Map<String, Double> resultsByDay = calculator.calculateTotalsByDay(employees);

		Sorter sorterByEmployee = new Sorter(resultsByEmployee);
		Sorter sorterByMonth = new Sorter(resultsByMonth);
		Sorter sorterByDay = new Sorter(resultsByDay);

		printer.printResults(sorterByEmployee.sort(), "Ranking of employees by most hard working", false);
		printer.printResults(sorterByMonth.sort(), "Ranking of months by most hard working", false);
		printer.printResults(sorterByDay.sort(), "Ranking of days by 10 most hard working", true);
		
	
	}
}
