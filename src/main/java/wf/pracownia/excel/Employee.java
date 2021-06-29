package wf.pracownia.excel;

import java.util.ArrayList;

import wf.pracownia.excel.model.Year;

public class Employee {
	private ArrayList<Year> yearsWhenEmployeeWorked = new ArrayList<Year>();
	private String name;

		
	
	public ArrayList<Year> getYearsWhenEmployeeWorked() {
		return yearsWhenEmployeeWorked;
	}

	public String getName() {
		return name;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public void addNewYearToEmployee(int year) {
	if (findYearByCalendarYear(year)==null) {
		yearsWhenEmployeeWorked.add(new Year(year));
	}
	}

	
	
//	public void addHoursWorkedtoMonth(int year, float hours) {
//		Year currentYear = yearsWhenEmployeeWorked.get(year);
//
//	}

	public Year getYearByOrder(int yearNumber) {
		return yearsWhenEmployeeWorked.get(yearNumber);
	}

	
		
	
	
	public Year findYearByCalendarYear(int calendarYear) {
		for (Year year : yearsWhenEmployeeWorked) {
			if (year.getCalendarYear() == calendarYear) {
				return year;
			}
		}
		return null;
	}

}
