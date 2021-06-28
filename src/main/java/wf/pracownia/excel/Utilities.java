package wf.pracownia.excel;

import java.io.File;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;

public class Utilities {



	public static String getExtension(String filename) {
	    return FilenameUtils.getExtension(filename);
	}
	
	public String parseNameFromFile(String fileName) {

		String[] fileNameFirstSplit = fileName.split("_");
		String[] fileNameSecondSplit = fileNameFirstSplit[1].split("\\.");
		
		String employeeName = fileNameFirstSplit[0] + " " + fileNameSecondSplit[0];
		return employeeName;
		
	}
	
}
