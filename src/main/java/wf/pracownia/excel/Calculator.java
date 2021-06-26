package wf.pracownia.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Calculator {

	public int calculateHoursWorked(Workbook workbook) {
		int hoursWorked =0;
		for (Sheet sheet: workbook) {
			System.out.println(sheet.getSheetName());
			for (Row row: sheet) {
				if (row.getRowNum()!=0) {
					if (row.getCell(2) != null) {
						hoursWorked += row.getCell(2).getNumericCellValue();
					}
					
					}
			}
		}
		return hoursWorked;
		
	}
	
}
