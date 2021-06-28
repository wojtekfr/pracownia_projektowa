package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Calculator {
	ExcelLoader excelLoader = new ExcelLoader();
	Utilities utilities = new Utilities();

	public void calculateDailyWorkWorEachDayforEachEmployee(String path, Employees employees) {
		double totalHoursWorked = 0;
		ArrayList<File> excelFiles = excelLoader.FindAllExcleFiles(path);

		for (File file : excelFiles) {

			Workbook wb = excelLoader.loadExcelFile(file);

			String currentEmployeeName = utilities.parseNameFromFile(file.getName());

			if (employees.findEmployeeByName(currentEmployeeName) == null) {

				employees.addNewEmployee(currentEmployeeName);
				System.out.println("dodałem " + currentEmployeeName);
			}

			for (Sheet sheet : wb) {
				System.out.println(sheet.getSheetName());
				for (Row row : sheet) {
					if (row.getRowNum() != 0) {
						if (row.getCell(2) != null) {
							int year = 1900 + row.getCell(0).getDateCellValue().getYear();
							int month = row.getCell(0).getDateCellValue().getMonth();
							int day = row.getCell(0).getDateCellValue().getDate();
							employees.findEmployeeByName(currentEmployeeName).addNewYearToEmployee(year);
							employees.findEmployeeByName(currentEmployeeName).findYearByCalendarYear(year)
									.addNewMonthToYear(month);
							employees.findEmployeeByName(currentEmployeeName).findYearByCalendarYear(year)
									.findMonthbyCalendarNumber(month).addNewDay(day);
							employees.findEmployeeByName(currentEmployeeName).findYearByCalendarYear(year)
									.findMonthbyCalendarNumber(month).findDaybyCalendarNumber(day)
									.increaseHoursWorked(day, row.getCell(2).getNumericCellValue());
						}

					}

				}

			}
		}
	}

	public Map<String, Double> calculateTotalsByEmployee(Employees employees) {
		Map<String, Double> resultsByEmployee = new HashMap<String, Double>();
		String name = null;
		double totalHoursWorkedbyEmployee = 0;
		for (Employee employee : employees.getEmployees()) {
			name = employee.getName();
			for (Year year : employee.getYearsWhenEmployeeWorked()) {
				for (Month month : year.getMonths()) {
					for (Day day : month.getDays()) {
						totalHoursWorkedbyEmployee += day.getHoursWorked();
					}
				}
			}
			resultsByEmployee.put(name, totalHoursWorkedbyEmployee);
			name = null;
			totalHoursWorkedbyEmployee = 0;
		}

		return resultsByEmployee;
	}

	public Map<Date, Double> calculateTotalsByMonths(Employees employees) {
		Map<Date, Double> resultsByMonth = new HashMap<Date, Double>();
		Date date;
		for (Employee employee : employees.getEmployees()) {
			for (Year year : employee.getYearsWhenEmployeeWorked()) {
				for (Month month : year.getMonths()) {
					for (Day day : month.getDays()) {
						date = new Date(year.getCalendarYear(), month.getMonthNumber(), 1);
						if (resultsByMonth.get(date) == null) {
							resultsByMonth.put(date, (double) 0);
						}
						double hours = resultsByMonth.get(date);
						hours += day.getHoursWorked();
						resultsByMonth.put(date, hours);
					}
				}
			}
		}

		return resultsByMonth;
	}

}