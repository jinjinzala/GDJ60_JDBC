package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeesController;
import com.iu.main.employees.EmployeesDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;

public class JDBCMain {
//희진테스트 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		EmployeesController ec = new EmployeesController();
		EmployeesDAO dao = new EmployeesDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		LocationDAO locationDAO = new LocationDAO();
		LocationController lc = new LocationController();
		FrontController fc = new FrontController();
		
		try {
			//ic.start();
			//dc.start();
			fc.start();
		//	dao.getAvg();
			LocationDTO locationDTO =new LocationDTO();
//			locationDAO.setData(locationDTO);
			lc.start();
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(280);
//			int result = departmentDAO.deleteData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

//		try {    
//			ec.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		DepartmentController  dc = new DepartmentController();
//		LocationController lc = new LocationController();
//		DepartmentDAO dao = new DepartmentDAO();
//		try {
//		    
//			dc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	
//		LocationDAO locationdao = new LocationDAO();
//		try {
//			lc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		
	System.out.println("finish");


 }
}
