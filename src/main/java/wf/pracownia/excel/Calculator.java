package wf.pracownia.excel;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Calculator {
	ExcelLoader excelLoader = new ExcelLoader();
	Utilities utilities = new Utilities();

	public double calculateHoursWorked(Workbook workbook) {
		double hoursWorked = 0;
		for (Sheet sheet : workbook) {
			System.out.println(sheet.getSheetName());
			for (Row row : sheet) {
				if (row.getRowNum() != 0) {
					if (row.getCell(2) != null) {
						System.out.println(row.getCell(0).getDateCellValue());
						hoursWorked += row.getCell(2).getNumericCellValue();
					}

				}
			}
		}
		return hoursWorked;

	}

	public void calculateTotalWork(String path, Employees employees) {
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
							System.out.println(row.getCell(0));
							System.out.println(row.getCell(0).getDateCellValue());
							System.out.println("dzien " + row.getCell(0).getDateCellValue().getDate());
							int year = 1900 + row.getCell(0).getDateCellValue().getYear();		
							int month = row.getCell(0).getDateCellValue().getMonth();	
							int day = row.getCell(0).getDateCellValue().getDate();
							System.out.println(year);
							System.out.println(month);
							System.out.println(day);
							employees.findEmployeeByName(currentEmployeeName).addNewYearToEmployee(year);						
							employees.findEmployeeByName(currentEmployeeName).findYearByCalendarYear(year).addNewMonthToYear(month);
							employees.findEmployeeByName(currentEmployeeName).findYearByCalendarYear(year).findMonthbyCalendarNumber(month)
							.addNewDay(day);
							System.out.println("dodaje dzien " + day + "miesiac " + month  );
							employees.findEmployeeByName(currentEmployeeName).findYearByCalendarYear(year).findMonthbyCalendarNumber(month)
							.findDaybyCalendarNumber(day).increaseHoursWorked(day, row.getCell(2).getNumericCellValue() );
						}

					}

				}

			
			}
		}
	}
}