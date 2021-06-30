package wf.pracownia.excel;

import java.util.Map;

public class Printer {

	public void printResults(Map<String, Double> map, String title, boolean shoudLimitToTen) {
		System.out.println(title);
		int counter = 0;
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			counter++;
			if (shoudLimitToTen) {
				if (counter == 10)
					break;
			}
		}
		System.out.println();
	}

}
