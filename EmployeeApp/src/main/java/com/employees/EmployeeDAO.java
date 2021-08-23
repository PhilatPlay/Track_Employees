package com.employees;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface   EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    void deleteEmployee(int id) throws SQLException;
	List<Employee> getEmployees(List<Employee> employees)throws SQLException;
	void updateEmployee(int id);
}