package com.iu.main.locations;

public class LocationDTO {
	    //DTO만드는 규칙
		//모든 멤버 변수의 접근 지정자는 private
		//Table의 칼럼의 데이터타입과 컬럼명과 일치 시킴 
		//Getter Setter 생성
		//생성자는 여러개 있어도 상관 x
		//꼭 기본 생성자(디폴트 생성자를 자동으로 만들어줌)는 있어야 함 
		
		//null값이 들어올 가능성이 있기때문에 integer(레퍼런스타입) 사용 
		//변수명의 첫번째는 소문자로 시작하기 때문에 소문자로 작성 (컬럼명은 대소문자 구분 x)
    
	private Integer location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private String state_province;
	private String country_id;
	
	
	
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	




}
