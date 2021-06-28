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
						hoursWorked += row.getCell(2).getNumericCellValue();
					}

				}
			}
		}
		return hoursWorked;

	}

	public double calculateTotalWork(String path, Employees employees) {
		double totalHoursWorked = 0;
		ArrayList<File> excelFiles = excelLoader.FindAllExcleFiles(path);

		for (File file : excelFiles) {

			Workbook wb = excelLoader.loadExcelFile(file);
			System.out.println(file.getName());
			String currentEmployeeName = utilities.parseNameFromFile(file.getName());

			if (employees.findEmployeeByName(currentEmployeeName) == null) {
				
				employees.addNewEmployee(currentEmployeeName);
				System.out.println(currentEmployeeName);
				System.out.println(employees.getEmployees().size());
			}
	
			// System.out.println("przed " + totalHoursWorked);
			totalHoursWorked += calculateHoursWorked(wb);

			System.out.println("po  " + totalHoursWorked);
		}

		System.out.println(totalHoursWorked);

		return 0;
	}
}