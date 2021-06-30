package wf.pracownia.excel;

import java.util.Map;

public class Printer {

	public void printResults(Map<String,Double> map, String title) {
		System.out.println(title);
		for (Map.Entry<String, Double> entry :map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
}
