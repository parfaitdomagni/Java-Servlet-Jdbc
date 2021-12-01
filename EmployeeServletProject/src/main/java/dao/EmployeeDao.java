package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public void register(Employee employee) {
		Connection con = null;
		PreparedStatement pst = null;
		
		con = myConnection.getConnection();
		try {
			pst = con.prepareStatement("insert into employee values(?,?,?,?,?)");
			pst.setInt(1, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAllEmployee() {
		
	}
	
	//fetch employee by id
	public Employee getEmployee(int empId) {
		return null;
	}

}
