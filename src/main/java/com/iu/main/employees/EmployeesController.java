package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {

	private Scanner sc;
	private EmployeesDAO employeesDAO;
	private EmployeesView employeesView;
	public EmployeesController() {
		this.sc = new Scanner(System.in);
	    this.employeesDAO = new EmployeesDAO();
	    this.employeesView = new EmployeesView();
	}
	public void start() throws Exception{
		boolean check = true;
		
		while(check) {
			System.out.println("1.사원 전체 리스트");
			System.out.println("2.사원 번호로 검색 ");
			System.out.println("3.이름으로 검색");
			System.out.println("4.종      료");
		//입력한 번호의 값을 받아오는 함수 	
			int select = sc.nextInt();
			switch(select){
			case 1:
				ArrayList<EmployeesDTO> ar = employeesDAO.getList();
				employeesView.view(ar);
			
				break;
		case 2:
			System.out.println("검색할 사원번호를 입력해주세요");
			select = sc.nextInt();
			EmployeesDTO employeesDTO = employeesDAO.getDetail(select);
			if(employeesDTO != null) {
				employeesView.view(employeesDTO);
			}else {
				employeesView.view("data가 없습니다.");
			}
			break;
//		case 3: System.out.println("검색할 이름을 입력해주세요");
//			    select = sc.nextInt();
//			    employeesDTO = employeesDAO.getname(select);
//			    if(employeesDTO != null) {
//					employeesView.view(employeesDTO);
//				}else {
//					employeesView.view("data가 없습니다.");
//				}
//				break;
			default:
				check=false;
		
		
		}
		
	}
	
}
}
