package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import BasicDialog.Basic;
import DatabaseQuery.DeleteQuery;
import DatabaseQuery.ModifyQuery;
import DatabaseQuery.NewInsertQuery;
import DatabaseQuery.PmUserFind;
import Main.User;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ManagerPanel extends JPanel {
	/*modify에 사용되는 변수*/
	private String resultid;
	private JTextField id_insert;
	private JTextField pw_insert;
	private JTextField name_insert;
	private JTextField mail_insert;
	private JTextField division_insert;
	private  JTextField addre_insert;
	private JTextField pagename_insert;
	private JLabel no_insert ;
	private JLabel no_la_insert;
	private JTextArea remarks_insert;
	
	/*delete에 사용되는 변수 */
	private JLabel id_la_insert ;
	private JLabel pw_la_insert ;
	private JLabel  name_la_insert ;
	private JLabel mail_la_insert ;
	private JLabel signup_la_insert ;
	private JLabel  division_la_insert ;
	private JLabel add_la_insert ;
	private JLabel pagename_la_insert ;
	private JTextArea remarks_la_insert;
	
	private JTabbedPane tabb;
	private TabDataSelect tds ;	
	
	private ArrayList<User> mArrayList;
	private PmUserFind mppf = new PmUserFind();
	private List<String> combobox_tabmenu = new ArrayList<String>();
	private JFrame frame;
	private RoundedButton submit; //제출 버튼 
	
	// date picker 설정 
	private UtilDateModel model ;
	private JDatePanelImpl datePanel ;
	private JDatePickerImpl datePicker ;
	
	 JPanel mpanel ;
	 
	public ManagerPanel(String resultid ) {
		this.resultid=resultid;
		this.mArrayList = mppf.user_info_AllSelect(resultid);
		setBackground(Color.DARK_GRAY);
		setBounds(158, 53, 936, 618);
		setLayout(null);
		Table_display(); //오른쪽 
		tab_display();		//왼쪽
		tab_setting(); 	//탭 선택 액션 
	}
	void Table_display() //오른쪽 검색 테이블 생성
	{
		mpanel = new JPanel();
		mpanel.setBackground(Color.WHITE);
		mpanel.setBounds(310, 30, 614, 555);
		add(mpanel);
		mpanel.setLayout(null);

		tds= new TabDataSelect("All",resultid); //모든정보 테이블 생성 
		tds.setBounds(0,0,614,560);
		tds.scroll.setBounds(25, 85, 550,470);  //스크롤 재설정 
		tds.setVisible(true);
		mpanel.add(tds);
	}
	
	void tab_display()
	{
		tabb= new JTabbedPane(JTabbedPane.TOP);
		tabb.setBackground(Color.ORANGE);
		tabb.setForeground(Color.BLACK);
		tabb.setBounds(19, 10, 279, 575);
		add(tabb);
		insert_setting();
		modify_setting();
		delete_setting();
	}
	
	
	//////////////////////////////////////////////////////////////////////////////새정보 삽입 /////////////////////////////////////////////////////////////////////////////////////////////////////
	private void insert_setting()
	{
		JPanel insertPanel = new JPanel();
		insertPanel.setBackground(Color.DARK_GRAY);
		insertPanel.setBounds(279, 49, 408, 474);
		insertPanel.setLayout(null);
		tabb.add("New", insertPanel); 

		JLabel top_label = new JLabel("New Information");
		top_label.setForeground(Color.WHITE);
		top_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		top_label.setHorizontalAlignment(SwingConstants.CENTER);
		top_label.setBounds(12, 10, 250, 27);
		insertPanel.add(top_label);
		
		JLabel Id_lable = new JLabel("ID :");
		Id_lable.setForeground(Color.WHITE);
		Id_lable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		Id_lable.setHorizontalAlignment(SwingConstants.LEFT);
		Id_lable.setBounds(12, 60, 48, 25);
		insertPanel.add(Id_lable);
		
		JLabel pw_lable = new JLabel("PW :");
		pw_lable.setForeground(Color.WHITE);
		pw_lable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pw_lable.setHorizontalAlignment(SwingConstants.LEFT);
		pw_lable.setBounds(12, 100, 48, 25);
		insertPanel.add(pw_lable);
		
		JLabel nambe_label = new JLabel("Name :");
		nambe_label.setForeground(Color.WHITE);
		nambe_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		nambe_label.setHorizontalAlignment(SwingConstants.LEFT);
		nambe_label.setBounds(12, 140, 48, 25);
		insertPanel.add(nambe_label);
		
		JLabel mail_label = new JLabel("e-mail :");
		mail_label.setForeground(Color.WHITE);
		mail_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		mail_label.setHorizontalAlignment(SwingConstants.LEFT);
		mail_label.setBounds(12, 180, 48, 25);
		insertPanel.add(mail_label);
		
		JLabel singup_label = new JLabel("\uAC00\uC785\uC77C :");
		singup_label.setForeground(Color.WHITE);
		singup_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		singup_label.setHorizontalAlignment(SwingConstants.LEFT);
		singup_label.setBounds(12, 220, 51, 25);
		insertPanel.add(singup_label);
		
		JLabel division_label = new JLabel("\uBD84\uB958 :");
		division_label.setForeground(Color.WHITE);
		division_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		division_label.setHorizontalAlignment(SwingConstants.LEFT);
		division_label.setBounds(12, 260, 48, 25);
		insertPanel.add(division_label);
		
		JLabel addre_label = new JLabel("\uC8FC\uC18C :");
		addre_label.setForeground(Color.WHITE);
		addre_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		addre_label.setHorizontalAlignment(SwingConstants.LEFT);
		addre_label.setBounds(12, 300, 51, 25);
		insertPanel.add(addre_label);
		
		JLabel pagename_label = new JLabel("\uD398\uC774\uC9C0 \uC774\uB984 :");
		pagename_label.setForeground(Color.WHITE);
		pagename_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pagename_label.setHorizontalAlignment(SwingConstants.LEFT);
		pagename_label.setBounds(12, 340, 78, 25);
		insertPanel.add(pagename_label);
		
		JTextField id_inserts = new JTextField();
		id_inserts.setHorizontalAlignment(SwingConstants.CENTER);
		id_inserts.setBounds(68, 60, 130, 25);
		insertPanel.add(id_inserts);
		id_inserts.setColumns(10);
		
		JTextField pw_inserts = new JTextField();
		pw_inserts.setHorizontalAlignment(SwingConstants.CENTER);
		pw_inserts.setColumns(10);
		pw_inserts.setBounds(68, 100, 130, 25);
		insertPanel.add(pw_inserts);
		
		JTextField name_inserts = new JTextField();
		name_inserts.setHorizontalAlignment(SwingConstants.CENTER);
		name_inserts.setColumns(10);
		name_inserts.setBounds(68, 140, 130, 25);
		insertPanel.add(name_inserts);
		
		JTextField mail_inserts = new JTextField();
		mail_inserts.setColumns(10);
		mail_inserts.setBounds(68, 180, 183, 25);
		insertPanel.add(mail_inserts);
		
		distinct_combobox();
		String CBmenu_1[]= combobox_tabmenu.toArray(new String[combobox_tabmenu.size()]);   
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(CBmenu_1);
		
		JTextField division_inserts = new JTextField();
		division_inserts.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		division_inserts.setEnabled(false);
		division_inserts.setBackground(Color.gray);
		division_inserts.setText(comboBox.getSelectedItem().toString());
		if(comboBox.getSelectedItem().toString().equals("직접입력"))
		{
			division_inserts.setText("");
			division_inserts.setEnabled(true);
			division_inserts.setBackground(Color.white);
		}
		
		
		//콤보박스 선택될때 액션 
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("직접입력"))
				{
					division_inserts.setText("");
					division_inserts.setEnabled(true);
					division_inserts.setBackground(Color.white);
					division_inserts.setForeground(Color.black);

				}
				else
				{
					division_inserts.setEnabled(false);
					division_inserts.setBackground(Color.gray);
					division_inserts.setText(comboBox.getSelectedItem().toString());
				}
			}
		});
		comboBox.setBounds(165, 263, 86, 23);
		insertPanel.add(comboBox);
		
		division_inserts.setColumns(10);
		division_inserts.setBounds(68, 260, 85, 25);
		insertPanel.add(division_inserts);
		
		JTextField addre_inserts = new JTextField();
		addre_inserts.setColumns(10);
		addre_inserts.setBounds(68, 300, 183, 25);
		insertPanel.add(addre_inserts);
		
		JTextField pagename_inserts = new JTextField();
		pagename_inserts.setHorizontalAlignment(SwingConstants.CENTER);
		pagename_inserts.setColumns(10);
		pagename_inserts.setBounds(102, 339, 149, 25);
		insertPanel.add(pagename_inserts);
		
		UtilDateModel models = new UtilDateModel();
		JDatePanelImpl datePanels = new JDatePanelImpl(models);
		JDatePickerImpl datePickers = new JDatePickerImpl(datePanels,new DateLabelFormatter());

		//날짜 고르게 설정할 수 잇는 date Picker
		datePickers.getJFormattedTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		datePickers.getJFormattedTextField().setForeground(Color.WHITE);
		SpringLayout springLayouts = (SpringLayout) datePickers.getLayout();
		datePickers.getJFormattedTextField().setBackground(Color.GRAY); //색깔바꿀때 이렇게 바꿔야함 
		datePickers.setBounds(68,220,130,25);
		insertPanel.add(datePickers);

		JPanel panel = new JPanel(); //꾸미기용  판넬 신경쓸필요없음 (주황색 선을 나타냄 )
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 200, 0)));
		panel.setBounds(10, 15, 252, 27);
		insertPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel(); //꾸미기용 판넬 신경쓸필요없음 (주황색선을 나타냄 )
		panel_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 200, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 478, 252, 3);
		insertPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel remarks_label = new JLabel("\uAE30\uD0C0 \uC815\uBCF4 :");
		remarks_label.setHorizontalAlignment(SwingConstants.LEFT);
		remarks_label.setForeground(Color.WHITE);
		remarks_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		remarks_label.setBounds(12, 375, 78, 25);
		insertPanel.add(remarks_label);
		
		JScrollPane remar_scroll_insert = new JScrollPane();
		remar_scroll_insert.setBounds(84, 383, 167, 85);
		insertPanel.add(remar_scroll_insert);
		JTextArea remarks_insert = new JTextArea();
		remar_scroll_insert.setViewportView(remarks_insert);
	
		RoundedButton submits = new RoundedButton("Submit");
		submits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String page_id = id_inserts.getText().toString();
				String page_password = pw_inserts.getText().toString();
				String page_name = name_inserts.getText().toString();
				String  page_email= mail_inserts.getText().toString();
				String select_new_date =models.getYear() + "-" + (models.getMonth() + 1) + "-" + models.getDay();  //선택된 날짜값 받아옴 
				String division = division_inserts.getText().toString();
				String pageaddress = addre_inserts.getText().toString();
				String websitename =pagename_inserts.getText().toString();
				String remarks = remarks_insert.getText().toString();
				if(page_id.length()<=0||page_password.length()<=0||page_name.length()<=0
						||page_email.length()<=0||select_new_date.length()<=0||division.length()<=0
						||pageaddress.length()<=0||websitename.length()<=0) 									//기타는 널이여도됨, 공백이 아닐경우만 삽입가능
				{
					Basic b =new Basic("빈 공간이 있습니다.");
					b.setVisible(true);		
				}
				else
				{
					NewInsertQuery ne= new NewInsertQuery();
					int che =ne.new_insert( page_id,page_password ,page_name , page_email, select_new_date,
								division, pageaddress,websitename,remarks ,resultid ); //삽입 
					
					if(che==1) //삽입성공시 1을 반환함. 
					{
						Basic b =new Basic("정보 입력 완료.");
						b.setVisible(true);
						remove(tabb); 			//새정보가 삽입 되었으니 다시그리기위해서 manger판넬의 모든 것을 지움 
						remove(mpanel);      
						mArrayList = mppf.user_info_AllSelect(resultid);    //다시 어레이리스트를 받아옴 
						Table_display(); 														//다시 다 불러와서 나타냄  
						tab_display(); 
						tab_setting();
						revalidate();														 //리프레쉬 
						repaint();																	
						}
					}

				
			}
		});
		submits.setBackground(Color.LIGHT_GRAY);
		submits.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		submits.setBounds(10, 491, 252, 45);
		insertPanel.add(submits);
		
		
	}
	/*------------------------------------------------------------콤보박스 중복 제거 설정 -----------------------------------*/
	public void distinct_combobox()
	{
		for(int i =0; i<mArrayList.size();i++)
		{
			combobox_tabmenu.add(mArrayList.get(i).getDivision()); //DB에서 Division 항목만 가져옴 
		}
		combobox_tabmenu.add("직접입력");                                          //직접입력 추가 후 
		combobox_tabmenu = combobox_tabmenu.stream().distinct().collect(Collectors.toList()); //중복 제거후 다시 담기 

		//System.out.println(combobox_tabmenu);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////////////////////////////////////변경 부분///////////////////////////////////////////////////////////////////////////////////////////////
	private void modify_setting()
	{

		JPanel modifyPanel = new JPanel();
		modifyPanel.setBackground(Color.DARK_GRAY);
		modifyPanel.setBounds(279, 49, 408, 474);
		modifyPanel.setLayout(null);
		tabb.add("Modify", modifyPanel ); 
		
		JLabel top_label = new JLabel("Changing Information");
		top_label.setForeground(Color.WHITE);
		top_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		top_label.setHorizontalAlignment(SwingConstants.CENTER);
		top_label.setBounds(12, 10, 250, 27);
		modifyPanel.add(top_label);
		
		JLabel Id_lable = new JLabel("ID :");
		Id_lable.setForeground(Color.WHITE);
		Id_lable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		Id_lable.setHorizontalAlignment(SwingConstants.LEFT);
		Id_lable.setBounds(15, 90, 48, 25);
		modifyPanel.add(Id_lable);
		
		JLabel pw_lable = new JLabel("PW :");
		pw_lable.setForeground(Color.WHITE);
		pw_lable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pw_lable.setHorizontalAlignment(SwingConstants.LEFT);
		pw_lable.setBounds(15, 130, 48, 25);
		modifyPanel.add(pw_lable);
		
		JLabel nambe_label = new JLabel("Name :");
		nambe_label.setForeground(Color.WHITE);
		nambe_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		nambe_label.setHorizontalAlignment(SwingConstants.LEFT);
		nambe_label.setBounds(15, 170, 48, 25);
		modifyPanel.add(nambe_label);
		
		JLabel mail_label = new JLabel("e-mail :");
		mail_label.setForeground(Color.WHITE);
		mail_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		mail_label.setHorizontalAlignment(SwingConstants.LEFT);
		mail_label.setBounds(15, 210, 48, 25);
		modifyPanel.add(mail_label);
		
		JLabel singup_label = new JLabel("\uBCC0\uACBD\uC77C :");
		singup_label.setForeground(Color.WHITE);
		singup_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		singup_label.setHorizontalAlignment(SwingConstants.LEFT);
		singup_label.setBounds(15, 250, 51, 25);
		modifyPanel.add(singup_label);
		
		JLabel division_label = new JLabel("\uBD84\uB958 :");
		division_label.setForeground(Color.WHITE);
		division_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		division_label.setHorizontalAlignment(SwingConstants.LEFT);
		division_label.setBounds(15, 290, 48, 25);
		modifyPanel.add(division_label);
		
		JLabel addre_label = new JLabel("\uC8FC\uC18C :");
		addre_label.setForeground(Color.WHITE);
		addre_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		addre_label.setHorizontalAlignment(SwingConstants.LEFT);
		addre_label.setBounds(15, 330, 51, 25);
		modifyPanel.add(addre_label);
		
		JLabel pagename_label = new JLabel("\uD398\uC774\uC9C0 \uC774\uB984 :");
		pagename_label.setForeground(Color.WHITE);
		pagename_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pagename_label.setHorizontalAlignment(SwingConstants.LEFT);
		pagename_label.setBounds(15, 365, 78, 25);
		modifyPanel.add(pagename_label);
		
		id_insert = new JTextField();
		id_insert.setHorizontalAlignment(SwingConstants.CENTER);
		id_insert.setBounds(68, 90, 130, 25);
		modifyPanel.add(id_insert);
		id_insert.setColumns(10);
		
		pw_insert = new JTextField();
		pw_insert.setHorizontalAlignment(SwingConstants.CENTER);
		pw_insert.setColumns(10);
		pw_insert.setBounds(68, 130, 130, 25);
		modifyPanel.add(pw_insert);
		
		name_insert = new JTextField();
		name_insert.setHorizontalAlignment(SwingConstants.CENTER);
		name_insert.setColumns(10);
		name_insert.setBounds(68, 170, 130, 25);
		modifyPanel.add(name_insert);
		
		mail_insert = new JTextField();
		mail_insert.setColumns(10);
		mail_insert.setBounds(68, 210, 183, 25);
		modifyPanel.add(mail_insert);
		
		distinct_combobox();          //콤보박스 중복 제거 
		String CBmenu_1[]= combobox_tabmenu.toArray(new String[combobox_tabmenu.size()]);   
		JComboBox comboBox = new JComboBox(CBmenu_1); //콤보박스에 중복제거한 것을 넣음 
		
		division_insert = new JTextField();
		division_insert.setHorizontalAlignment(SwingConstants.CENTER);
		division_insert.setEnabled(false);
		division_insert.setBackground(Color.gray);
		division_insert.setText(comboBox.getSelectedItem().toString());
		
		//콤보박스 선택될때 액션 
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("직접입력")) //직접입력이면 Enable 트루 입력가능하게 바꿈 
				{
					division_insert.setText("");
					division_insert.setEnabled(true);
					division_insert.setBackground(Color.white);
					division_insert.setForeground(Color.black);

				}
				else
				{
					division_insert.setEnabled(false);
					division_insert.setBackground(Color.gray);
					division_insert.setText(comboBox.getSelectedItem().toString());
				}
			}
		});
		comboBox.setBounds(165, 290, 86, 26);
		modifyPanel.add(comboBox);
		
		division_insert.setColumns(10);
		division_insert.setBounds(68, 290, 85, 25);
		modifyPanel.add(division_insert);
		
		addre_insert = new JTextField();
		addre_insert.setColumns(10);
		addre_insert.setBounds(68, 330, 183, 25);
		modifyPanel.add(addre_insert);
		
		pagename_insert = new JTextField();
		pagename_insert.setHorizontalAlignment(SwingConstants.CENTER);
		pagename_insert.setColumns(10);
		pagename_insert.setBounds(102, 365, 149, 25);
		modifyPanel.add(pagename_insert);
		
		 model = new UtilDateModel();
		 datePanel = new JDatePanelImpl(model);
		 datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		 
		datePicker.getJFormattedTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		datePicker.getJFormattedTextField().setForeground(Color.WHITE);
		// SpringLayout springLayout;
		//springLayout = (SpringLayout) datePicker.getLayout();
		
		datePicker.getJFormattedTextField().setBackground(Color.GRAY);
		datePicker.getJFormattedTextField().setText((model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay()));
		datePicker.setBounds(68,250,130,25);
		modifyPanel.add(datePicker);
	
		JLabel remarks_label = new JLabel("\uAE30\uD0C0 \uC815\uBCF4 :");
		remarks_label.setHorizontalAlignment(SwingConstants.LEFT);
		remarks_label.setForeground(Color.WHITE);
		remarks_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		remarks_label.setBounds(15, 400, 78, 25);
		modifyPanel.add(remarks_label);
		
		
		JPanel panel = new JPanel(); //꾸미기용  판넬 신경쓸필요없음 (주황색 선을 나타냄 )
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 200, 0)));
		panel.setBounds(10, 15, 252, 27);
		modifyPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel(); //꾸미기용 판넬 신경쓸필요없음 (주황색선을 나타냄 )
		panel_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 200, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(8, 482, 254, 3);
		modifyPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		
		submit = new RoundedButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
		if(!no_insert.getText().toString().equals("선택")) 			//맨위가 선택이라면 선택하지 않은것이니 오른쪽의 리스트에서 선택하도록 해야 함.
		{
				String page_id = id_insert.getText().toString();
				String page_password = pw_insert.getText().toString();
				String page_name = name_insert.getText().toString();
				String  page_email= mail_insert.getText().toString();
				String select_new_date =datePicker.getJFormattedTextField().getText();  //선택된 날짜값 받아옴 
				String division = division_insert.getText().toString();
				String pageaddress = addre_insert.getText().toString();
				String websitename =pagename_insert.getText().toString();
				String remarks = remarks_insert.getText().toString();
				int tem_num = Integer.parseInt(no_insert.getText().toString());
				
				if(page_id.length()<=0||page_password.length()<=0||page_name.length()<=0
						||page_email.length()<=0||select_new_date.length()<=0||division.length()<=0
						||pageaddress.length()<=0||websitename.length()<=0)
					{
						Basic b =new Basic("빈 공간이 있습니다.");
						b.setVisible(true);		
					}
				else
					{
						ModifyQuery mq =new ModifyQuery();
						int che =mq.mdofiy( tem_num,page_id,page_password ,page_name , page_email, select_new_date,
									division, pageaddress,websitename,remarks,resultid);
						if(che==1)
						{
							Basic b =new Basic("정보 변경 완료.");
							b.setVisible(true);
							remove(tabb); //다시그리기위해서 manger판넬의 모든 것을 지움 
							remove(mpanel);
							mArrayList = mppf.user_info_AllSelect(resultid); //다시 어레이리스트를 받아옴 
							Table_display(); //다시 그림 
							tab_display(); 
							tab_setting();
							revalidate(); //리프레쉬 
							repaint();
						}
					}
				}
				else //선택하지 않았을 경우임.
				{
					Basic b =new Basic("변경할 정보가 없습니다.");
					b.setVisible(true);
				}

			}
		});
		
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		submit.setBounds(10, 495, 254, 41);
		modifyPanel.add(submit);
		
		JLabel nolabel = new JLabel("No :");
		nolabel.setHorizontalAlignment(SwingConstants.LEFT);
		nolabel.setForeground(Color.WHITE);
		nolabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		nolabel.setBounds(15, 55, 48, 25);
		modifyPanel.add(nolabel);
		
		no_insert = new JLabel("선택");
		no_insert.setForeground(Color.WHITE);
		no_insert.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		no_insert.setHorizontalAlignment(SwingConstants.CENTER);
		no_insert.setBounds(68, 55, 95, 25);
		modifyPanel.add(no_insert);
		
		JScrollPane remar_scroll = new JScrollPane();
		remar_scroll.setBounds(90, 408, 172, 62);
		modifyPanel.add(remar_scroll);
		
		remarks_insert = new JTextArea();
		remar_scroll.setViewportView(remarks_insert);
		remarks_insert.setLineWrap(true); //자동 줄바꿈
	}
	
	
	/*---------------------------DatePicker에서 날짜형식 포맷하는 것---------------------------------------------------------*/ 

	public class DateLabelFormatter extends AbstractFormatter {
	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	     
	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }
	 
	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }
	         
	        return "";
	    }
	}
	//------------------------------------------------------------------------------------------------------------------------------//
	
	
	//////////////////////////////////////////////////////////////////////삭제 부분/////////////////////////////////////////////////////////////////////////////////////////////
	private void delete_setting()
	{
		JPanel	deletePanel = new JPanel();
		deletePanel.setBackground(Color.DARK_GRAY);
		deletePanel.setBounds(279, 49, 408, 474);
		deletePanel.setLayout(null);

		tabb.add("Delete", deletePanel); 
		
		JLabel top_label = new JLabel("Delete Information");
		top_label.setForeground(Color.WHITE);
		top_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		top_label.setHorizontalAlignment(SwingConstants.CENTER);
		top_label.setBounds(12, 10, 250, 27);
		deletePanel.add(top_label);
		
		JLabel Id_lable = new JLabel("ID :");
		Id_lable.setForeground(Color.WHITE);
		Id_lable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		Id_lable.setHorizontalAlignment(SwingConstants.LEFT);
		Id_lable.setBounds(15, 90, 48, 25);
		deletePanel.add(Id_lable);
		
		JLabel pw_lable = new JLabel("PW :");
		pw_lable.setForeground(Color.WHITE);
		pw_lable.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pw_lable.setHorizontalAlignment(SwingConstants.LEFT);
		pw_lable.setBounds(15, 130, 48, 25);
		deletePanel.add(pw_lable);
		
		JLabel nambe_label = new JLabel("Name :");
		nambe_label.setForeground(Color.WHITE);
		nambe_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		nambe_label.setHorizontalAlignment(SwingConstants.LEFT);
		nambe_label.setBounds(15, 170, 48, 25);
		deletePanel.add(nambe_label);
		
		JLabel mail_label = new JLabel("e-mail :");
		mail_label.setForeground(Color.WHITE);
		mail_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		mail_label.setHorizontalAlignment(SwingConstants.LEFT);
		mail_label.setBounds(15, 210, 48, 25);
		deletePanel.add(mail_label);
		
		JLabel singup_label = new JLabel("\uAC00\uC785\uC77C :");
		singup_label.setForeground(Color.WHITE);
		singup_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		singup_label.setHorizontalAlignment(SwingConstants.LEFT);
		singup_label.setBounds(15, 250, 51, 25);
		deletePanel.add(singup_label);
		
		JLabel division_label = new JLabel("\uBD84\uB958 :");
		division_label.setForeground(Color.WHITE);
		division_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		division_label.setHorizontalAlignment(SwingConstants.LEFT);
		division_label.setBounds(15, 290, 48, 25);
		deletePanel.add(division_label);
		
		JLabel addre_label = new JLabel("\uC8FC\uC18C :");
		addre_label.setForeground(Color.WHITE);
		addre_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		addre_label.setHorizontalAlignment(SwingConstants.LEFT);
		addre_label.setBounds(15, 330, 51, 25);
		deletePanel.add(addre_label);
		
		JLabel pagename_label = new JLabel("\uD398\uC774\uC9C0 \uC774\uB984 :");
		pagename_label.setForeground(Color.WHITE);
		pagename_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pagename_label.setHorizontalAlignment(SwingConstants.LEFT);
		pagename_label.setBounds(15, 365, 78, 25);
		deletePanel.add(pagename_label);
		
		distinct_combobox();
		String CBmenu_1[]= combobox_tabmenu.toArray(new String[combobox_tabmenu.size()]);
		
		 model = new UtilDateModel();
		 datePanel = new JDatePanelImpl(model);
	
		JPanel panel = new JPanel(); //꾸미기용  판넬 신경쓸필요없음 (주황색 선을 나타냄 )
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 200, 0)));
		panel.setBounds(10, 15, 252, 27);
		deletePanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel(); //꾸미기용 판넬 신경쓸필요없음 (주황색선을 나타냄 )
		panel_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 200, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(8, 482, 254, 3);
		deletePanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		
		submit = new RoundedButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!no_la_insert.getText().toString().equals("선택"))
				{
					int tem_num = Integer.parseInt(no_la_insert.getText().toString());

					DeleteQuery dq =new DeleteQuery();
					int che =dq.delete( tem_num,resultid);
					if(che==1)
					{
						Basic b =new Basic("정보 삭제 완료.");
						b.setVisible(true);
						remove(tabb); //다시그리기위해서 manger판넬의 모든 것을 지움 
						remove(mpanel);
						mArrayList = mppf.user_info_AllSelect(resultid); //다시 어레이리스트를 받아옴 
						Table_display(); //다시 그림 
						tab_display(); 
						tab_setting();
						revalidate(); //리프레쉬 
						repaint();
					}
				}
				else
				{
					Basic b =new Basic("선택하지 않으셨습니다.");
					b.setVisible(true);
				}
			}
		});
		
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		submit.setBounds(10, 495, 254, 41);
		deletePanel.add(submit);
		
		JLabel nolabel = new JLabel("No :");
		nolabel.setHorizontalAlignment(SwingConstants.LEFT);
		nolabel.setForeground(Color.WHITE);
		nolabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		nolabel.setBounds(15, 55, 48, 25);
		deletePanel.add(nolabel);
		
		no_la_insert = new JLabel("선택");
		no_la_insert.setForeground(Color.WHITE);
		no_la_insert.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		no_la_insert.setHorizontalAlignment(SwingConstants.CENTER);
		no_la_insert.setBounds(75, 55, 130, 25);
		deletePanel.add(no_la_insert);
		
		 id_la_insert = new JLabel("");
		id_la_insert.setForeground(Color.WHITE);
		id_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		id_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		id_la_insert.setBounds(86, 90, 139, 25);
		deletePanel.add(id_la_insert);

		 pw_la_insert = new JLabel("");
		pw_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		pw_la_insert.setForeground(Color.WHITE);
		pw_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pw_la_insert.setBounds(86, 130, 139, 25);
		deletePanel.add(pw_la_insert);
		

		 name_la_insert = new JLabel("");
		name_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		name_la_insert.setForeground(Color.WHITE);
		name_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		name_la_insert.setBounds(86, 170, 139, 25);
		deletePanel.add(name_la_insert);
		
		

		 mail_la_insert = new JLabel("");
		mail_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		mail_la_insert.setForeground(Color.WHITE);
		mail_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		mail_la_insert.setBounds(64, 210, 164, 25);
		deletePanel.add(mail_la_insert);

		 signup_la_insert = new JLabel("");
		signup_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		signup_la_insert.setForeground(Color.WHITE);
		signup_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		signup_la_insert.setBounds(64, 250, 161, 25);
		deletePanel.add(signup_la_insert);
	
		 division_la_insert = new JLabel("");
		division_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		division_la_insert.setForeground(Color.WHITE);
		division_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		division_la_insert.setBounds(64, 290, 161, 25);
		deletePanel.add(division_la_insert);

		 add_la_insert = new JLabel("");
		add_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		add_la_insert.setForeground(Color.WHITE);
		add_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		add_la_insert.setBounds(64, 330, 161, 25);
		deletePanel.add(add_la_insert);

		 pagename_la_insert = new JLabel("");
		pagename_la_insert.setHorizontalAlignment(SwingConstants.RIGHT);
		pagename_la_insert.setForeground(Color.WHITE);
		pagename_la_insert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		pagename_la_insert.setBounds(99, 365, 126, 25);
		deletePanel.add(pagename_la_insert);
		
		JLabel remakrs_la_label = new JLabel("\uAE30\uD0C0 \uC815\uBCF4 :");
		remakrs_la_label.setHorizontalAlignment(SwingConstants.LEFT);
		remakrs_la_label.setForeground(Color.WHITE);
		remakrs_la_label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		remakrs_la_label.setBounds(15, 400, 70, 25);
		deletePanel.add(remakrs_la_label);
		
		JScrollPane remark_scroll = new JScrollPane();
		remark_scroll.setBounds(90, 408, 172, 62);
		deletePanel.add(remark_scroll);
		
		remarks_la_insert = new JTextArea();
		remark_scroll.setViewportView(remarks_la_insert);
		remarks_la_insert.setForeground(Color.BLACK);
		remarks_la_insert.setBackground(Color.DARK_GRAY);
		remarks_la_insert.setEnabled(false);
		remarks_la_insert.setDisabledTextColor(Color.white);

		remarks_la_insert.setLineWrap(true);
		
		
	}
	
	
	/*오른쪽 리스트 선택시 자동으로 입력하게하는 액션*/
	public void tab_setting()
	{
		tds.table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
			    if (e.getButton() == 1) {
					int row = tds.table.getSelectedRow();
					no_insert.setText( (String)tds.table.getValueAt(row,0));
					id_insert.setText((String)tds.table.getValueAt(row,3));
					pw_insert.setText( (String)tds.table.getValueAt(row,4));
					name_insert.setText((String)tds.table.getValueAt(row,5));
					datePicker.getJFormattedTextField().setText( (String)tds.table.getValueAt(row,6));
					mail_insert.setText((String)tds.table.getValueAt(row,7));
					division_insert.setText((String)tds.table.getValueAt(row,1));
					addre_insert.setText( (String)tds.table.getValueAt(row,8));
					pagename_insert.setText(	(String)tds.table.getValueAt(row,2));
					remarks_insert.setText(	(String)tds.table.getValueAt(row,9));
					
					
					no_la_insert.setText((String)tds.table.getValueAt(row,0));
					id_la_insert.setText((String)tds.table.getValueAt(row,3));
					pw_la_insert.setText((String)tds.table.getValueAt(row,4));
					name_la_insert.setText((String)tds.table.getValueAt(row,5));
					signup_la_insert.setText((String)tds.table.getValueAt(row,6));;
					mail_la_insert.setText((String)tds.table.getValueAt(row,7));;
					division_la_insert.setText((String)tds.table.getValueAt(row,1));;
					add_la_insert.setText((String)tds.table.getValueAt(row,8));
					pagename_la_insert.setText(	(String)tds.table.getValueAt(row,2));
					remarks_la_insert.setText(	(String)tds.table.getValueAt(row,9));
			    } //클릭

			    if (e.getClickCount() == 2) { } // 더블클릭

			    if (e.getButton() == 3) { } // 오른쪽 클릭
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
			}
		}); 
	}
	
	public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(255,247,242); //배경색 결정
	         Color o=new Color(0, 0, 0); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	    	 Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 30, 30); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	
	
}
