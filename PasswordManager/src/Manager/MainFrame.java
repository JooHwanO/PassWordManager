package Manager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import DatabaseQuery.PmUserFind;
import Main.User;	

public class MainFrame {	
	private String resultid;    //최종적으로 로그인한 아이디
	private String resulname; //최종적으로 사용하고있는 PM 이름 ( 패스워드매니저 가입한 이름)    
	private ArrayList<User> mArrayList;
	private DateDiff df = new DateDiff(); //날짜계산
	private PmUserFind us= new PmUserFind();

	// 메인 프레임 
	public  JFrame frame; 
	
	//판넬 선언 
	private HomePanel HomePanel ;
	private SearchPanel SearchPanel;
	private JPanel Menupanel = new JPanel();
	private ManagerPanel ManagerPanel ;
	
	//버튼 선언 (둥근버튼 이클래스 맨밑에 선언되어있음 JButton으로하면되지만 안이뻐서이걸로함 하지만 design에는 표시안됨 할거면 JButton으로 바꾸기

	private final JButton home_but = new  JButton("HOME      ");
	private  JButton search_but = new  JButton("Search      ");
	private  JButton managerbut = new  JButton("  Settings");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame("ghksdh587");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	/*--------------------------------------------------- 데이터베이스 받아오기 --------------------------------------------------*/
	public void DatabaseList() //데이터베이스를 받아오는 메소드
	{
		this.mArrayList=us.user_info_AllSelect(resultid);
		this.resulname = us.PM_name(resultid);
	}
	/*-------------------------------------------------------생성자--------------------------------------------------------------*/
	public MainFrame(String id) {
		resultid=id;
		DatabaseList(); //DB에서 회원정보에대한 모든것을 불러오는 것. 4
		frame_define(); //메인 프레임에 대한 선언들
		Panel_define(); //모든 해당 판넬들 선언
		menu_difine(); //메뉴부분 선언
	}
	
	/*--------------------------------------------------- 홈, 매니저, 서치 판넬 선언 및 설정 --------------------------------------------------*/
	public void Panel_define()
	{
		HomePanel= new HomePanel(resultid);		//home_difine(); //홈선언 
		HomePanel.setBounds(158, 53, 936, 618);
		SearchPanel = new SearchPanel(resultid);
		SearchPanel.tab.setVisible(false);  //탭레이아웃이 버그로 홈에서 보여지기때문에 false로 뒀다가 search버튼이 눌려질때 다시 on 
		ManagerPanel = new ManagerPanel(resultid);
		
		frame.getContentPane().add(HomePanel); //프레임에 홈판넬 추가
		frame.getContentPane().add(SearchPanel); // 프레임에 서치 판넬 추가
		frame.getContentPane().add(ManagerPanel); // 프레임에 매니저 판넬 추가

		//초기화면 설정 
		HomePanel.setVisible(true); //홈판넬이 메인이므로 처음 켰을때 보여지도록 설정 
		SearchPanel.setVisible(false);
		ManagerPanel.setVisible(false);
	}

	
	/*--------------------------------------------------- 프레임 설정 --------------------------------------------------*/
	private void frame_define()
	{
		frame = new JFrame("Password Manager");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/PM.PNG")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.setBounds(100, 100, 1100, 700);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false);                                                    
		frame.getContentPane().setLayout(null);	

		//이름 라벨
		JLabel name_label = new JLabel(resulname+" 님");
		name_label.setBounds(10, 24, 77, 28);
		frame.getContentPane().add(name_label);
		name_label.setForeground(Color.DARK_GRAY);
		name_label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		name_label.setOpaque(true);
		name_label.setBackground(Color.WHITE);
		name_label.setHorizontalAlignment(SwingConstants.LEFT);
		
		//PM 맨위 라벨 
		JLabel PM_Label = new JLabel(" Password Manager");
		PM_Label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		PM_Label.setHorizontalAlignment(SwingConstants.LEFT);
		PM_Label.setBounds(0, 0, 280, 25);
		frame.getContentPane().add(PM_Label);
	}
	
