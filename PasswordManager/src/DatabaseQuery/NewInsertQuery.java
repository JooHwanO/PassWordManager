package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NewInsertQuery { //새로운 정보 삽입 시 
	
	 public int new_insert(String page_id, String page_password, String page_name, 
			 String page_email,String singupdate,String division,
			 String pageaddress,String websitename,String remarks,String user_id)
	 {
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "insert into register_info values (regiset_num.nextval, ? , ? , ? , ?, ?, ?, ?, ?, ?,?)";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   
	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	            pstmt.setString(1, page_id);  // pstmt객체에 각각 셋팅
	            pstmt.setString(2, page_password);
	            pstmt.setString(3, page_name);
	            pstmt.setString(4, page_email);
	            pstmt.setString(5, singupdate);
	            pstmt.setString(6, division);
	            pstmt.setString(7, pageaddress);
	            pstmt.setString(8, websitename);
	            pstmt.setString(9, remarks);
	            pstmt.setString(10, user_id);
	            int cnt = pstmt.executeUpdate();
	            
	            return 1;
	            //pstmt.executeUpdate(); create insert update delete 
	            //pstmt.executeQuery(); select 
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            return 0;
	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	        }
			
	    }
}
