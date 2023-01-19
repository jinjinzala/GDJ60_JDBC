package com.iu.main.departments;

public class DepartmentDTO {

	//DTO만드는 규칙
	//모든 멤버 변수의 접근 지정자는 private
	//Table의 칼럼의 데이터타입과 컬럼명과 일치 시킴 
	//Getter Setter 생성
	//생성자는 여러개 있어도 상관 x
	//꼭 기본 생성자(디폴트 생성자를 자동으로 만들어줌)는 있어야 함 
	
	//null값이 들어올 가능성이 있기때문에 integer(레퍼런스타입) 사용 
	//변수명의 첫번째는 소문자로 시작하기 때문에 소문자로 작성 (컬럼명은 대소문자 구분 x)
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	

	
}
