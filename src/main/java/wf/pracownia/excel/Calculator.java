package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import wf.pracownia.excel.model.Employee;
import wf.pracownia.excel.model.Employees;
import wf.pracownia.excel.model.calendar.Day;
import wf.pracownia.excel.model.calendar.Month;
import wf.pracownia.excel.model.calendar.Year;

public class Calculator {
	ExcelLoader excelLoader = new ExcelLoader();
	Utilities utilities = new Utilities();

	public boolean calculateDailyWorkWorEachDayforEachEmployee(String path, Employees employees) {
		ArrayList<File> excelFiles = excelLoader.FindAllExcleFiles(path);
		System.out.println("Found " + excelFiles.size() + " excel files");

		if (excelFiles.isEmpty()) {
			return false;
		}

		for (File file : excelFiles) {
			Workbook wb = excelLoader.loadExcelFile(file);
			String currentEmployeeName = utilities.parseNameFromFile(file.getName());

			// zabezpieczneie na wypadek gdyby plik excelowy nie zawieral w nazie danych
			// pracownika
			// w przewidywalnym formacie
			if (currentEmployeeName == null) {
				System.err.println("Skiping incorrect file " + file.getAbsolutePath());
			} else {
				if (employees.findEmployeeByName(currentEmployeeName) == null) {

					employees.addNewEmployee(currentEmployeeName);
				}

				processBodyofExcelFile(employees, file, wb, currentEmployeeName);
			}

		}
		return true;
	}

	private void processBodyofExcelFile(Employees employees, File file, Workbook wb, String currentEmployeeName) {
		for (Sheet sheet : wb) {
			for (Row row : sheet) {
				if (row.getRowNum() != 0) {
					if (row.getCell(2) != null) {
						try {
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

						} catch (IllegalStateException exp) {
							System.err.println("Skiping row with incorrect data in file " + file.getAbsolutePath()
									+ " sheet: " + sheet.getSheetName());
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

	public Map<String, Double> calculateTotalsByMonths(Employees employees) {
		Map<String, Double> resultsByMonth = new HashMap<String, Double>();
		Date date;
		for (Employee employee : employees.getEmployees()) {
			for (Year year : employee.getYearsWhenEmployeeWorked()) {
				for (Month month : year.getMonths()) {
					for (Day day : month.getDays()) {
						date = new Date(year.getCalendarYear(), month.getMonthNumber(), 1);
						if (resultsByMonth.get(convertDateToYearMonthString(date)) == null) {
							resultsByMonth.put(convertDateToYearMonthString(date), (double) 0);
						}
						double hours = resultsByMonth.get(convertDateToYearMonthString(date));
						hours += day.getHoursWorked();
						resultsByMonth.put(convertDateToYearMonthString(date), hours);
					}
				}
			}
		}
		return resultsByMonth;
	}

	public Map<String, Double> calculateTotalsByDay(Employees employees) {
		Map<String, Double> resultsByDay = new HashMap<String, Double>();
		Date date;
		for (Employee employee : employees.getEmployees()) {
			for (Year year : employee.getYearsWhenEmployeeWorked()) {
				for (Month month : year.getMonths()) {
					for (Day day : month.getDays()) {
						date = new Date(year.getCalendarYear(), month.getMonthNumber(), day.getDayNumber());
						if (resultsByDay.get(convertDateToYearMonthDayString(date)) == null) {
							resultsByDay.put(convertDateToYearMonthDayString(date), (double) 0);
						}
						double hours = resultsByDay.get(convertDateToYearMonthDayString(date));
						hours += day.getHoursWorked();
						resultsByDay.put(convertDateToYearMonthDayString(date), hours);
					}
				}
			}
		}

		return resultsByDay;
	}

	private String convertDateToYearMonthString(Date date) {
		int correctedMonth = date.getMonth() + 1;
		return correctedMonth + "-" + date.getYear();
	}

	private String convertDateToYearMonthDayString(Date date) {
		int correctedMonth = date.getMonth() + 1;
		return date.getDate() + "-" + correctedMonth + "-" + date.getYear();
	}
}