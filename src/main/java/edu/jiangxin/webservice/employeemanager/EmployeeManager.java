package edu.jiangxin.webservice.employeemanager;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
@WebService(serviceName="EmployeeService", targetNamespace="employeemanager.webservice.jiangxin.edu")
public interface EmployeeManager {

	public abstract void add(@WebParam(name="employee")Employee employee);

	public abstract @WebResult(name="employees")List<Employee> query();

}