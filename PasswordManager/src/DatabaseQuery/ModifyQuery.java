package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ModifyQuery { //�����ϴ� ������ ������ ��� 
	 public int mdofiy(int tem_num, String page_id, String page_password, String page_name, 
			 String page_email,String singupdate,String division,
			 String pageaddress,String websitename,String remarks, String user_id )
	 {
		   String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe";
	        String query = "update register_info set  page_id =?, page_password=?, page_name=? , "
	        		+ "page_email= ? ,singupdate= ?, division=  ?, pageaddress=?, websitename=?, remarks= ? "
	        		+ "where tem_num = ? and user_id = ? ";    
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	      
	            pstmt.setString(1, page_id);  // pstmt��ü�� ���� ����
	            pstmt.setString(2, page_password);
	            pstmt.setString(3, page_name);
	            pstmt.setString(4, page_email);
	            pstmt.setString(5, singupdate);
	            pstmt.setString(6, division);
	            pstmt.setString(7, pageaddress);
	            pstmt.setString(8, websitename);
	            pstmt.setString(9, remarks);
	            pstmt.setInt(10, tem_num);
	            pstmt.setString(11, user_id);

	            
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
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	        }
			
	    }
}
