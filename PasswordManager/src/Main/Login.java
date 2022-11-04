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
					Thread_label();  //라벨 움직임 
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
				// TODO 자동 생성된 메소드 스텁
				log_panel.setVisible(true); 
			}};
		ti.schedule(tit, 1700);	//해당 시간뒤에 login(id,pw)칠 수 있는 로그판넬이 등장 
	
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		log_panel.setBorder(new LineBorder(Color.BLACK, 3));
		log_panel.setVisible(false); //로그인 가능 판넬 비활성화
		Pull_panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		Pull_panel.setBackground(Color.WHITE);
		Pull_panel.setBounds(0, 0, 486, 363);
		Pull_panel.setLayout(null);
		Pull_panel.add(login_label);
		
		frmPasswordmanager = new JFrame();
		frmPasswordmanager.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/PM.PNG")));
		frmPasswordmanager.setTitle("PasswordManager");					//타이틀 이름 
		frmPasswordmanager.getContentPane().setBackground(Color.WHITE); //배경색 
		frmPasswordmanager.getContentPane().setLayout(null);

		frmPasswordmanager.getContentPane().add(log_panel);
		frmPasswordmanager.getContentPane().add(Pull_panel);

		frmPasswordmanager.setBounds(0, 0, 500, 400);
		frmPasswordmanager.setLocationRelativeTo(null); //윈도우창 가운데 띄움 

		frmPasswordmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램 종료되게
		frmPasswordmanager.setResizable(false);                                                    //크기조절 못하게 
		
		log_panel.setBackground(Color.DARK_GRAY);
		//log_panel.setBounds(0, 100,600, 300);
		log_panel.setLocation(0,98);
		log_panel .setSize(486,265);
		log_panel.setLayout(null);
		log_panel.add(id_Insert);
		login_but.setBorder(BorderFactory.createLineBorder(Color.gray));               //버튼에 선안생기게하기
		
		login_but.addActionListener(new ActionListener() {                                 //로그인 버튼 
			public void actionPerformed(ActionEvent e) {
				LoginConfirm lc =new LoginConfirm();
				String pw_c=pw_insert.getText().toString();
				if(id_Insert.getText().toString().equals("") ||pw_c.equals("")){               //공백일 경우 메시지 처리
						bc = new Basic("아이디나 비밀번호를 입력해주세요");
						bc.setVisible(true);
					}
				else
				{
					if(1==lc.login_confirm(id_Insert.getText().toString(), pw_c)) //로그인이 가능한경우 즉 아이디, 비번이 맞을 경우 
					{
						MainFrame mf = new MainFrame(id_Insert.getText().toString() ); //메인창 띄움 
						frmPasswordmanager.dispose(); //로그인창 종료 
						mf.frame.setVisible(true); 
					}
					else if(2==lc.login_confirm(id_Insert.getText().toString(), pw_c)) //맞지 않을 경우 
					{
						bc = new Basic("아이디, 비밀번호를 다시 확인해주세요");
						bc.setVisible(true);

					}
					else  //서버연결이 안되오류나는 경우 ==3일 경우임
					{
						bc = new Basic("서버 연결 오류.");
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
		register_but.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		register_but.addActionListener(new ActionListener() { //회원가입 버튼 
			public void actionPerformed(ActionEvent e) {
				   Register_Dialog dialog = new Register_Dialog();
				   dialog.setVisible(true);
			}
		});
		log_panel.add(register_but);
		
		ld_text.setForeground(Color.WHITE);
		ld_text.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
		ld_text.setHorizontalAlignment(SwingConstants.CENTER);
		ld_text.setBounds(30, 80, 33, 36);

		id_Insert.setForeground(Color.DARK_GRAY);
		id_Insert.setColumns(10);
		id_Insert.setBounds(75, 83, 143, 36);
		id_Insert.setHorizontalAlignment(SwingConstants.LEFT);

		pw_text.setForeground(Color.WHITE);
		pw_text.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
		pw_text.setHorizontalAlignment(SwingConstants.CENTER);
		pw_text.setBounds(30, 180, 33, 36);
		
		pw_insert.setBounds(75, 180, 143, 36);

		login_but.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		login_but.setBackground(Color.LIGHT_GRAY);
		login_but.setBounds(242, 83, 94, 133);
		

		
		ImageIcon i = new ImageIcon("C:\\Users\\JooHwanO\\Desktop\\main.png");
		Image im = i.getImage(); //뽑아온 이미지 객체 사이즈를 새롭게 만들기!
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
					    login_label.setLocation(93, x); //초기위치 
						try {
							Thread.sleep(1000L); //초기에 잠시 멈추는 시간
							while(x>=32)
							{
								login_label.setLocation(93, x);
								x-=8; //0.02초마다 8씩 이동 
								Thread.sleep(20L); //0.02초 설정
							}
						} catch (InterruptedException e) {
							// TODO 자동 생성된 catch 블록
							e.printStackTrace();
						}
						
						}
				}.start();
	}

}

