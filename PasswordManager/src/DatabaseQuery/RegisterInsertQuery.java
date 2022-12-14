package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterInsertQuery {
	// public static void main(String[] args) {
	       
	 public int insert(String user_id, String user_password, String user_name, String user_tel)
	 {
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "insert into user_table values (user_num.nextval, ? , ? , ? , ? )";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   

	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	            pstmt.setString(1, user_id);  // pstmt객체에 각각 셋팅
	            pstmt.setString(2, user_password);
	            pstmt.setString(3, user_name);
	            pstmt.setString(4, user_tel);
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
