package wf.pracownia.excel;

import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Utilities {

	public String parseNameFromFile(String fileName) {
		String[] fileNameFirstSplit = fileName.split("_");

		String[] fileNameSecondSplit;
		if (fileNameFirstSplit.length == 2) {
			fileNameSecondSplit = fileNameFirstSplit[1].split("\\.");
		} else {
			return null;
		}

		String employeeName = fileNameFirstSplit[0] + " " + fileNameSecondSplit[0];
		return employeeName;

	}

	public String askForPath() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter path contaning files for processing");
		return scanner.nextLine();
	}

	public String getPathFromCommandLine (String[] args) {


		String pathFromCommandLine = null;
		Options options = new Options();
		Option filename = OptionBuilder.withArgName("file").hasArg().withDescription("file for processing")
				.create("filename");
		options.addOption(filename);
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine line = parser.parse(options, args);
			if (line.hasOption("filename")) {
				if (line.getOptionValue("filename").endsWith("\\")) {
				System.out.println("!!!");
				}
						
				pathFromCommandLine = line.getOptionValue("filename");
			}
		} catch (ParseException exp) {

			System.err.println("Parsing command line parameters failed.  Reason: " + exp.getMessage());
		}

		return pathFromCommandLine;
	}
	
}
