package com.iu.main.departments;

import java.util.Scanner;

public class DepartmentInput {
	private Scanner sc;
	//추가할때 받아야하는 메서드
	public DepartmentInput(){
	sc = new Scanner(System.in);
	}
	
	public DepartmentDTO updateData() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("수정할 부서 번호 입력");
	    departmentDTO.setDepartment_id(sc.nextInt());
	    System.out.println("수정할 부서명 입력");
	    departmentDTO.setDepartment_name(sc.next());
	   //매니저 번호 지역번호
	    
	    return departmentDTO;
	    
	}
	
	
	public DepartmentDTO setData() {
	DepartmentDTO departmentDTO = new DepartmentDTO();	
	System.out.println("부서명 입력 ");	
	departmentDTO.setDepartment_name(sc.next());
	System.out.println("매니저 번호 입력 ");
	departmentDTO.setManager_id(sc.nextInt());
	System.out.println("지역 번호 입력 ");
	departmentDTO.setLocation_id(sc.nextInt());
	
	return departmentDTO;
	
	}	
	
	//삭제할때 받아야하는 메서드 
	
	public DepartmentDTO deleteData() {
		DepartmentDTO departmentDTO =new DepartmentDTO();
		System.out.println("삭제할 부서 번호 입력");
		departmentDTO.setDepartment_id(sc.nextInt());
		return departmentDTO;
	}
	
	
	
}
