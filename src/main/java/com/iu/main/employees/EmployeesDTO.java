package com.iu.main.employees;

import java.sql.Date;

public class EmployeesDTO {
    //DTO만드는 규칙
	//모든 멤버 변수의 접근 지정자는 private
	//Table의 칼럼의 데이터타입과 컬럼명과 일치 시킴 
	//Getter Setter 생성
	//생성자는 여러개 있어도 상관 x
	//꼭 기본 생성자(디폴트 생성자를 자동으로 만들어줌)는 있어야 함 
	
	//null값이 들어올 가능성이 있기때문에 integer(레퍼런스타입) 사용 
	//변수명의 첫번째는 소문자로 시작하기 때문에 소문자로 작성 (컬럼명은 대소문자 구분 x)
	
	//사원정보리스트 
	
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String salary;
	//commission_pct는 double로 선언하는게 좋다.
	private Integer commission_pct;
	private Integer manager_id;
	private Integer department_id;
	private String job_id;
	
	
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Integer getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(Integer commission_pct) {
		this.commission_pct = commission_pct;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	
}
