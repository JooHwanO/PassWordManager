package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Main.User;

public class TabMenuQuery {
	//탭메뉴에 항목을 넣기위해 Division 항목을 가져오는 쿼리
	public ArrayList<User> tab_menu_select(String division,String id)
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE  division = ? and user_id = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        int tem_num;
	        String page_id;
	        String page_password;
	        String page_name;
	        String page_email;
	        String singupdate;
	        String Division;
	        String pageaddress;
	        String user_id;
	        String websitename;
	        String remarks;
	        ArrayList<User> al = new ArrayList<>();
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   

	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	            pstmt.setString(1, division);  // pstmt객체에 각각 셋팅
	            pstmt.setString(2, id);  // pstmt객체에 각각 셋팅
	            int cnt = pstmt.executeUpdate();
	            //pstmt.executeUpdate(); create insert update delete 
	            //pstmt.executeQuery(); select 
	           	ResultSet rs = pstmt.executeQuery(query);
	        	
	            while (rs.next()) {
	    	         tem_num = rs.getInt("tem_num");
	    	         page_id= rs.getString("page_id");
	    	         page_password= rs.getString("page_password");
	    	         page_name= rs.getString("page_name");
	    	         page_email= rs.getString("page_email");
	    	         singupdate= rs.getString("singupdate");
	    	         Division= rs.getString("division");
	    	         pageaddress= rs.getString("pageaddress");
	    	         websitename= rs.getString("websitename");
	    	         remarks = rs.getString("remarks");
	    	         al.add(new User(tem_num,page_id,page_password,page_name,page_email,singupdate,Division,pageaddress,websitename,remarks));
	    	         
	    	    //     user_id= rs.getString("user_id");
				//	System.out.println("번호 : "+tem_num + ", 이름 : "+page_name + ", 아이디 : "+ pageaddress);
		    
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	       }
	       	return al;
		}
	
	
}
