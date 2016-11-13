package edu.jiangxin.webservice.employeemanager;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerImpl implements EmployeeManager {
	private List<Employee> employees = new ArrayList<Employee>();

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public List<Employee> query() {
		return employees;
	}

}
