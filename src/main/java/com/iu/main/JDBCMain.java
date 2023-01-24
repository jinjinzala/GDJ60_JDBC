package com.iu.main;
import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeesController;
import com.iu.main.employees.EmployeesDAO;
import com.iu.main.employees.EmployeesDTO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;
import com.iu.main.util.DBConnection;
import com.iu.main.util.DBConnection;


public class JDBCMain {

	public static void main(String[] args) {
    DepartmentDAO departmentDAO = new DepartmentDAO();
    DepartmentDTO departmentDTO = new DepartmentDTO();
    DepartmentController departmentController = new DepartmentController();
    EmployeesController employeesController = new EmployeesController();
    EmployeesDAO employeesDAO = new EmployeesDAO();
    EmployeesDTO employeesDTO = new EmployeesDTO();
    
     
	System.out.println("start");
 
	  try {
			employeesController.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	System.out.println("finish");

	
	
	
// department 	
//	  try {
//			departmentController.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	

 }
}
