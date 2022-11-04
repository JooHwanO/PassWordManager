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
	String ad = null; //Ȩ������ �ּҰ��� ����

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
		al= pm.webname_count_info(id, sitename); //����Ʈ�̸��� �ΰ���� �ѻ���Ʈ�� ���̵� �ΰ������ϴ°�. 
		
		 if(al.size()<2)  // ����Ʈ �̸� �˻��� ������ �ΰ� �̻��̸� �ΰ��� ������ �����ִ� even�� ���  (�̰��� �ѻ���Ʈ�� �ΰ��� ���̵� �����ϴ� ��)
		 { 
			 DetailDialog De =new DetailDialog(al.get(0).getTem_num()); //�Ѱ���� �����ϴ��̾�α׸� ��� �ٷ� �������� ���� �յ�����
			 De.setVisible(true);
			 dispose();
		 }
		 else
		 {
			 	setVisible(true);
				getContentPane().setBackground(Color.DARK_GRAY);
				setModal(true);
				setLocationRelativeTo(null); //������â ��� ��� 
				setResizable(false);                                                    //ũ������ ���ϰ� 
				even();
		 }
	}

	private void even()
	{
		setBounds(228, 100, 381, 360);
		setModal(true);
		setLocationRelativeTo(null); //������â ��� ��� 
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 374, 61);
		contentPanel.setBorder(new LineBorder(new Color(64, 64, 64), 12));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("�� ����");
		lblNewLabel_5.setBounds(5, 5, 357, 51);
		lblNewLabel_5.setFont(new Font("���� ���", Font.BOLD, 20));
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
		
		for(int i=0;i<al.size();i++) //�ش����� ������ŭ ������ ���� ��� 
		{
			JPanel rowPanel = new JPanel(); 
			rowPanel.setPreferredSize(new Dimension(100,110));    
			rowPanel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
			rowPanel.setBackground(Color.white);
			rowPanel.setLayout(null);
			gridpanel.add(rowPanel); 
			
			JLabel jl1 = new JLabel("ID : ");
			jl1.setHorizontalAlignment(SwingConstants.TRAILING);
			jl1.setFont(new Font("���� ���", Font.PLAIN, 12));
			jl1.setBounds(10,8,50,20);
			rowPanel.add(jl1);
			
			JLabel jl2 = new JLabel("Site : ");
			jl2.setHorizontalAlignment(SwingConstants.TRAILING);
			jl1.setFont(new Font("���� ���", Font.PLAIN, 12));

			jl2.setBounds(10,31,50,20);
			rowPanel.add(jl2);
			
			JLabel jl3 = new JLabel("������ : ");
			jl3.setHorizontalAlignment(SwingConstants.TRAILING);
			jl3.setFont(new Font("���� ���", Font.PLAIN, 12));
			jl3.setBounds(10,54,50,20);
			rowPanel.add(jl3);
			
			JLabel jl4 = new JLabel("������ : ");
			jl4.setHorizontalAlignment(SwingConstants.TRAILING);
			jl4.setFont(new Font("���� ���", Font.PLAIN, 12));
			jl4.setBounds(10,77,50,20);
			rowPanel.add(jl4);
			/////////////////////////////////////////////////////
			JLabel jid = new JLabel("zzzz");
			jid.setHorizontalAlignment(SwingConstants.LEFT);
			jid.setFont(new Font("���� ���", Font.PLAIN, 12));
			jid.setBounds(70,8,100,20);
			rowPanel.add(jid);
			
			JLabel jsite = new JLabel("zzzz");
			jsite.setHorizontalAlignment(SwingConstants.LEFT);
			jsite.setFont(new Font("���� ���", Font.PLAIN, 12));
			jsite.setBounds(70,31,100,20);
			rowPanel.add(jsite);
			
			JLabel jname = new JLabel("zzzzz");
			jname.setHorizontalAlignment(SwingConstants.LEFT);
			jname.setFont(new Font("���� ���", Font.PLAIN, 12));
			jname.setBounds(70,54,100,20);
			rowPanel.add(jname);
			
			JLabel jsignup = new JLabel("zzzz");
			jsignup.setHorizontalAlignment(SwingConstants.LEFT);
			jsignup.setFont(new Font("���� ���", Font.PLAIN, 12));
			jsignup.setBounds(70,77,100,20);
			rowPanel.add(jsignup);

			JButton jb = new JButton("��� ����");
			jb.setBackground(Color.DARK_GRAY);
			jb.setFont(new Font("���� ���", Font.PLAIN, 12));
			jb.setForeground(Color.white);
			jb.setBounds(210,5,100,100);
			rowPanel.add(jb);
			
			jid.setText(al.get(i).getPage_id());
			jsite.setText(al.get(i).getWebsitename());
			jname.setText(al.get(i).getPage_name());
			jsignup.setText(al.get(i).getSingupdate());
			int aa= al.get(i).getTem_num();

			
			jb.addMouseListener(new MouseAdapter() { //��ư ���콺 Ŭ���̺�Ʈ
				@Override
				public void mouseClicked(MouseEvent e) {
					 if (e.getClickCount() == 1) { //�ټ��� ���� �� �ش� ���������⸦ ������ �������� �������� �� �� ����. 
						 DetailDialog dd=new DetailDialog(aa); 
						 dd.setVisible(true);
					    } 
				}
			});

	}
	}
}
