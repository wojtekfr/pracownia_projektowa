package wf.pracownia.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Calculator {

	public int calculateHoursWorked(Workbook workbook) {
		for (Sheet sheet: workbook) {
			System.out.println(sheet.getSheetName());
		}
		return 0;
		
	}
	
}
