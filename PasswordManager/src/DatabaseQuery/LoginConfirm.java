package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginConfirm {
	/*
	public static void main(String[] args)
	{
		LoginConfirm lc= new LoginConfirm();
		lc.login_confirm("ghksdh57", "1234");
	}
	*/
	public int login_confirm(String id, String pw)
	{
	     String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM user_table WHERE user_id = ? and user_password = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        String pwpw="" ;
	        String idid ="";
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   

	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	            pstmt.setString(1, id);  // pstmt객체에 각각 셋팅
	            pstmt.setString(2, pw);  // pstmt객체에 각각 셋팅

	            int cnt = pstmt.executeUpdate();

	           	ResultSet rs = pstmt.executeQuery(query);
	        	
	            while (rs.next()) {
	            	 idid = rs.getString("user_id");
	            	 pwpw= rs.getString("user_password");
				//	System.out.println(" 아이디 : "+idid + ", 패스워드: "+ pwpw);
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        	 return 3; //에러가 난경우

	        }
	        {
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	       }
	        
	        if(idid.equals(id)&&pwpw.equals(pw))
         {
         	System.out.println("아이디가 존재하는 경우 ");
 			return 1;

         }
         else
         {
         	System.out.println("존재하지 않는 경우 ");
 			return 2;
         }
	        


         
	}
}
