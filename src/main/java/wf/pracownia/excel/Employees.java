package wf.pracownia.excel;

import java.util.ArrayList;

public class Employees {

	private static ArrayList<Employee> employees = new ArrayList<Employee>();

	
	public  ArrayList<Employee> getEmployees() {
		return employees;
	}


	public Employee getEmployeeByOrderId(int orderId) {
		return employees.get(orderId);
	}
	
	public  Employee findEmployeeByName(String name) {
		for (Employee employee : employees) {
		if (employee.getName().equals(name)) {
			return employee;
		}
		}
		return null;
	}
	
	public boolean checkIfEmployeeAlreadyExists (String name) {
		if (findEmployeeByName(name)!= null) return true;
		else return false;
	}

	public void addNewEmployee(String name) {
		employees.add(new Employee(name));
		
		
	}
}
