package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteQuery { //존재하는 정보를 삭제할 경우
	 public int delete(int tem_num, String user_id )
	 {
		 	String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe"; //공인아이피 넣을것
	        String query = "delete from register_info where tem_num = ? and user_id = ? ";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   

	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	      
	            pstmt.setInt(1, tem_num);
	            pstmt.setString(2, user_id);
	     
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
