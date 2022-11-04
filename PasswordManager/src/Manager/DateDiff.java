package Manager;

import java.awt.Component;
import java.awt.Font;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import Main.User;

public class DateDiff {
	Date signupDate;
	Date nowDate;
	long diffInMillies ; 
	int diff ;
 
	@SuppressWarnings("unused")
	public int datediff(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA);

		try {
			signupDate = sdf.parse(date);
			nowDate= new Date(); //현재날짜구하기
		//	System.out.println(signupDate);
		//	System.out.println(nowDate);
			diffInMillies = Math.abs(nowDate.getTime() - signupDate.getTime()); 
			diff = (int)TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		//	System.out.println(diff);
		} catch (ParseException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		return diff;
	}
	
	/*        // 주소에서 가운데 부분만 뽑아내어 첫글자 대문자화 시키는 메소드
	public List<String> name_get(ArrayList<User> ar)
	{
		List<String> ar2 = new ArrayList<String>();

		for(int i=0; i<ar.size();i++)
		{
				String domain =ar.get(i).getPageaddress();
				domain =domain.substring(domain.lastIndexOf("www.")+4, domain.lastIndexOf(".com"));       //주소에서 이름추출 
				String first = domain.substring(0,1);                                                                                     //첫번째 글자만 추출
				String last = domain.substring(1,domain.length());                                                                //나머지 글자추출
				first = first.toUpperCase();                                                                                                 //첫번째 글자 대문자화
				String full = first+last;                                                                                                      //합쳐져서 첫번째글자만 대문자인 문자열 
				ar2.add(full);
		}
		return ar2;
		
	}
	*/
	
}
