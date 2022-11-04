package Register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import BasicDialog.Basic;
import DatabaseQuery.RegisterIDCheck;

import java.awt.SystemColor;

public class Register_Dialog extends JDialog  {
	private final JPanel main_panel = new JPanel();
	private final JPanel buttonPane = new JPanel();
	private JTextField id_insert;
	private JTextField name_insert;
	private JPasswordField pw_insert;
	private JPasswordField check_insert;
	private JTextField ph_insert1;
	private JTextField ph_insert2;
	private JTextField ph_insert3;
	private Basic bc = null;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
		Register_Dialog dialog = new Register_Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null); //윈도우창 가운데 띄움 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public Register_Dialog() {
		setTitle("PasswordManager");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(main_panel);
		setBounds(100, 100, 450, 529);
	
		main_panel.setBackground(Color.DARK_GRAY);
		main_panel.setBounds(2, 69, 431, 356);
		main_panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		main_panel.setLayout(null);


		RegisterCondition Con= new RegisterCondition(); //아이디, 비번 조건값 검사 클래스 객체 생성 

		JLabel title_lable = new JLabel("Registeration Form"); //메인 타이틀 제목 
		
		//ID 부분 선언 
		JLabel id_label = new JLabel("ID :");                          
		id_insert = new JTextField();
		JButton id_che_but = new JButton("Check Availability");

		//pw 부분 선언 
		JLabel pw_label = new JLabel("PW :");
		pw_insert = new JPasswordField();
		check_insert = new JPasswordField();
		JLabel ch_label = new JLabel("CHECK :");

		//전화번호 부분 선언 
		ph_insert1 = new JTextField();
		ph_insert1.setForeground(Color.WHITE);
		ph_insert1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ph_insert1.setText("010");

		//이름 부분 선언 
		JLabel name_label = new JLabel("NAME :");
		name_insert = new JTextField();
		name_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		JLabel ph_label = new JLabel("PHONE :");
		JButton okButton = new JButton("OK");
		JLabel pw_c_label = new JLabel("비밀번호를 입력해주세요");
		
		JLabel confirm = new JLabel("비밀번호를 확인해 주세요");
		confirm.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		confirm.setForeground(Color.WHITE);
		confirm.setBackground(Color.WHITE);
		confirm.setBounds(266, 170, 153, 25);

		JLabel id_c_label = new JLabel("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		JButton cancelButton = new JButton("Cancel");
		main_panel.add(confirm);
		
		// --------------------------------------- Title
		{

			title_lable.setFont(new Font("Microsoft JhengHei", Font.BOLD, 30));
			title_lable.setHorizontalAlignment(SwingConstants.CENTER);
			title_lable.setBounds(71, 10, 282, 49);
			getContentPane().add(title_lable);
		}
		
		// --------------------------------------- ID
		{
			id_label.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
			id_label.setForeground(Color.WHITE);
			id_label.setHorizontalAlignment(SwingConstants.CENTER);
			id_label.setBounds(25, 25, 70, 35);
			main_panel.add(id_label);
		}
		{
			id_insert.setHorizontalAlignment(SwingConstants.CENTER);
			id_insert.setBounds(104, 25, 150, 35);
			main_panel.add(id_insert);
			id_insert.setColumns(10);
			id_insert.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent e)
				{
					if(id_insert.getText().toString().length()<=0) // ID값 공백확인후 비밀번호칸 닫기
					{
						id_c_label.setForeground(Color.white);
						id_c_label.setText("아이디를 입력해주세요");
						pw_insert.setEnabled(false);
						pw_insert.setBackground(new Color(100,100,100));
						pw_insert.setText("");
					}
				}});
			}
		id_che_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(Con.ID_condition(id_insert.getText())) //아이디가 정규값과 맞다면 
						{
							RegisterIDCheck ic= new RegisterIDCheck();  //아이디검사 클래스 객체 생성
							if(ic.id_check(id_insert.getText().toString())==1)  // 아이디 검사시 1이라면 존재하는 경우이다.
							{
								id_c_label.setForeground(Color.red);
								id_c_label.setText("이미 아이디가 존재합니다.");
							}
							else if(ic.id_check(id_insert.getText().toString())==2) //2라면 존재하지 않는 경우 즉 해당 아이디 사용가능 
							{
								pw_insert.setEnabled(true);
								pw_insert.setBackground(new Color(255,255,255));
								id_c_label.setForeground(Color.green);
								id_c_label.setText("사용가능합니다");
								id_insert.setEnabled(false);
								id_insert.setBackground(new Color(100,100,100));
							}
							else
							{
								Basic ba = new  Basic("서버 에러 오류");
								ba.setVisible(true);
							}
						}
						else
						{
							id_c_label.setText("영문, 숫자 조합 8~12자리로 아이디를 생성하세요");
							id_c_label.setForeground(Color.red);
							pw_insert.setEnabled(false);
							pw_insert.setBackground(new Color(100,100,100));
						}
				}
		});
		id_che_but.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		id_che_but.setBackground(Color.LIGHT_GRAY);
		id_che_but.setBounds(266, 25, 155, 35);
		main_panel.add(id_che_but);

		
		// --------------------------------------- PW
		pw_insert.setBounds(104, 97, 150, 35);
		pw_insert.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				if(Con.Password_condition(pw_insert.getText())) //패스워드 값이 정규값과 맞다면 
				{
					check_insert.setEnabled(true);
					check_insert.setBackground(new Color(255,255,255));
					pw_c_label.setText("가능합니다.");
					pw_c_label.setForeground(Color.green);
				}
				else if(pw_insert.getText().toString().length()<=0) //공백일 경우 
				{
					check_insert.setEnabled(false);
					check_insert.setBackground(new Color(100,100,100));
					pw_c_label.setText("비밀번호를 입력하세요");
					pw_c_label.setForeground(Color.white);
					check_insert.setText("");
					name_insert.setEnabled(false);
					ph_insert1.setEnabled(false);
					ph_insert2.setEnabled(false);
					ph_insert3.setEnabled(false);
					name_insert.setBackground(new Color(100,100,100));
					ph_insert1.setBackground(new Color(100,100,100));
					ph_insert2.setBackground(new Color(100,100,100));
					ph_insert3.setBackground(new Color(100,100,100));
					confirm.setText("비밀번호를 확인해 주세요");
					confirm.setForeground( Color.white);
				}
				else
				{
					check_insert.setEnabled(false);
					check_insert.setBackground(new Color(100,100,100));
					pw_c_label.setText("영문, 특문, 숫자 조합하여 8~12자리를입력하세요");
				}
			}
		});
		
		main_panel.add(pw_insert);
		check_insert.setBounds(104, 165, 150, 35);
		check_insert.addKeyListener(new KeyAdapter()
				{
					@SuppressWarnings("unlikely-arg-type")
					public void keyReleased(KeyEvent e)
					{
						@SuppressWarnings("deprecation")
						String pw = pw_insert.getText().toString();
						String pw2 = check_insert.getText().toString();
						if(pw.length()<=0 ||pw2.length()<=0) //공백일 경우 
						{
							confirm.setText("비밀번호를 확인해 주세요");
							confirm.setForeground( Color.white);
							name_insert.setEnabled(false);
							ph_insert1.setEnabled(false);
							ph_insert2.setEnabled(false);
							ph_insert3.setEnabled(false);
							name_insert.setBackground(new Color(100,100,100));
							ph_insert1.setBackground(new Color(100,100,100));
							ph_insert2.setBackground(new Color(100,100,100));
							ph_insert3.setBackground(new Color(100,100,100));

						}
						else if(pw.equals(pw2))
						{
							confirm.setText("비밀번호가 일치합니다.");
							confirm.setForeground( Color.green);
							name_insert.setEnabled(true);
							ph_insert1.setEnabled(true);
							ph_insert2.setEnabled(true);
							ph_insert3.setEnabled(true);

							name_insert.setBackground(new Color(255,255,255));
							ph_insert1.setBackground(new Color(255,255,255));
							ph_insert2.setBackground(new Color(255,255,255));
							ph_insert3.setBackground(new Color(255,255,255));
							ph_insert1.setForeground(Color.black);

						}
						else
						{
							confirm.setText("비밀번호가 일치하지 않습니다.");
							confirm.setForeground( new Color(255,0,0));
							name_insert.setEnabled(false);
							ph_insert1.setEnabled(false);
							ph_insert2.setEnabled(false);
							ph_insert3.setEnabled(false);
							name_insert.setBackground(new Color(100,100,100));
							ph_insert1.setBackground(new Color(100,100,100));
							ph_insert2.setBackground(new Color(100,100,100));
							ph_insert3.setBackground(new Color(100,100,100));

						}
						
					}

				});

		main_panel.add(check_insert);
		{
			pw_label.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
			pw_label.setForeground(Color.WHITE);
			pw_label.setHorizontalAlignment(SwingConstants.CENTER);
			pw_label.setBounds(25, 95, 70, 35);
			main_panel.add(pw_label);
		}
		{
			ch_label.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
			ch_label.setForeground(Color.WHITE);
			ch_label.setHorizontalAlignment(SwingConstants.CENTER);
			ch_label.setBounds(25, 165, 70, 35);
			main_panel.add(ch_label);
			
		}
		
		// --------------------------------------- NAME

		{
			name_insert.setHorizontalAlignment(SwingConstants.CENTER);
			name_insert.setColumns(10);
			name_insert.setBounds(104, 235, 150, 35);
			main_panel.add(name_insert);
		}
		{
			name_label.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
			name_label.setForeground(Color.WHITE);
			name_label.setHorizontalAlignment(SwingConstants.CENTER);
			name_label.setBounds(25, 235, 70, 35);
			main_panel.add(name_label);
		}
		
		// --------------------------------------- PHONE
		{
			ph_insert1.setHorizontalAlignment(SwingConstants.CENTER);
			ph_insert1.setColumns(10);
			ph_insert1.setBounds(104, 305, 57, 35);

			ph_insert1.setEnabled(false);
			ph_insert1.setBackground(new Color(100,100,100));
			ph_insert1.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	            		char caracter = e.getKeyChar();
	            		JTextField src = (JTextField) e.getSource();
	            		if(src.getText().length()>=3) e.consume();               //글수 제한 
	                    if (((caracter < '0') || (caracter > '9'))&& (caracter != '\b')) e.consume(); // 숫자만 입력가능
	            	}});
			main_panel.add(ph_insert1);
		}
		{
		ph_insert2 = new JTextField();
		ph_insert2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ph_insert2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            		char caracter = e.getKeyChar();
            		JTextField src = (JTextField) e.getSource();
            		if(src.getText().length()>=4) e.consume();  //글수 제한 
                    if (((caracter < '0') || (caracter > '9'))&& (caracter != '\b')) e.consume(); // 숫자만 입력가능 
            	}});

		ph_insert2.setHorizontalAlignment(SwingConstants.CENTER);
		ph_insert2.setEnabled(false);
		ph_insert2.setColumns(10);
		ph_insert2.setBackground(SystemColor.windowBorder);
		ph_insert2.setBounds(184, 305, 57, 35);
		main_panel.add(ph_insert2);
		}
		{
		ph_insert3 = new JTextField();
		ph_insert3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ph_insert3.setHorizontalAlignment(SwingConstants.CENTER);
		ph_insert3.setEnabled(false);
		ph_insert3.setColumns(10);
		ph_insert3.setBackground(SystemColor.windowBorder);
		ph_insert3.setBounds(264, 305, 57, 35);
		ph_insert3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            		char caracter = e.getKeyChar();
            		JTextField src = (JTextField) e.getSource();
            		if(src.getText().length()>=4) e.consume(); //글수 제한 
                    if (((caracter < '0') || (caracter > '9'))&& (caracter != '\b')) e.consume(); // 숫자만 입력가능 
            	}});

		main_panel.add(ph_insert3);
		}
		{
			ph_label.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
			ph_label.setForeground(Color.WHITE);
			ph_label.setHorizontalAlignment(SwingConstants.CENTER);
			ph_label.setBounds(25, 305, 70, 35);
			main_panel.add(ph_label);
		}
		



		// ---------------------------------------확인 버튼 
		{

			buttonPane.setForeground(Color.WHITE);
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
			buttonPane.setBounds(3, 430, 430, 60);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				okButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				okButton.setBackground(Color.LIGHT_GRAY);
				okButton.setBounds(265, 10, 64, 40);
				okButton.setActionCommand("OK");
				okButton.setEnabled(true);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							if(id_insert.getText().toString().length()>0&&check_insert.getText().toString().length()>0&&name_insert.getText().toString().length()>0&&ph_insert1.getText().toString().length()>0&&ph_insert2.getText().toString().length()>0&&ph_insert3.getText().toString().length()>0)
							{
								
								RegisterComplite RC=new RegisterComplite(id_insert.getText().toString(),check_insert.getText().toString(),name_insert.getText().toString(),
										ph_insert1.getText().toString(),ph_insert2.getText().toString(),ph_insert3.getText().toString()); //한번더 확인하는 다이얼로그 생성
								RC.setVisible(true);
								if(RC.getOk()==1) //한 번더 확인하는 다이얼로그에서 확인이 눌러졌을경우 1이되며 회원정보가 DB로 넘어가고 이창을 닫게한다.
								{
									dispose();
								}
							}
							else
							{
								bc = new Basic("공백이 있습니다.");
								bc.setVisible(true);
						//JOptionPane.showMessageDialog(null, "공백이 있습니다.","Message",JOptionPane.INFORMATION_MESSAGE);
							}
						
					}
				});

			}
			{

				cancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				cancelButton.setBackground(Color.LIGHT_GRAY);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					
					}
				});
				
				cancelButton.setBounds(340, 10, 76, 40);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 2, 3, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(3, 0, 430, 70);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

	
		//초기값 
		pw_insert.setEnabled(false);
		pw_insert.setBackground(new Color(100,100,100));

		check_insert.setEnabled(false);
		check_insert.setBackground(new Color(100,100,100));

		name_insert.setEnabled(false);
		name_insert.setBackground(new Color(100,100,100));



		
		//하이픈 부분 (전화번호의 ㅡ 부분)
		JLabel hipen = new JLabel("\u3161");
		hipen.setHorizontalAlignment(SwingConstants.CENTER);
		hipen.setForeground(Color.WHITE);
		hipen.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		hipen.setBackground(Color.WHITE);
		hipen.setBounds(162, 310, 20, 25);
		main_panel.add(hipen);
		
		JLabel hipen2 = new JLabel("\u3161");
		hipen2.setHorizontalAlignment(SwingConstants.CENTER);
		hipen2.setForeground(Color.WHITE);
		hipen2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		hipen2.setBackground(Color.WHITE);
		hipen2.setBounds(242, 310, 20, 25);
		main_panel.add(hipen2);
		
		
		pw_c_label.setForeground(Color.WHITE);
		pw_c_label.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		pw_c_label.setBackground(Color.WHITE);
		pw_c_label.setBounds(104, 128, 254, 25);
		main_panel.add(pw_c_label);
		
		id_c_label.setForeground(Color.WHITE);
		id_c_label.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		id_c_label.setBackground(Color.WHITE);
		id_c_label.setBounds(104, 59, 254, 25);
		main_panel.add(id_c_label);
		
		setModal(true); //모달형태의 다이얼로그
		setLocationRelativeTo(null); //윈도우창 가운데 띄움 
		setResizable(false);   //크기조절못하게     
	}
}
