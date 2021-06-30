package wf.pracownia.excel.model.calendar;

import java.util.ArrayList;

public class Month {

	private ArrayList<Day> days = new ArrayList<Day>();
	private int monthNumber;

	public ArrayList<Day> getDays() {
		return days;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public Month(int monthNumber) {
		super();
		this.monthNumber = monthNumber;
	}

	public void addNewDay(int dayNumber) {

		if (findDaybyCalendarNumber(dayNumber) == null) {
			days.add(new Day(dayNumber));
		}
	}

	public Day findDaybyCalendarNumber(int dayNumber) {
		for (Day day : days) {
			if (day.getDayNumber() == dayNumber)
				return day;
		}
		return null;
	}
}
