package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.DefaultMenuLayout;

import BasicDialog.Basic;
import DatabaseQuery.LoginConfirm;
import Manager.MainFrame;
import Register.Register_Dialog;

import java.awt.Font;
import java.awt.Image;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login  {

	private JFrame frmPasswordmanager;
	private  JLabel ld_text = new JLabel("ID");
	private  JLabel pw_text = new JLabel("PW");
	private  JPanel log_panel = new JPanel();
	private  JTextField id_Insert = new JTextField();
	private  JButton login_but = new JButton("Login");
	private  JPanel Pull_panel = new JPanel();
	private  JButton register_but = new JButton("Register");
	private  JPasswordField pw_insert = new JPasswordField();
	public static JLabel login_label = new JLabel("Password Manager");
	public static Basic bc = null;
	String resulid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					Thread_label();  //�� ������ 
					window.frmPasswordmanager.setVisible(true);
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public Login()  {
		initialize();
		Timer ti =new Timer();
		TimerTask tit = new TimerTask() {
			@Override
			public void run() {
				// TODO �ڵ� ������ �޼ҵ� ����
				log_panel.setVisible(true); 
			}};
		ti.schedule(tit, 1700);	//�ش� �ð��ڿ� login(id,pw)ĥ �� �ִ� �α��ǳ��� ���� 
	
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		log_panel.setBorder(new LineBorder(Color.BLACK, 3));
		log_panel.setVisible(false); //�α��� ���� �ǳ� ��Ȱ��ȭ
		Pull_panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		Pull_panel.setBackground(Color.WHITE);
		Pull_panel.setBounds(0, 0, 486, 363);
		Pull_panel.setLayout(null);
		Pull_panel.add(login_label);
		
		frmPasswordmanager = new JFrame();
		frmPasswordmanager.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/PM.PNG")));
		frmPasswordmanager.setTitle("PasswordManager");					//Ÿ��Ʋ �̸� 
		frmPasswordmanager.getContentPane().setBackground(Color.WHITE); //���� 
		frmPasswordmanager.getContentPane().setLayout(null);

		frmPasswordmanager.getContentPane().add(log_panel);
		frmPasswordmanager.getContentPane().add(Pull_panel);

		frmPasswordmanager.setBounds(0, 0, 500, 400);
		frmPasswordmanager.setLocationRelativeTo(null); //������â ��� ��� 

		frmPasswordmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���α׷� ����ǰ�
		frmPasswordmanager.setResizable(false);                                                    //ũ������ ���ϰ� 
		
		log_panel.setBackground(Color.DARK_GRAY);
		//log_panel.setBounds(0, 100,600, 300);
		log_panel.setLocation(0,98);
		log_panel .setSize(486,265);
		log_panel.setLayout(null);
		log_panel.add(id_Insert);
		login_but.setBorder(BorderFactory.createLineBorder(Color.gray));               //��ư�� ���Ȼ�����ϱ�
		
		login_but.addActionListener(new ActionListener() {                                 //�α��� ��ư 
			public void actionPerformed(ActionEvent e) {
				LoginConfirm lc =new LoginConfirm();
				String pw_c=pw_insert.getText().toString();
				if(id_Insert.getText().toString().equals("") ||pw_c.equals("")){               //������ ��� �޽��� ó��
						bc = new Basic("���̵� ��й�ȣ�� �Է����ּ���");
						bc.setVisible(true);
					}
				else
				{
					if(1==lc.login_confirm(id_Insert.getText().toString(), pw_c)) //�α����� �����Ѱ�� �� ���̵�, ����� ���� ��� 
					{
						MainFrame mf = new MainFrame(id_Insert.getText().toString() ); //����â ��� 
						frmPasswordmanager.dispose(); //�α���â ���� 
						mf.frame.setVisible(true); 
					}
					else if(2==lc.login_confirm(id_Insert.getText().toString(), pw_c)) //���� ���� ��� 
					{
						bc = new Basic("���̵�, ��й�ȣ�� �ٽ� Ȯ�����ּ���");
						bc.setVisible(true);

					}
					else  //���������� �ȵǿ������� ��� ==3�� �����
					{
						bc = new Basic("���� ���� ����.");
						bc.setVisible(true);

					}
				}
			}
		});
		log_panel.add(login_but);
		log_panel.add(pw_text);
		ld_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		log_panel.add(ld_text);
		log_panel.add(pw_insert);
		register_but.setFont(new Font("���� ���", Font.PLAIN, 13));
		register_but.addActionListener(new ActionListener() { //ȸ������ ��ư 
			public void actionPerformed(ActionEvent e) {
				   Register_Dialog dialog = new Register_Dialog();
				   dialog.setVisible(true);
			}
		});
		log_panel.add(register_but);
		
		ld_text.setForeground(Color.WHITE);
		ld_text.setFont(new Font("���ʷҵ���", Font.PLAIN, 14));
		ld_text.setHorizontalAlignment(SwingConstants.CENTER);
		ld_text.setBounds(30, 80, 33, 36);

		id_Insert.setForeground(Color.DARK_GRAY);
		id_Insert.setColumns(10);
		id_Insert.setBounds(75, 83, 143, 36);
		id_Insert.setHorizontalAlignment(SwingConstants.LEFT);

		pw_text.setForeground(Color.WHITE);
		pw_text.setFont(new Font("���ʷҵ���", Font.PLAIN, 14));
		pw_text.setHorizontalAlignment(SwingConstants.CENTER);
		pw_text.setBounds(30, 180, 33, 36);
		
		pw_insert.setBounds(75, 180, 143, 36);

		login_but.setFont(new Font("���� ���", Font.PLAIN, 14));
		login_but.setBackground(Color.LIGHT_GRAY);
		login_but.setBounds(242, 83, 94, 133);
		

		
		ImageIcon i = new ImageIcon("C:\\Users\\JooHwanO\\Desktop\\main.png");
		Image im = i.getImage(); //�̾ƿ� �̹��� ��ü ����� ���Ӱ� �����!
		Image im2 = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		Image imgTarget = im2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(imgTarget);
		register_but.setBackground(Color.LIGHT_GRAY);
		register_but.setBounds(364, 83, 94, 131);

		login_label.setBounds(93, 162, 300, 45);
		login_label.setHorizontalAlignment(SwingConstants.CENTER);
		login_label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 30));
		
	}
	
	
	public static void Thread_label()
	{
		 new  Thread()
		{	
					public void run()
					{
						int x= 162 ;
					    login_label.setLocation(93, x); //�ʱ���ġ 
						try {
							Thread.sleep(1000L); //�ʱ⿡ ��� ���ߴ� �ð�
							while(x>=32)
							{
								login_label.setLocation(93, x);
								x-=8; //0.02�ʸ��� 8�� �̵� 
								Thread.sleep(20L); //0.02�� ����
							}
						} catch (InterruptedException e) {
							// TODO �ڵ� ������ catch ���
							e.printStackTrace();
						}
						
						}
				}.start();
	}

}

