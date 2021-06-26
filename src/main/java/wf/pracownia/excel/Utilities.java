package wf.pracownia.excel;

import java.util.Optional;

import org.apache.commons.io.FilenameUtils;

public class Utilities {



	public static String getExtension(String filename) {
	    return FilenameUtils.getExtension(filename);
	}
}
