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
	/*===============================================��������� �ҷ����� ���� =========================================================*/
	public ArrayList<User> user_info_AllSelect(String c_id)                 
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE user_id = ?";    
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
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
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	            pstmt.setString(1, c_id);  // pstmt��ü�� ���� ����

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
	            	
				//	System.out.println("��ȣ : "+tem_num + ", �̸� : "+page_name + ", ���̵� : "+ pageaddress);
		    
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }{
	            try {
	                pstmt.close();
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	       }
	       	return al;
		}
	
	
		/*========================================= �ش� ���α׷� ����� �̸��� �˻�(��ܿ� ǥ�õǴ� ��) ======================================*/
	public String  PM_name(String pmid)
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM user_table WHERE user_id = ?";    
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
	        String pm_name= null;
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	            pstmt.setString(1, pmid);  // pstmt��ü�� ���� ����

	            int cnt = pstmt.executeUpdate();
	            //pstmt.executeUpdate(); create insert update delete 
	            //pstmt.executeQuery(); select 
	           	ResultSet rs = pstmt.executeQuery(query);
	        	
	            while (rs.next()) {
	            	pm_name = rs.getString("user_name");
	  				// System.out.println( "�̸� : "+pm_name );
				}
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	       }
	       	return pm_name;
		}
	
	/*===============================================�� ������ ���� ���� =========================================================*/
	public ArrayList<User> webname_count_info(String s_id, String s_name)  //����Ʈ�̸����� �� ����Ʈ ������ ����� Ȯ���ϱ�����.
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE user_id = ? and websitename = ?";    
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
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
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	            pstmt.setString(1, s_id);  // pstmt��ü�� ���� ����
	            pstmt.setString(2, s_name);  // pstmt��ü�� ���� ����

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
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	       }
	       	return al;
		}
	
	/*===============================================�� ������ ���� ���� =========================================================*/
	public ArrayList<User> Detail_info_select(int s_name)
	{
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "SELECT * FROM register_info WHERE  tem_num = ?";    
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
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
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	            pstmt.setInt(1, s_name);  // pstmt��ü�� ���� ����

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
				//	System.out.println("��ȣ : "+tem_num + ", �̸� : "+page_name + ", ���̵� : "+ pageaddress);
		    
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	       }
	       	return al;
		}
	
	

	
	
	}

