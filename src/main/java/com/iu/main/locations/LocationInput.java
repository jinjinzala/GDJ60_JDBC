package com.iu.main.locations;

import java.util.Scanner;



public class LocationInput {
	  Scanner sc = new Scanner(System.in);	
	  public LocationInput() {
      sc = new Scanner(System.in);
	  }
		
		//삭제하는 메서드 생성 
		public LocationDTO deleteData() {
	     LocationDTO locationDTO = new LocationDTO();
		 System.out.println("삭제할 부서를 입력해주세요");
	     locationDTO.setLocation_id(sc.nextInt());
		 return locationDTO;
		}
		
		//입력하는 메서드 생성 
		public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();	
		System.out.println("부서명 입력 ");	
		locationDTO.setLocation_id(sc.nextInt());
		System.out.println("주소를 입력해주세요");
		locationDTO.setStreet_address(sc.next());
		System.out.println("지역 번호 입력 ");
		locationDTO.setCity(sc.next());
		System.out.println("도시 아이디를 알려주세요");
		locationDTO.setCountry_id(sc.next());
		
		return locationDTO;
		
}
		//업데이트 메서드 
		public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("수정할 LOCATION_ID 입력");
		locationDTO.setLocation_id(sc.nextInt());
		System.out.println("수정할 STREET_ADDRESS 입력");
		locationDTO.setStreet_address(sc.next());
		System.out.println("수정할 POSTAL_CODE 입력");
		locationDTO.setPostal_code(sc.next());
		System.out.println("수정할 CITY 입력");	
		locationDTO.setCity(sc.next());
		System.out.println("수정할 STATE_PROVINCE 입력");
		locationDTO.setState_province(sc.next());
		System.out.println("수정할 COUNTRY_ID 입력");
		locationDTO.setCountry_id(sc.next());
		
		return locationDTO;
		
		}
		
		
		}
