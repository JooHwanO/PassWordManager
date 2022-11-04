package Register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterCondition {
	
	
	//ID���Խ� 
	public boolean ID_condition(String name)	
	{
		Pattern id = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).{6,10}$"); //����  ���� ���� 8~12�ڸ�
		Matcher d = id.matcher( name);
		   if(d.matches()){
		        return true;
		    }
		   else if (name.length()<=0)
		   {
			   return false;
		   }
		return false;
	}
	
	//PW���Խ� 
	public boolean Password_condition(String pass)
	{
		// Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
		Pattern pw = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,12}$"); //���� Ư�� ���� ���� 8~12�ڸ�
		Matcher m = pw.matcher( pass);
		   if(m.matches()){
		        return true;}
		   else if (pass.length()<=0)
		   {return false;}
		return false;
	}
}
