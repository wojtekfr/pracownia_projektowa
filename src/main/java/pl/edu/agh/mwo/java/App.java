package pl.edu.agh.mwo.java;

import org.apache.poi.ss.usermodel.Workbook;

public class App {
    /// test
	public static void main(String[] args) {

        System.out.println("Hello World!");

        Workbook f1Wb = WorkbookLoader.openF1Workbook();

        PoiDemo.printSheetNames(f1Wb);
        PoiDemo.printCellsFromSheet(f1Wb.getSheetAt(0));
        PoiDemo.computePointsForARace(f1Wb.getSheetAt(0));

        Workbook sudokuWb = WorkbookLoader.openSudokuWorkbook();

        PoiDemo.computeAllNumberInAGivenColumn(sudokuWb.getSheetAt(0), 0);

    }
}
