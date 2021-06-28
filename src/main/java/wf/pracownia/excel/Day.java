package wf.pracownia.excel;

public class Day {

	public int getDayNumber() {
		return dayNumber;
	}

	int dayNumber;
	public Day(int dayNumber) {
		super();
		this.dayNumber = dayNumber;
	}
	
	double hoursWorked;
	public double getHoursWorked() {
		return hoursWorked;
	}

	public void increaseHoursWorked(int dayNumber, double hoursToAdd) {
		hoursWorked += hoursToAdd;
	}
}
