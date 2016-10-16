package edu.jiangxin.webservice.employeemanager;

import java.util.ArrayList;
import java.util.List;

/**员工管理的业务实现类
 * @author 李俊  2015年5月17日
 */
public class EmployeeManagerImpl implements EmployeeManager {
	private List<Employee> employees=new ArrayList<>();
	@Override
	public void add(Employee employee){
		//添加到集合中
		employees.add(employee);
	}
	@Override
	public List<Employee> query(){
		return employees;
	}

}
