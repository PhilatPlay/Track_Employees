package com.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static Statement statement = null;
    Connection connection = null;

    public EmployeeDAOImpl() throws ClassNotFoundException  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
	@Override
   public void addEmployee(Employee employee) throws SQLException {
		
        String sql = "insert into employee (name, email, gender, country) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getGender());
        preparedStatement.setString(4, employee.getCountry());
        
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Employee added");
        else
            System.out.println("Oops! something went wrong");
    }
	
	
	@Override
	public List<Employee> getEmployees(List<Employee> employees) throws SQLException {
		String sql = "select* from employees";
		statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())	{
			employees.add(new Employee(result.getInt(1), 
					result.getString(2), 
					result.getString(3), 
					result.getString(4), 
					result.getString(5)
					));
		}
					return employees;
	}
	

	@Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("employee fired!");
        else
            System.out.println("Oops! something went wrong");
    }


	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		String sql ="update employee set name = ?, email= ?, gender= ?, country= ? where id= ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getEmail());
		preparedStatement.setString(3, employee.getGender());
		preparedStatement.setString(4, employee.getCountry());
		preparedStatement.setInt(5, employee.getId());
		preparedStatement.executeUpdate();
		
		
		
	}


	}
