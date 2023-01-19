package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;

public class LocationController {

	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationInput locationInput;
	private LocationDTO locationDTO;
	
	public LocationController() {
		this.sc = new Scanner(System.in);
		this.locationDAO = new LocationDAO();
		this.locationInput = new LocationInput();
	}
	public void start() throws Exception {
		boolean check = true;
		
		ArrayList<LocationDTO> ar =null;
		while(check) {
			System.out.println("1.부서 리스트");	
			System.out.println("2.부서 상세 정보");
			System.out.println("3.주 소 검 색");
			System.out.println("4.업데이트 데이터 ");
			System.out.println("5.인서트 데이터 ");
			System.out.println("6.종    료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				 ar = locationDAO.getList();
				break;
			case 2:
				System.out.println("로케이션 넘버를 입력하세요");
				select = sc.nextInt();
		        locationDAO.getDetail(select);
				break;
			case 3:
				System.out.println("검색할 주소를 입력 ");
				String add = sc.next();
			    ar = locationDAO.getFind(add);
				break;
			case 4:	
				//업데이트 데이터 
			   locationDTO = locationInput.updateData();
			   select = locationDAO.updateData(locationDTO);
			   if(select > 0) {
				   System.out.println("수정이 성공 ");
				}else {
					 System.out.println("수정이 실패 ");
				}
				break;
				
//			case 5:	
//				//인서트 데이터 
//				
//				break;
			
			default:
				check = false;
			}
		}
	}
}
