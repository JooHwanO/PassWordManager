package BasicDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DatabaseQuery.ModifyQuery;
import DatabaseQuery.PmUserFind;
import Main.User;
import Manager.ManagerPanel;
import Manager.ManagerPanel.DateLabelFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuickChangeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<User> al = new ArrayList<>();
	private String ad = null;
	private final JLabel lblNewLabel_5 = new JLabel("기타");
	private JTextField la2;
	private JTextField la3;
	private JTextField la4;
	private JTextField la5;
	private JTextField la7;
	private JTextField sitename;
	private  int checkint = 0;
	String resultid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			QuickChangeDialog dialog = new QuickChangeDialog(1,"ghksdh587");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public QuickChangeDialog(int tem_num,String id) {
		getContentPane().setBackground(Color.DARK_GRAY);
		setModal(true);           			//모달형식으로 모달은 현재창이 닫기전까지 다른행동을 못함.
		setBounds(228, 100, 359, 749); //위치 및 크기 
		setLocationRelativeTo(null); 	//윈도우창 가운데 띄움 
		setResizable(false);                //크기조절 못하게 
		PmUserFind pm =new PmUserFind();
		al= pm.Detail_info_select(tem_num); //해당 일련번호의 정보를 불러옴.
		one();
		resultid = id;
	}
	private void one()
	{
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 341, 712);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(5, 6, 330, 51);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uC138 \uC815\uBCF4");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 0, 165, 51);
		
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(5, 57, 330, 456);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uC77C\uB828\uBC88\uD638");
		lblNewLabel_3.setBounds(1, 3, 164, 50);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(1, 53, 164, 50);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(1, 103, 164, 50);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("\uAC00\uC785\uC774\uB984");
		lblNewLabel_6.setBounds(1, 203, 164, 50);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_11 = new JLabel("Email");
		lblNewLabel_11.setBounds(1, 253, 164, 50);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("\uAC00\uC785\uC77C \uB610\uB294 \uBCC0\uACBD\uC77C");
		lblNewLabel_10.setBounds(1, 303, 164, 50);
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("\uBD84\uB958");
		lblNewLabel_12.setBounds(1, 353, 164, 50);
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1.setBounds(1, 403, 164, 50);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_1);
		
		la2 = new JTextField();
		la2.setColumns(10);
		la2.setBounds(177, 66, 144, 30);
		panel_1.add(la2);
		
		la3 = new JTextField();
		la3.setColumns(10);
		la3.setBounds(177, 116, 144, 30);
		panel_1.add(la3);
		
		la4 = new JTextField();
		la4.setColumns(10);
		la4.setBounds(177, 216, 144, 30);
		panel_1.add(la4);
		
		la5 = new JTextField();
		la5.setColumns(10);
		la5.setBounds(177, 266, 144, 30);
		panel_1.add(la5);
		
		la7 = new JTextField();
		la7.setColumns(10);
		la7.setBounds(177, 415, 144, 30);
		panel_1.add(la7);
		
		JLabel la1 = new JLabel("");
		la1.setHorizontalAlignment(SwingConstants.CENTER);
		la1.setForeground(Color.WHITE);
		la1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		la1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		la1.setBounds(166, 3, 164, 50);
		panel_1.add(la1);
		
		JLabel la6 = new JLabel("");
		la6.setHorizontalAlignment(SwingConstants.CENTER);
		la6.setForeground(Color.WHITE);
		la6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		la6.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		la6.setBounds(166, 353, 164, 50);
		panel_1.add(la6);
		
		//날짜 고르게 설정할 수 잇는 date Picker
		 UtilDateModel model ;
		 JDatePanelImpl datePanel ;
		 JDatePickerImpl datePicker ;
		 model = new UtilDateModel();
		 datePanel = new JDatePanelImpl(model);
		 datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		 datePicker.setBounds(177, 318, 144, 25);
		panel_1.add(datePicker);
		
		datePicker.getJFormattedTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		datePicker.getJFormattedTextField().setForeground(Color.WHITE);
		SpringLayout springLayouts = (SpringLayout) datePicker.getLayout();
		datePicker.getJFormattedTextField().setBackground(Color.GRAY);
		
		JLabel lblNewLabel_6_1 = new JLabel("\uC0AC\uC774\uD2B8 \uC774\uB984");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_6_1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_6_1.setBounds(1, 153, 164, 50);
		panel_1.add(lblNewLabel_6_1);
		
		sitename = new JTextField();
		sitename.setColumns(10);
		sitename.setBounds(177, 165, 144, 30);
		panel_1.add(sitename);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(5, 513, 330, 140);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(131, 4, 64, 32);
		panel_2.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 38, 306, 87);
		panel_2.add(scrollPane);
		
		JTextArea la8 = new JTextArea();
		la8.setLineWrap(true); //자동 줄바꿈
		scrollPane.setViewportView(la8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(5, 651, 330, 51);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btncancel.setForeground(Color.WHITE);
		btncancel.setBounds(187, 10, 97, 29);
		panel_3.add(btncancel);
		btncancel.setBackground(Color.DARK_GRAY);
		

		UtilDateModel models = new UtilDateModel();
		JDatePanelImpl datePanels = new JDatePanelImpl(models);
		
		
		
		for(int i =0; i<al.size();i++) //각 Text값에 불러온 정보를 삽입 
		{
				la1.setText(Integer.toString(al.get(i).getTem_num()));
				la2.setText(al.get(i).getPage_id());
				la3.setText(al.get(i).getPage_password());
				la4.setText(al.get(i).getPage_name());
				la5.setText(al.get(i).getPage_email());
				datePicker.getJFormattedTextField().setText(al.get(i).getSingupdate());
				la6.setText(al.get(i).getDivision());
				la7.setText(al.get(i).getPageaddress());
				la8.setText(al.get(i).getRemarks());
				sitename.setText(al.get(i).getWebsitename());
		}
		
		JButton btnok = new JButton("OK");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tem_num = Integer.parseInt(la1.getText().toString());
				String page_id = la2.getText().toString();
				String page_password = la3.getText().toString();
				String page_name = la4.getText().toString();
				String  page_email= la5.getText().toString();
				String select_new_date =datePicker.getJFormattedTextField().getText();  //선택된 날짜값 받아옴 
				String division = la6.getText().toString();
				String pageaddress = la7.getText().toString();
				String websitename =sitename.getText().toString();
				String remarks = la8.getText().toString();

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
						Basic b =new Basic("변경 완료. 새로고침 하세요");
						b.setVisible(true);
						dispose();
					//	remove(tabb); //다시그리기위해서 manger판넬의 모든 것을 지움 
					//	remove(mpanel);
				//		mArrayList = mppf.user_info_AllSelect(resultid); //다시 어레이리스트를 받아옴 
				//		Table_display(); //다시 그림 
				//		tab_display(); 
				//		tab_setting();
				//		revalidate(); //리프레쉬 
				//		repaint();
					}
				}
			

			}
		});
		btnok.setForeground(Color.WHITE);
		btnok.setBounds(54, 10, 97, 29);
		panel_3.add(btnok);
		btnok.setBackground(Color.DARK_GRAY);
	}
	
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
	

}
