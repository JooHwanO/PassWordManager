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
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	            pstmt.setString(1, user_id);  // pstmt��ü�� ���� ����
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
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	        }
			
	    }
	 
}
