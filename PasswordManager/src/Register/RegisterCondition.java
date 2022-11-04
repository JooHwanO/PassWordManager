package Register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterCondition {
	
	
	//ID정규식 
	public boolean ID_condition(String name)	
	{
		Pattern id = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).{6,10}$"); //영문  숫자 조합 8~12자리
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
	
	//PW정규식 
	public boolean Password_condition(String pass)
	{
		// Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
		Pattern pw = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,12}$"); //영문 특문 숫자 조합 8~12자리
		Matcher m = pw.matcher( pass);
		   if(m.matches()){
		        return true;}
		   else if (pass.length()<=0)
		   {return false;}
		return false;
	}
}
