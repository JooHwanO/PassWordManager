package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterIDCheck {
	
	 /*public static void main(String[] args) {
	
		 	IdCheck a = new IdCheck();
		 	int b =a.id_check("ghksdh587");
		 	System.out.println(b);
	    }
	    */
	 	public int id_check(String c_id)
	 	{
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM user_table WHERE user_id = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        int user_no;
	        String name;
	        String id = null;
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   

	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	            pstmt.setString(1, c_id);  // pstmt객체에 각각 셋팅

	            int cnt = pstmt.executeUpdate();
	            //pstmt.executeUpdate(); create insert update delete 
	            //pstmt.executeQuery(); select 
	           	ResultSet rs = pstmt.executeQuery(query);
	        	
	            while (rs.next()) {
	            	user_no = rs.getInt("user_number");
	            	 name= rs.getString("user_NAME");
					 id = rs.getString("user_id");
					System.out.println("번호 : "+user_no + ", 이름 : "+name + ", 아이디 : "+ id);
		    
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
            	return 3;

	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	       }
	        
	        if(c_id.equals(id))
            {
            	System.out.println("아이디가 존재하는 경우 ");
    			return 1;

            }
            else if(c_id.toString().length()>0)
            {
            	System.out.println("존재하지 않는 경우 ");
    			return 2;
            }
            else
            {
            	System.out.println("존재하지도않는 나머지 경우 에러임");
            	return 3;
            }
			
	 	}
}
