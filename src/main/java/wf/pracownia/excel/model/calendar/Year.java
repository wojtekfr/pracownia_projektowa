package wf.pracownia.excel.model.calendar;

import java.util.ArrayList;

public class Year {

	private int calendarYear;
	
	ArrayList<Month> months = new ArrayList<Month>();
	
	public ArrayList<Month> getMonths() {
		return months;
	}

	
	
	public Month getMonth(int monthNumber) {
		return months.get(monthNumber);
	}
	
	public Month findMonthbyCalendarNumber(int monthCalendarNumber) {
		for (Month month: months) {
			if (month.getMonthNumber() == monthCalendarNumber) return month; 
					}
		
		return null;
	}
	
	public void addNewMonthToYear(int monthNumber) {

		if (findMonthbyCalendarNumber(monthNumber) == null) {
		months.add(new Month(monthNumber));
		}
		else {
		}
	}
	
//	public double[] getHoursWorkedInGivenMonth() {
//		return months;
//	}

	public int getCalendarYear() {
		return calendarYear;
	}

	public Year(int year) {
		super();
		this.calendarYear = year;
	}

//	public double getHoursWorkedInGivenMonth(int month) {
//		return months[month];
//	}

//	public void setHoursWorkedInGivenMonth(double[] hoursWorkedInGivenMonth) {
//		this.months = hoursWorkedInGivenMonth;
//	}
//
//	public void increaseHoursWorkedInMonth(int month, double hoursWorkedInGivenMonth) {
//		this.months[month] += hoursWorkedInGivenMonth;
//	}

}
