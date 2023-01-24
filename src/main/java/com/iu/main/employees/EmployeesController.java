package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {
//사원정보리스트는 신입사원순으로 출력
//사원검색은 사원이름으로 검색

	
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
		ArrayList<EmployeesDTO> ar =null;
		EmployeesDTO employeesDTO = null;
		while(check) {
			System.out.println("1.사원 전체 리스트");
			System.out.println("2.사원 번호로 검색_개별사원정보출력 ");
			System.out.println("3.사원 검색");
            System.out.println("4.사원 추가");
            System.out.println("5.사원 삭제");
            System.out.println("6.사원 수정");
            System.out.println("7.종    료");
		//입력한 번호의 값을 받아오는 함수 	
			int select = sc.nextInt();
			switch(select){
			case 1:
				ar = employeesDAO.getList();
				employeesView.view(ar);			
				break;
		case 2:
			System.out.println("검색할 사원번호를 입력해주세요");
			select = sc.nextInt();
			employeesDTO = employeesDAO.getDetail(select);
			if(employeesDTO != null) {
				employeesView.view(employeesDTO);
			}else {
				employeesView.view("data가 없습니다.");
			}
			break;
//		case 3:
//			System.out.print("검색할 사원 이름 입력:");
//			String add = sc.next();
//			ar = employeesDAO.getFind(add);
//			employeesView.view(ar);
//			break;
//		case 4:
//			employeesDTO = employeeInput.setData();
//			select = employeesDAO.setData(employeesDTO);
//			if(select > 0) {
//				employeesView.view("추가에 성공하였습니다");
//			}else {
//				employeesView.view("추가에 실패하였습니다");
//			}
//			break;
//		case 5:
//			employeesDTO = employeeInput.deleteData();
//			select = employeesDAO.deleteData(employeesDTO);
//			if(select > 0) {
//				employeesView.view("사원 삭제를 성공하였습니다");
//			}else {
//				employeesView.view("사원 삭제를 실패하였습니다");
//			}
//			break;
//		case 6:
//			employeesDTO = employeeInput.updateData();
//			select = employeesDAO.updateData(employeesDTO);
//			if(select > 0) {
//				employeesView.view("수정에 성공하였습니다");
//			}else {
//				employeesView.view("수정에 실패하였습니다");
//			}
//			break;
//		default:

			default:
				check=false;
		
		
		}
		
	}
	
}
}

