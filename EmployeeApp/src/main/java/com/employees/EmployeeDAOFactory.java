package com.employees;

public class EmployeeDAOFactory {
	 private static EmployeeDAO dao;

	    private EmployeeDAOFactory(){}

	    public static EmployeeDAO getEmployeeDao() throws ClassNotFoundException {
	        if(dao==null)
	            dao = new EmployeeDAOImpl();
	        return dao;
	    }
}
