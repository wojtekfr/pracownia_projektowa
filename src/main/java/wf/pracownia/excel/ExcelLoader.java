package wf.pracownia.excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLoader {

	   public Workbook loadExcelFile(String file) {
	        try {
	            return WorkbookFactory.create(new File(file));
	        } catch (EncryptedDocumentException | IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	
}
