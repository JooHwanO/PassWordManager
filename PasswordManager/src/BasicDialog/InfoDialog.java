package BasicDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Main.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import DatabaseQuery.PmUserFind;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InfoDialog extends JDialog {

	private  JPanel contentPanel = new JPanel();
	private ArrayList<User> al = new ArrayList<>();
	String sitename;
	String id;
	String ad = null; //홈페이지 주소값을 바음

/*
	public static void main(String[] args) {
		try {
			InfoDialog dialog = new InfoDialog("ghksdh587","Naver");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/

	public InfoDialog(String id, String sitename) {
		this.id =id;
		this.sitename=sitename;
		PmUserFind pm =new PmUserFind();
		al= pm.webname_count_info(id, sitename); //사이트이름이 두개라면 한사이트에 아이디가 두개존재하는것. 
		
		 if(al.size()<2)  // 사이트 이름 검색시 정보가 두개 이상이면 두개의 정보를 볼수있는 even을 띄움  (이것은 한사이트에 두개의 아이디가 존재하는 것)
		 { 
			 DetailDialog De =new DetailDialog(al.get(0).getTem_num()); //한개라면 디테일다이얼로그를 띄워 바로 상세정보를 볼수 잇도록함
			 De.setVisible(true);
			 dispose();
		 }
		 else
		 {
			 	setVisible(true);
				getContentPane().setBackground(Color.DARK_GRAY);
				setModal(true);
				setLocationRelativeTo(null); //윈도우창 가운데 띄움 
				setResizable(false);                                                    //크기조절 못하게 
				even();
		 }
	}

	private void even()
	{
		setBounds(228, 100, 381, 360);
		setModal(true);
		setLocationRelativeTo(null); //윈도우창 가운데 띄움 
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 374, 61);
		contentPanel.setBorder(new LineBorder(new Color(64, 64, 64), 12));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("상세 정보");
		lblNewLabel_5.setBounds(5, 5, 357, 51);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_5);
		

		JScrollPane scrollPane = new JScrollPane();
		JPanel gridpanel = new JPanel();
		JPanel borderpanel = new JPanel();
		scrollPane.setViewportView(borderpanel);
		scrollPane.setBounds(10, 62, 348, 240);
		getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(borderpanel);
		borderpanel.setBorder(new LineBorder(Color.white, 5));
		borderpanel.setLayout(new BorderLayout(0, 0));
		borderpanel.add(gridpanel, BorderLayout.NORTH);
		gridpanel.setLayout(new GridLayout(0, 1, 0, 6));
		
		for(int i=0;i<al.size();i++) //해당정보 갯수만큼 간편보기 정보 출력 
		{
			JPanel rowPanel = new JPanel(); 
			rowPanel.setPreferredSize(new Dimension(100,110));    
			rowPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
			rowPanel.setBackground(Color.white);
			rowPanel.setLayout(null);
			gridpanel.add(rowPanel); 
			
			JLabel jl1 = new JLabel("ID : ");
			jl1.setHorizontalAlignment(SwingConstants.TRAILING);
			jl1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jl1.setBounds(10,8,50,20);
			rowPanel.add(jl1);
			
			JLabel jl2 = new JLabel("Site : ");
			jl2.setHorizontalAlignment(SwingConstants.TRAILING);
			jl1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

			jl2.setBounds(10,31,50,20);
			rowPanel.add(jl2);
			
			JLabel jl3 = new JLabel("가입자 : ");
			jl3.setHorizontalAlignment(SwingConstants.TRAILING);
			jl3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jl3.setBounds(10,54,50,20);
			rowPanel.add(jl3);
			
			JLabel jl4 = new JLabel("가입일 : ");
			jl4.setHorizontalAlignment(SwingConstants.TRAILING);
			jl4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jl4.setBounds(10,77,50,20);
			rowPanel.add(jl4);
			/////////////////////////////////////////////////////
			JLabel jid = new JLabel("zzzz");
			jid.setHorizontalAlignment(SwingConstants.LEFT);
			jid.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jid.setBounds(70,8,100,20);
			rowPanel.add(jid);
			
			JLabel jsite = new JLabel("zzzz");
			jsite.setHorizontalAlignment(SwingConstants.LEFT);
			jsite.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jsite.setBounds(70,31,100,20);
			rowPanel.add(jsite);
			
			JLabel jname = new JLabel("zzzzz");
			jname.setHorizontalAlignment(SwingConstants.LEFT);
			jname.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jname.setBounds(70,54,100,20);
			rowPanel.add(jname);
			
			JLabel jsignup = new JLabel("zzzz");
			jsignup.setHorizontalAlignment(SwingConstants.LEFT);
			jsignup.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jsignup.setBounds(70,77,100,20);
			rowPanel.add(jsignup);

			JButton jb = new JButton("모든 정보");
			jb.setBackground(Color.DARK_GRAY);
			jb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			jb.setForeground(Color.white);
			jb.setBounds(210,5,100,100);
			rowPanel.add(jb);
			
			jid.setText(al.get(i).getPage_id());
			jsite.setText(al.get(i).getWebsitename());
			jname.setText(al.get(i).getPage_name());
			jsignup.setText(al.get(i).getSingupdate());
			int aa= al.get(i).getTem_num();

			
			jb.addMouseListener(new MouseAdapter() { //버튼 마우스 클릭이벤트
				@Override
				public void mouseClicked(MouseEvent e) {
					 if (e.getClickCount() == 1) { //다수의 정보 중 해당 상세정보보기를 누르면 그정보의 상세정보를 볼 수 있음. 
						 DetailDialog dd=new DetailDialog(aa); 
						 dd.setVisible(true);
					    } 
				}
			});

	}
	}
}
