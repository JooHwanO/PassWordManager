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
	                                // �ֱ��� �����ؼ� �Է��� ���� ?���� ���ش�.
	        int user_no;
	        String name;
	        String id = null;
	        
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
	            	user_no = rs.getInt("user_number");
	            	 name= rs.getString("user_NAME");
					 id = rs.getString("user_id");
					System.out.println("��ȣ : "+user_no + ", �̸� : "+name + ", ���̵� : "+ id);
		    
				}
	
	            
	        }catch(Exception e){
	            System.out.println(e.getMessage());
            	return 3;

	        }finally{
	            try {
	                pstmt.close();
	                   con.close();               // �������� �ݾ��ش�.
	            } catch (Exception e2) {}
	       }
	        
	        if(c_id.equals(id))
            {
            	System.out.println("���̵� �����ϴ� ��� ");
    			return 1;

            }
            else if(c_id.toString().length()>0)
            {
            	System.out.println("�������� �ʴ� ��� ");
    			return 2;
            }
            else
            {
            	System.out.println("�����������ʴ� ������ ��� ������");
            	return 3;
            }
			
	 	}
}
