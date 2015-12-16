package com.emp.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.Empl.vo.Employee;
import com.Empl.vo.User;

public interface DaoI {

	List<Employee> getEmployee();
	Employee getEmployee(int pid);
	Set<String> getDept();
	int addEmployee(Employee empl);
	User getLogin(int id,String pass);
	int markInOut(Date d,int id,int mo);
	List getAttendace(int id);
	List projectList(int id);
	int insertProject(int id,int proje);
}