	/*--------------------------------------------------- 메뉴 설정 --------------------------------------------------*/
	private void menu_difine()
	{
		//메뉴 부분 선언 
		Menupanel.setBackground(Color.LIGHT_GRAY);
		Menupanel.setBounds(0, 53, 158, 618);
		Menupanel.setLayout(null);

		frame.getContentPane().add(Menupanel);
		home_but.setForeground(Color.WHITE);
		home_but.setBorder(BorderFactory.createLineBorder(Color.gray)); //버튼에 선안생기게하기

		home_but.setFont(new Font("Dialog", Font.BOLD, 15));
		home_but.setBackground(Color.DARK_GRAY);
		home_but.setBounds(55, 31, 117, 40);
		home_but.setHorizontalAlignment(SwingConstants.RIGHT);
		home_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	DatabaseList();                                                    
				frame.getContentPane().remove(HomePanel);       //갱신된걸 표현하기위해 홈판넬의 모든항목을 지움 
				HomePanel= new HomePanel(resultid);                 //다시 홈판넬 생성 
				frame.getContentPane().add(HomePanel);               // 다시 홈판넬 프레임에 추가 
				frame.revalidate();                                                  //새로고침 같은 기능.     
				frame.repaint();                                                       //다시 그림 
				HomePanel.setVisible(true);                                    //보여지게함 
				SearchPanel.setVisible(false);			                     // 서치판넬, 매니저 판넬은 안보여지게함 
				ManagerPanel.setVisible(false);
				home_but.setBackground(Color.white);                       //버튼누를때마다 색깔 바꾸게 토글됨.
				home_but.setForeground(Color.black);
				search_but.setBackground(Color.DARK_GRAY);
				search_but.setForeground(Color.white);
				managerbut.setBackground(Color.DARK_GRAY);
				managerbut.setForeground(Color.white);
				home_but.setBounds(30, 31, 150, 40);
				home_but.setHorizontalAlignment(SwingConstants.LEFT);
				home_but.setText("   HOME");
				search_but.setHorizontalAlignment(SwingConstants.RIGHT);
				search_but.setText("Search      ");
				search_but.setBounds(55, 81, 117, 40); 
				managerbut.setBounds(55, 130, 117, 40);
				managerbut.setHorizontalAlignment(SwingConstants.CENTER);

			}
		});
		Menupanel.add(home_but);
		search_but.setForeground(Color.WHITE);
		
		
		search_but.setFont(new Font("Dialog", Font.BOLD, 15));
		search_but.setBackground(Color.DARK_GRAY);
		search_but.setHorizontalAlignment(SwingConstants.RIGHT);
		search_but.setBorder(BorderFactory.createLineBorder(Color.gray)); //버튼에 선안생기게하기
		search_but.setBounds(55, 81, 117, 40); //매니저버튼
		search_but.addActionListener(new ActionListener() { //186줄 참조 
			public void actionPerformed(ActionEvent e) {
			//	DatabaseList();
				frame.getContentPane().remove(SearchPanel);
				SearchPanel = new SearchPanel(resultid);
				frame.getContentPane().add(SearchPanel);
				frame.revalidate();
				frame.repaint();
				HomePanel.setVisible(false);
				SearchPanel.setVisible(true);
				SearchPanel.tab.setVisible(true);
				ManagerPanel.setVisible(false);
				home_but.setBackground(Color.DARK_GRAY);
				home_but.setForeground(Color.white);
				search_but.setBackground(Color.white);
				search_but.setForeground(Color.black);
				managerbut.setBackground(Color.DARK_GRAY);
				managerbut.setForeground(Color.white);
				home_but.setBounds(55, 31, 117, 40);
				home_but.setHorizontalAlignment(SwingConstants.RIGHT);
				home_but.setText("HOME      ");
				search_but.setText("  Search");
				search_but.setHorizontalAlignment(SwingConstants.LEFT);
				search_but.setBounds(30, 81, 150, 40);
				managerbut.setBounds(55, 130, 117, 40);
				managerbut.setHorizontalAlignment(SwingConstants.CENTER);

			}
		});
		Menupanel.add(search_but);
		managerbut.setForeground(Color.WHITE);
		
		managerbut.setHorizontalAlignment(SwingConstants.CENTER);
		managerbut.setFont(new Font("Dialog", Font.BOLD, 15));
		managerbut.setBackground(Color.DARK_GRAY); //삽입버튼 
		managerbut.setBorder(BorderFactory.createLineBorder(Color.gray)); //버튼에 선안생기게하기
		managerbut.setBounds(55, 130, 117, 40);
		managerbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //186줄 참조
			//		DatabaseList();
					frame.getContentPane().remove(ManagerPanel);
					ManagerPanel=new ManagerPanel(resultid);
					frame.getContentPane().add(ManagerPanel);
					frame.revalidate();
					frame.repaint();
					HomePanel.setVisible(false);
					SearchPanel.setVisible(false);
					SearchPanel.tab.setVisible(false);
					ManagerPanel.setVisible(true);
					home_but.setBackground(Color.DARK_GRAY);
					home_but.setForeground(Color.white);
					managerbut.setBackground(Color.white);
					managerbut.setForeground(Color.black);
					search_but.setBackground(Color.DARK_GRAY);
					search_but.setForeground(Color.white);
					search_but.setHorizontalAlignment(SwingConstants.RIGHT);
					search_but.setBounds(55, 81, 117, 40); //매니저버튼
					search_but.setText("Search      ");
					home_but.setHorizontalAlignment(SwingConstants.RIGHT);
					home_but.setBounds(55, 31, 117, 40);
					home_but.setText("HOME      ");
					managerbut.setHorizontalAlignment(SwingConstants.LEFT);
					managerbut.setBounds(30, 130, 150, 40);

			}
		});
		Menupanel.add(managerbut);
		
		JLabel PM_ICON = new JLabel(); // 메인 아이콘 
		PM_ICON.setBounds(12, 468, 140, 99);
		Menupanel.add(PM_ICON);
		PM_ICON.setHorizontalAlignment(SwingConstants.CENTER);
		PM_ICON.setIcon(new ImageIcon(MainFrame.class.getResource("/images/66.png")));
		
		JLabel lblNewLabel = new JLabel("Project by. HwanO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		lblNewLabel.setBounds(8, 566, 144, 15);
		Menupanel.add(lblNewLabel);
		
		
		//새로고침 버튼 
		JButton refresh = new JButton();
		refresh.setIcon(new ImageIcon(MainFrame.class.getResource("/images/reload.png")));
		refresh.setBorder(BorderFactory.createLineBorder(Color.white));
		refresh.setBackground(Color.WHITE);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new MainFrame(resultid);
			}
		});
		refresh.setBounds(1033, 12, 49, 40);
		frame.getContentPane().add(refresh);
	}


}


