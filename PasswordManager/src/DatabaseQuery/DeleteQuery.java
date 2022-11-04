package DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteQuery { //�����ϴ� ������ ������ ���
	 public int delete(int tem_num, String user_id )
	 {
		 	String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@183.103.47.106:1521:xe"; //���ξ����� ������
	        String query = "delete from register_info where tem_num = ? and user_id = ? ";    
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
	        
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	      
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
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	        }
			
	    }

}
