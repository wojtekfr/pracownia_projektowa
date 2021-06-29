package wf.pracownia.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLoader {

	ArrayList<File> AllExcelFiles = new ArrayList<File>();
	
	   public Workbook loadExcelFile(File file) {
	        try {
	            return WorkbookFactory.create(file);
	        } catch (EncryptedDocumentException | IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }


	   public Workbook loadExcelFile(String file) {
	        try {
	            return WorkbookFactory.create(new File(file));
	        } catch (EncryptedDocumentException | IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	   
public ArrayList<File> FindAllExcleFiles(String path){

File folder = new File(path);


if (folder.listFiles() != null) {
	for (File file: folder.listFiles()) {
		if (!file.isDirectory()) {
			
			if (file.getName().endsWith(".xlsx") || file.getName().endsWith(".xls")) {
	
				AllExcelFiles.add(file);
				
			}
		} else 
		{
			FindAllExcleFiles(file.toString());
		}
	}

}
	return AllExcelFiles;



}
}