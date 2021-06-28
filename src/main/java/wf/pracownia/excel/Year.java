package wf.pracownia.excel;

public class Year {

	private int calendarYear;
	private double[] hoursWorkedInGivenMonth = new double[12];

	public double[] getHoursWorkedInGivenMonth() {
		return hoursWorkedInGivenMonth;
	}

	public int getCalendarYear() {
		return calendarYear;
	}

	public Year(int year) {
		super();
		this.calendarYear = year;
	}

	public double getHoursWorkedInGivenMonth(int month) {
		return hoursWorkedInGivenMonth[month];
	}

	public void setHoursWorkedInGivenMonth(double[] hoursWorkedInGivenMonth) {
		this.hoursWorkedInGivenMonth = hoursWorkedInGivenMonth;
	}

	public void increaseHoursWorkedInMonth(int month, double hoursWorkedInGivenMonth) {
		this.hoursWorkedInGivenMonth[month] += hoursWorkedInGivenMonth;
	}

}
