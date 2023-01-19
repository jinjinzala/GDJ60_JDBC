package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeesView {
	
	public void view(String msg) {
		System.out.print(msg);
	}
	public void view(EmployeesDTO employeesDTO) {
		System.out.println(employeesDTO.getEmployee_id());
		System.out.println(employeesDTO.getFirst_name());
		System.out.println(employeesDTO.getLast_name());
		System.out.println(employeesDTO.getJob_id());
		System.out.println(employeesDTO.getDepartment_id());
	}
	
	public void view(ArrayList<EmployeesDTO> ar) {
		for(EmployeesDTO employeesDTO : ar) {
			this.view(employeesDTO);
		}
	}
}
