package com.iu.main;

import java.util.Scanner;

public class FrontController {
//
	private Scanner sc;
	private DepartmentController departmentController;
	private LocationContriller locationContriller;
	
	public public FrontController() {
		
	}
	
	
	public FrontController() {
		this.sc = new Scanner(System.in);
		this.DepartmentController = new DepartmentController();
	}
	
	public void start() throws Exception {
		boolean check = true;
	
		while (check) {
			System.out.println("1.부서관리");
			System.out.println("2. 지역관리");
			System.out.println("3. 사원관리");
			System.out.println("4. 종료");
			int select = sc.nextInt();
		
		switch (select) {
		case 1:
			this.departmentController.start();
			break;
		case 2:
			this.locationController
			break;
		case 3:
	      
			break;

		default:
			check = false;
			break;
		}
		}
		
	}
	
	}
	
	
}
