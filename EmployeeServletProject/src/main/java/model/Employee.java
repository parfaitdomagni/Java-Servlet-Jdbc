package model;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String loginId;
	private String password;
	public Employee() {}
	public Employee(int id, String name, double salary, String loginId, String password) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.loginId = loginId;
		this.password =password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) { 
	this.name = name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", loginId=" + loginId + ", password="
				+ password + "]";
	}
	
	
	

}
