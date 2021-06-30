package wf.pracownia.excel.model.calendar;

public class Day {

	int dayNumber;
	double hoursWorked;

	public int getDayNumber() {
		return dayNumber;
	}

	public Day(int dayNumber) {
		super();
		this.dayNumber = dayNumber;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void increaseHoursWorked(int dayNumber, double hoursToAdd) {
		hoursWorked += hoursToAdd;
	}
}
