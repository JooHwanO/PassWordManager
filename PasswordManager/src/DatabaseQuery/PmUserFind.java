package DatabaseQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.User;

public class PmUserFind {
	public static void main(String[] args)
	{
		//User_select us = new User_select();
		//us.PM_name("ghksdh587");
		//us.userinfo("ghksdh587");
	}
	/*===============================================모든정보를 불러오는 쿼리 =========================================================*/
	public ArrayList<User> user_info_AllSelect(String c_id)                 
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE user_id = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        int tem_num;
	        String page_id;
	        String page_password;
	        String page_name;
	        String page_email;
	        String singupdate;
	        String division;
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
	            pstmt.setString(1, c_id);  // pstmt객체에 각각 셋팅

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
	    	         division= rs.getString("division");
	    	         pageaddress= rs.getString("pageaddress");
	    	         websitename= rs.getString("websitename");
	    	         remarks = rs.getString("remarks");
	    	         al.add(new User(tem_num,page_id,page_password,page_name,page_email,singupdate,division,pageaddress,websitename,remarks));
	    	         
	    	    //     user_id= rs.getString("user_id");
	            	
				//	System.out.println("번호 : "+tem_num + ", 이름 : "+page_name + ", 아이디 : "+ pageaddress);
		    
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }{
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	       }
	       	return al;
		}
	
	
		/*========================================= 해당 프로그램 사용자 이름을 검색(상단에 표시되는 곳) ======================================*/
	public String  PM_name(String pmid)
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM user_table WHERE user_id = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        String pm_name= null;
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // 드라이버 로딩
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB 연결
	            pstmt = con.prepareStatement(query);   

	            // 물음표가 4개 이므로 4개 각각 입력해줘야한다.
	            pstmt.setString(1, pmid);  // pstmt객체에 각각 셋팅

	            int cnt = pstmt.executeUpdate();
	            //pstmt.executeUpdate(); create insert update delete 
	            //pstmt.executeQuery(); select 
	           	ResultSet rs = pstmt.executeQuery(query);
	        	
	            while (rs.next()) {
	            	pm_name = rs.getString("user_name");
	  				// System.out.println( "이름 : "+pm_name );
				}
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	       }
	       	return pm_name;
		}
	
	/*===============================================상세 정보를 위한 쿼리 =========================================================*/
	public ArrayList<User> webname_count_info(String s_id, String s_name)  //사이트이름으로 그 사이트 정보가 몇개인지 확인하기위함.
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE user_id = ? and websitename = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        int tem_num;
	        String page_id;
	        String page_password;
	        String page_name;
	        String page_email;
	        String singupdate;
	        String division;
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
	            pstmt.setString(1, s_id);  // pstmt객체에 각각 셋팅
	            pstmt.setString(2, s_name);  // pstmt객체에 각각 셋팅

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
	    	         division= rs.getString("division");
	    	         pageaddress= rs.getString("pageaddress");
	    	         websitename= rs.getString("websitename");
	    	         remarks= rs.getString("remarks");
	    	         al.add(new User(tem_num,page_id,page_password,page_name,page_email,singupdate,division,pageaddress,websitename,remarks));
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	        finally{
	            try {
	                pstmt.close();
	                   con.close();               // 역순으로 닫아준다.
	            } catch (Exception e2) {}
	       }
	       	return al;
		}
	
	/*===============================================상세 정보를 위한 쿼리 =========================================================*/
	public ArrayList<User> Detail_info_select(int s_name)
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE  tem_num = ?";    
	                                // 주기적 변경해서 입력할 곳은 ?으로 써준다.
	        int tem_num;
	        String page_id;
	        String page_password;
	        String page_name;
	        String page_email;
	        String singupdate;
	        String division;
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
	            pstmt.setInt(1, s_name);  // pstmt객체에 각각 셋팅

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
	    	         division= rs.getString("division");
	    	         pageaddress= rs.getString("pageaddress");
	    	         websitename= rs.getString("websitename");
	    	         remarks = rs.getString("remarks");
	    	         al.add(new User(tem_num,page_id,page_password,page_name,page_email,singupdate,division,pageaddress,websitename,remarks));
	    	         
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

