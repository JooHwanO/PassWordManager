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
			nowDate= new Date(); //���糯¥���ϱ�
		//	System.out.println(signupDate);
		//	System.out.println(nowDate);
			diffInMillies = Math.abs(nowDate.getTime() - signupDate.getTime()); 
			diff = (int)TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		//	System.out.println(diff);
		} catch (ParseException e) {
			// TODO �ڵ� ������ catch ���
			e.printStackTrace();
		}
		return diff;
	}
	
	/*        // �ּҿ��� ��� �κи� �̾Ƴ��� ù���� �빮��ȭ ��Ű�� �޼ҵ�
	public List<String> name_get(ArrayList<User> ar)
	{
		List<String> ar2 = new ArrayList<String>();

		for(int i=0; i<ar.size();i++)
		{
				String domain =ar.get(i).getPageaddress();
				domain =domain.substring(domain.lastIndexOf("www.")+4, domain.lastIndexOf(".com"));       //�ּҿ��� �̸����� 
				String first = domain.substring(0,1);                                                                                     //ù��° ���ڸ� ����
				String last = domain.substring(1,domain.length());                                                                //������ ��������
				first = first.toUpperCase();                                                                                                 //ù��° ���� �빮��ȭ
				String full = first+last;                                                                                                      //�������� ù��°���ڸ� �빮���� ���ڿ� 
				ar2.add(full);
		}
		return ar2;
		
	}
	*/
	
}
