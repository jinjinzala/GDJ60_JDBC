package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class DepartmentDAO {

	//update 
	public int updateData(DepartmentDTO departmentDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql  = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME =?, MANAGER_ID =?,LOCATION_ID=?"
				    + "WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, departmentDTO.getDepartment_name());
        st.setInt(2, departmentDTO.getManager_id());
        st.setInt(3, departmentDTO.getLocation_id());
        st.setInt(4, departmentDTO.getDepartment_id());

        int result = st.executeUpdate();
        DBConnection.disConnect(st, con);
        return result;
        
	}
	
	
	
	
	//delete
	public int deleteData(DepartmentDTO departmentDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
		
	}

	
	
	//insert
	//타입이 여러개 일때 DTO(데이터를 운반하는 도구)를 사용해서 선언하자~
    // 리턴타입에 맞게 int로 변경 
	
	public int setData(DepartmentDTO departmentDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME, MANAGER_ID,LOCATION_ID)"
				+ "VALUES (DEPARTMENT_SEQ.NEXTVAL,?,?,?)";
	    PreparedStatement st = connection.prepareStatement(sql);
	    
	    st.setString(1,departmentDTO.getDepartment_name());
	    st.setInt(2,departmentDTO.getManager_id());
	    st.setInt(3,departmentDTO.getLocation_id());
	    
	    int result = st.executeUpdate();
	    DBConnection.disConnect(st, connection);
	    return result;

	
	}
	
   public DepartmentDTO getDetail(int department_id) throws Exception {
	  
	   DepartmentDTO departmentDTO = new DepartmentDTO(); 
	   // sql연결을 도와주는 Connection 클래스에다가 DBConnection 클래스의 getConnection()메소드 연결
	   Connection connection = DBConnection.getConnection();
	   
	   String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
	   //PreparedStatement는 해킹을 막기위해 메서드와 ?를 이용하여 사용하는 클래스
	   PreparedStatement st = connection.prepareStatement(sql);
   
	   st.setInt(1,department_id); 
	  //executeQuery()메소드는 수행결과로 ResultSet 객체의 값을 반환한다.
	   ResultSet rs = st.executeQuery();
	   
	   if(rs.next()) {
		   departmentDTO = new DepartmentDTO();
		   departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		   departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
		   departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
		   departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
	   }
	   DBConnection.disConnect(rs, st, connection);
	   return departmentDTO;
   }
   

   public ArrayList<DepartmentDTO> getList() throws Exception{
	   ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
	   //DBConnection dbConnection = new DBConnection();
	   Connection connection = DBConnection.getConnection();
	   
	   //3. Query문 생성
	   String sql = "SELECT * FROM DEPARTMENTS";
	   //4. 미리 전송
	   PreparedStatement st = connection.prepareStatement(sql);
	   //5. ? 세팅 
	   
	   //6. 최종 전송 및 결과 처리 
	   ResultSet rs = st.executeQuery();
	   //4개가 모여서 DTO하나가 된다 
	   while(rs.next()) {
		   DepartmentDTO departmentDTO = new DepartmentDTO();
		   departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		   departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
		   departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
		   departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		   ar.add(departmentDTO);
		
	   }
 
	   DBConnection.disConnect(rs, st, connection);
	   return ar;
	       
   }

}
