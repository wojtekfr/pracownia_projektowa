package wf.pracownia.excel;

// na podstawie https://www.javatpoint.com/how-to-sort-hashmap-by-value
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByValue {
	// implementation of HashMap
	Map<String, Double> map = new HashMap<String, Double>();

	public SortByValue(Map<String, Double> map) {
		super();
		this.map = map;
	}

	public Map<String, Double > sort() {
		this.map = map;
		System.out.println("zrodlowa " + map);
		System.out.println("docelowa " + this.map);
		SortByValue sv = new SortByValue(map);

		Map<String, Double>sortedMap = sv.sortByValue(false);
		return sortedMap;
	}
	// method to add elements in the HashMap

	Map<String, Double> sortByValue(boolean order) {

		// convert HashMap into List
		List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(map.entrySet());
		// sorting the list elements
		Collections.sort(list, new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				if (order) {
					// compare two object and return an double
					return o1.getValue().compareTo(o2.getValue());
				} else {
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		// prints the sorted HashMap
		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		for (Entry<String, Double> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	// method for printing the elements
	public void printMap(Map<String, Double> map) {
		System.out.println("Company\t Price ");
		for (Entry<String, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		System.out.println("\n");
	}
}
