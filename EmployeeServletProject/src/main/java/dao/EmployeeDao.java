package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDao {
	//method to search employee base on longin and password

	public Employee getEmployee(String loginId, String password) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = myConnection.getConnection();
			pst = con.prepareStatement("select * from Employee where loginId = ? and password=? ");
			pst.setString(1, loginId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				//Transfering Data from resulset to Java
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5));
				return employee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		con = myConnection.getConnection();
		return null;
		//jdbc
	}

	//code to register employee information in db
	public int register(Employee employee) {
		Connection con = null;
		PreparedStatement pst = null;

		con = myConnection.getConnection();
		try {
			pst = con.prepareStatement("insert into employee values(?,?,?,?,?)");
			pst.setInt(1, employee.getId());
			pst.setString(2, employee.getName());
			pst.setDouble(3, employee.getSalary());
			pst.setString(4, employee.getLoginId());
			pst.setString(5, employee.getPassword());
			int x = pst.executeUpdate();
			return x;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public List<Employee> getAllEmployee() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = myConnection.getConnection();
		List<Employee> empList = new ArrayList<Employee>();
		try {
		 pst = con.prepareStatement("Select * from employee");
		 rs = pst.executeQuery();
		 while(rs.next()) {
			 Employee employee = new Employee();
			 employee.setId(rs.getInt(1));
			 employee.setName(rs.getString(2));
			 employee.setSalary(rs.getDouble(3));
			 employee.setLoginId(rs.getString(4));
			 employee.setPassword(rs.getString(5));
			 empList.add(employee);
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;

	}

	//fetch employee by id
	public Employee getEmployee(int empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con = myConnection.getConnection();

		try {
			pst = con.prepareStatement("select * from employee where empId = ?");
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			if(rs.next()) {
				//transfer data from resultset to java
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setLoginId(rs.getString(4));
				employee.setPassword(rs.getString(5));
				return employee;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
