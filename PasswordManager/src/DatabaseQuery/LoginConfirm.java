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
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
	        String pwpw="" ;
	        String idid ="";
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        
	        try{
	            Class.forName(driver);  // ����̹� �ε�
	            con = DriverManager.getConnection(url, "hwano", "1234"); // DB ����
	            pstmt = con.prepareStatement(query);   

	            // ����ǥ�� 4�� �̹Ƿ� 4�� ���� �Է�������Ѵ�.
	            pstmt.setString(1, id);  // pstmt��ü�� ���� ����
	            pstmt.setString(2, pw);  // pstmt��ü�� ���� ����

	            int cnt = pstmt.executeUpdate();

	           	ResultSet rs = pstmt.executeQuery(query);
	        	
	            while (rs.next()) {
	            	 idid = rs.getString("user_id");
	            	 pwpw= rs.getString("user_password");
				//	System.out.println(" ���̵� : "+idid + ", �н�����: "+ pwpw);
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        	 return 3; //������ �����

	        }
	        {
	            try {
	                pstmt.close();
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	       }
	        
	        if(idid.equals(id)&&pwpw.equals(pw))
         {
         	System.out.println("���̵� �����ϴ� ��� ");
 			return 1;

         }
         else
         {
         	System.out.println("�������� �ʴ� ��� ");
 			return 2;
         }
	        


         
	}
}
