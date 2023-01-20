package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.main.departments.DepartmentDTO;
import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeesDAO {
	
	
   //월급의 평균
	public HashMap<String, Double> getAvg() throws Exception{
		HashMap<String, Double> map = new HashMap<String, Double>();
		

		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT AVG(SALARY)*12+100 AS A, SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
	    
		rs.next();
		

		//1. List,Array<Double>
		//2. DTO(Class)
		//3. Map(key,value)
		
		map.put("avg",rs.getDouble("A") );
		map.put("sum",rs.getDouble(2));
		
		DBConnection.disConnect(rs, st, con);
		return map;
	
	
	}

	public EmployeesDTO getDetail(int employees_id) throws Exception{
		
	EmployeesDTO employeesDTO = new EmployeesDTO();	
	//DB연결 
	Connection connection = DBConnection.getConnection();
	
	//쿼리문 생성 이걸 불러와줬으면 해 
	//쿼리문 쓸때 꼭 띄어쓰기하고 엔터쳐야지 문장이 잘 연결된다 
	//인덱스 번호는 선언한 순서대로 1,2,3,4---9
	String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,JOB_ID"
			     + "FROM EMPLOYEES WHERE EMPLOYEE_ID =? ORDER BY HIRE_DATE DESC";
	
	//PreparedStatement는 해킹을 막기위해 메서드와 ?를 이용하여 사용하는 클래스
	//미리 전송  
	PreparedStatement st = connection.prepareStatement(sql);
	st.setInt(1,employees_id); 
	//executeQuery()메소드는 수행결과로 ResultSet 객체의 값을 반환한다.
	ResultSet rs = st.executeQuery();
	
	
	//rs.next : rs 객체를 리턴해줘 
	if(rs.next()) {
	employeesDTO = new EmployeesDTO();
    employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
    employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
    employeesDTO.setLast_name(rs.getString("LAST_NAME"));
    employeesDTO.setJob_id(rs.getString("JOB_ID"));
     
	}
	DBConnection.disConnect(rs, st, connection);
	return employeesDTO;
	}
	
	//2번 문제 
	public ArrayList<EmployeesDTO> getList() throws Exception{
	ArrayList<EmployeesDTO> ar =  new ArrayList<EmployeesDTO>();
	Connection connection = DBConnection.getConnection();	
	
	//3. Query문 생성
	String sql = "SELECT * FROM EMPLOYEES";
	//4. 미리 전송
	PreparedStatement st = connection.prepareStatement(sql);
	//6. 최종 전송 및 결과 처리 
	ResultSet rs = st.executeQuery();
	//4개가 모여서 DTO하나가 된다 
	//한줄씩읽으려면 무조건 NEXT 호출하기 
	   while(rs.next()) {
		   //객체 만들기 
		   EmployeesDTO employeesDTO = new EmployeesDTO();
		   employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
		   employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
		   employeesDTO.setLast_name(rs.getString("LAST_NAME"));
		   employeesDTO.setJob_id(rs.getString("JOB_ID"));
		   ar.add(employeesDTO);
	   }
	   DBConnection.disConnect(rs, st, connection);
	   //꺼낸데이터를 리턴 
	   return ar;
	}
	   
	   // 이름으로 
	   public ArrayList<EmployeesDTO> getname(String search) throws Exception{
		  ArrayList<EmployeesDTO> ar =  new ArrayList<EmployeesDTO>();
		  Connection connection = DBConnection.getConnection(); 
		//3. Query문 생성
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
	    //4. 미리 전송
	    PreparedStatement st = connection.prepareStatement(sql);
	    //메서드안에 스트링 서치 선언했기 때문에 
		st.setString(1,search);
			
		//6. 최종 전송 및 결과 처리 
		ResultSet rs = st.executeQuery();
			
		//4개가 모여서 DTO하나가 된다 next 호출 필수 
		while(rs.next()) {
		EmployeesDTO employeesDTO = new EmployeesDTO();
		employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
		employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
		employeesDTO.setLast_name(rs.getString("LAST_NAME"));
		employeesDTO.setJob_id(rs.getString("JOB_ID"));
		employeesDTO.setHire_date(rs.getString("HIRE_DATE"));
		ar.add(employeesDTO);
	    }
		DBConnection.disConnect(rs, st, connection);
		return ar;
	   }
	  
	} 
	
	
	
	
	


