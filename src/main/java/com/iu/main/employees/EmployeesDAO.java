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
	
	
   //월급의 평균 getAvg()
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

//5번 삭제데이터 
	public int deleteData(EmployeesDTO employeesDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, employeesDTO.getEmployee_id());
		int result = st.executeUpdate();
		return result;
	}
	
//4번 setData	
public int setData(EmployeesDTO employeesDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,"
				+ "HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, employeesDTO.getFirst_name());
		st.setString(2, employeesDTO.getLast_name());
		st.setString(3, employeesDTO.getEamil());
		st.setString(4, employeesDTO.getPhone_number());
		st.setString(5, employeesDTO.getHire_date());
		st.setString(6, employeesDTO.getJob_id());
		st.setDouble(7, employeesDTO.getSalary());
		st.setDouble(8, employeesDTO.getCommision_pct());
		st.setInt(9, employeesDTO.getManager_id());
		st.setInt(10, employeesDTO.getDepartment_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
//3번 사원 검색하기 getFind
	public ArrayList<EmployeesDTO> getFind(String search) throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		PreparedStatement st = connection.prepareStatement(sql);

		//'%a%'는 %가 꼭 들어가야 됨
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeesDTO.setLast_name(rs.getString("LAST_NAME"));
			employeesDTO.setEamil(rs.getString("EMAIL"));
			employeesDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeesDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeesDTO.setJob_id(rs.getString("JOB_ID"));  
			employeesDTO.setSalary(rs.getDouble("SALARY"));
			employeesDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
			employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeesDTO);
		}
		DBConnection.disConnect(rs, st, connection);		
		return ar;
	}	
	
//2번 개별 사원리스트 출력 	getDetail
	public EmployeesDTO getDetail(int employee_id) throws Exception{
	EmployeesDTO employeesDTO = null;
	//DB연결 
	Connection connection = DBConnection.getConnection();
	
	//쿼리문 생성 이걸 불러와줬으면 해 
	//쿼리문 쓸때 꼭 띄어쓰기하고 엔터쳐야지 문장이 잘 연결된다 
	//인덱스 번호는 선언한 순서대로 1,2,3,4---9
	String sql =  "SELECT EMPLOYEE_ID, FIRST_NAME ,LAST_NAME, EMAIL ,PHONE_NUMBER,"
			+ "HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID"
			+ " FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
	
	//PreparedStatement는 해킹을 막기위해 메서드와 ?를 이용하여 사용하는 클래스
	//미리 전송  
	PreparedStatement st = connection.prepareStatement(sql);
	st.setInt(1,employee_id); 
	//executeQuery()메소드는 수행결과로 ResultSet 객체의 값을 반환한다.
	ResultSet rs = st.executeQuery();
	
	
	//rs.next : rs 객체를 리턴해줘 
	if(rs.next()) {
	employeesDTO = new EmployeesDTO();
	employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
	employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
	employeesDTO.setLast_name(rs.getString("LAST_NAME"));
	employeesDTO.setEamil(rs.getString("EMAIL"));
	employeesDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
	employeesDTO.setHire_date(rs.getString("HIRE_DATE"));
	employeesDTO.setJob_id(rs.getString("JOB_ID"));
	employeesDTO.setSalary(rs.getDouble("SALARY"));
	employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
	employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
	employeesDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
     
	}
	DBConnection.disConnect(rs, st, connection);
	return employeesDTO;
	}
	
	
	
	
	
	//1번 사원 전체리스트 출력
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
			employeesDTO.setEamil(rs.getString("EMAIL"));
			employeesDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeesDTO.setHire_date(rs.getString("HIRE_DATE"));
			employeesDTO.setJob_id(rs.getString("JOB_ID"));
			employeesDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
			employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeesDTO.setSalary(rs.getDouble("SALARY"));
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
			
		//next 호출 필수 
		while(rs.next()) {
		EmployeesDTO employeesDTO = new EmployeesDTO();
		employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
		employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
		employeesDTO.setLast_name(rs.getString("LAST_NAME"));
		employeesDTO.setEamil(rs.getString("EMAIL"));
		employeesDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
		employeesDTO.setHire_date(rs.getString("HIRE_DATE"));
		employeesDTO.setJob_id(rs.getString("JOB_ID"));
		employeesDTO.setCommision_pct(rs.getDouble("COMMISSION_PCT"));
		employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
		employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		employeesDTO.setSalary(rs.getDouble("SALARY"));
		ar.add(employeesDTO);
	    }
		DBConnection.disConnect(rs, st, connection);
		return ar;
	   }
	  
	} 
	
	
	
	
	
