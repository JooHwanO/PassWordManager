package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import BasicDialog.InfoDialog;
import BasicDialog.QuickChangeDialog;
import DatabaseQuery.PmUserFind;
import Main.User;
//import Manager.MainFrame.RoundedButton;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	private ArrayList<User> mArrayList;
    String resultid;
 
	List<String> onlysitename90 = new ArrayList<String>(); //90일넘은 비번중 사이트 이름만 담기위함 
	List<String> onlyDiff90 = new ArrayList<String>(); //90일넘은 비번중 기간 차이를 담기 위함 
	List<String> onlyAdrress90 = new ArrayList<String>(); // 90일 넘은 비번중 사이트 주소 전체를 담기 위함
	List<String> onlyID90 = new ArrayList<String>(); // 90일 넘은 비번중 사이트 Id 담기위함 
	List<String> onlyPassword90 = new ArrayList<String>(); // 90일 넘은 비번중 사이트 비번을 담기위함 
	List<Integer> onlyintTem90 = new ArrayList<Integer>(); // 90일 넘은 비번중 일련번호 담기 위함
	List<String> onlysitename_list = new ArrayList<String>(); //디비에있는 모든 사이트 이름을 담기 위함 
	int i;
	
	JPanel rowPanel;
	private final JLabel Main_label1 = new JLabel("\uAD00\uB9AC\uC911\uC778 \uC0AC\uC774\uD2B8");
	
	JScrollPane scrollPane;
	JScrollPane managerScroll ;
	
	
	/**
	 * Create the panel.
	 */
	public HomePanel(String resultid) {
		
		 PmUserFind puf=new PmUserFind();
		this.mArrayList =puf.user_info_AllSelect(resultid); //정보를 불러들임.
		this.resultid=resultid;
		setBounds(158, 53, 936, 618);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		basic_setting();
		home_difine();
	}
	
	/*--------------------------------------------------- 홈 설정 --------------------------------------------------*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void home_difine( )
	{
		managerScroll= new JScrollPane(); //모든 사이트 이름을 담는 레이아웃 중 제일 상위인 스크롤패널  
		  JPanel borderlaypanel = new JPanel();  //스크롤 패널안에 border레이아웃 (위쪽부터 아래로 차게하기 위함 ) 
		  JPanel Gridlaypanel = new JPanel();  // 보더레이아웃 안에 grid 레아이웃 ( 하나의 컬럼을 지정하기 위함) 
		     
		managerScroll.setBounds(280, 70, 606, 498);
		add(managerScroll);
		managerScroll.setViewportView(borderlaypanel);
		
		borderlaypanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		borderlaypanel.setBackground(Color.WHITE);
		borderlaypanel.setLayout(new BorderLayout(0, 0)); //보더레이아웃을 설정후 
		borderlaypanel.add(Gridlaypanel, BorderLayout.NORTH);  //보더레이아웃에 그리드 레이아웃을 넣고, 윗부분인 north로 지정
		Gridlaypanel.setLayout(new GridLayout(0,1,0,6));
		
		
		/*-------------------------------비밀번호 변경이 90일 이상된 사이트를 표시하기위한 사전 작업 ------------------------*/
		for(int i =0; i < this.mArrayList.size();i++ )
		{
			 DateDiff df = new DateDiff();            //날짜계산	
			int Dfdate =df.datediff(this.mArrayList.get(i).getSingupdate()); //날짜 차이 계산
			if(Dfdate>=90) //현재날짜와의 차이가 90일 이상인 것들의  
			{ 
				onlyID90.add(mArrayList.get(i).getPage_id());
				onlyPassword90.add(mArrayList.get(i).getPage_password());
				onlysitename90.add(mArrayList.get(i).getWebsitename());                  // 이름만 존재하는 어레이리스트                                           
				onlyDiff90.add(Integer.toString(Dfdate));                                //날짜차이가 존재하는 어레이리스트
				onlyAdrress90.add(mArrayList.get(i).getPageaddress());         // 홈페이지 주소가 존재하는 어레이 리스트 
				onlyintTem90.add(mArrayList.get(i).getTem_num());
			}
		}  
		
		
		/*----------------------------------------90일 넘은 비번을 가지는 사이트를 표시하는 판넬   ----------------------------------------------*/
		for(i=0;i<onlysitename90.size();i++)   //90일 넘은 사이트가 존재하는 onlysitename 어레이
		{
			rowPanel = new JPanel(); 
			rowPanel.setPreferredSize(new Dimension(100,50));    //해당 사이즈로 where의 개수만큼 판넬을 생성
			int d=Integer.parseInt(onlyDiff90.get(i));                           // 해당 사이트의 차이나는 날짜를 받아옴 
			if(d>90&&d<=180) 														//90~180일 사이는 그레이바탕
			{
				rowPanel.setBackground(Color.gray);
				rowPanel.setBorder(BorderFactory.createLineBorder(Color.gray,2));
			}
			else if(d>180&&d<250) // 180~250일 사이는 오렌지 바탕 나머지는 red로 바탕색을 지정하여 중요성을 알림 
			{
				rowPanel.setBackground(Color.ORANGE);
				rowPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
			}
			else
			{
				rowPanel.setBackground(Color.RED);
				rowPanel.setBorder(BorderFactory.createLineBorder(Color.RED,2));
			}
			
			//rowPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
			Gridlaypanel.add(rowPanel); //94줄에 지정한 그리드레이아웃에 rowPanel을 넣음 
			                                  
	        Font font = new Font("맑은 고딕", Font.PLAIN, 15);
			JButton jb = new JButton();    				  //사이트 주소로 가는 버튼 추가 
			jb.setText(onlysitename90.get(i));            // 해당 이름을 이름만 꺼내서 넣음 
	        jb.setFont(font);
	        jb.setBackground(Color.DARK_GRAY);
	        jb.setForeground(Color.white);
	        jb.setBounds(2,2,200,46);
			String address = onlyAdrress90.get(i);     // 해당 주소는 주소만 있는 onlyAdrress90에서 꺼내서 넣음 
			jb.addMouseListener(new MouseAdapter() { //버튼 마우스 클릭이벤트
				@Override
				public void mouseClicked(MouseEvent e) {
					 try {
						 	Desktop.getDesktop().browse(new URI(address)); //해당주소로 이동 
					} catch (IOException | URISyntaxException e1) {
						// TODO 자동 생성된 catch 블록
						e1.printStackTrace();
					}
				}
			});
			
	        Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
			JLabel jl =new JLabel();  //90일이상 표시하는 라벨 추가 
			jl.setBounds(365,2,120,46);
			jl.setText(onlyDiff90.get(i)+"일 경과"); //일수차이만 있는 where2에서 차이를 꺼내 넣음 
			jl.setFont(font2);
			jl.setForeground(Color.black);
			jl.setHorizontalAlignment(JLabel.TRAILING);
			
			JLabel jlid =new JLabel(); //아이디 보이게 
			jlid.setBounds(220,8,150,80);
			jlid.setVerticalAlignment(JLabel.TOP);
			jlid.setText("ID    : " + onlyID90.get(i));
			jlid.setForeground(Color.black);
			
			JLabel jlpw =new JLabel();
			jlpw.setBounds(220,25,150,80);
			jlpw.setVerticalAlignment(JLabel.TOP);
			jlpw.setText("PW : " + onlyPassword90.get(i));
			jlpw.setForeground(Color.black);
			
	        Font font3 = new Font("맑은 고딕", Font.PLAIN, 11);
	       
	        RoundedButton pastbut = new  RoundedButton();    				  //사이트 주소로 가는 버튼 추가 
			pastbut.setText("즉시 변경");            // 해당 이름을 이름만 꺼내서 넣음 
			pastbut.setFont(font3);
			pastbut.setBackground(Color.DARK_GRAY);
			pastbut.setForeground(Color.white);
			pastbut.setBounds(496,8,100,35);
			pastbut.addMouseListener(new MouseAdapter() { //버튼 마우스 클릭이벤트
			int tem_num =onlyintTem90.get(i);
				@Override
				public void mouseClicked(MouseEvent e) {
					QuickChangeDialog qcd = new QuickChangeDialog(tem_num,resultid);
					qcd.setVisible(true);
				}
			});
	
			rowPanel.add(jlpw); //비번 라벨
			rowPanel.add(jlid); //아이디 라벨 
			rowPanel.add(jb);//버튼추가
			rowPanel.add(jl); //라벨추가 
			rowPanel.add(pastbut); //퀵 변경 버튼
			rowPanel.setLayout(null); //엡솔루트 레이아웃 
			
	         //  변경한지 90일 넘은 사이트의 이름과 버튼을 넣기위해 해당방식이 사용됨
            // 스크롤판넬(보더레이아웃판넬(그리드레이아웃판넬(엡솔루트판넬(이름라벨,버튼))))
			}
		
		/*---------------------------------------모든  이름을 나타내는 JList  ------------------------------------------*/		
		
			for(int i =0; i < this.mArrayList.size();i++ )
			{
				onlysitename_list.add(mArrayList.get(i).getWebsitename());								//이미지, 라벨에서의 라벨에 들어갈 부분 
				onlysitename_list = onlysitename_list.stream().distinct().collect(Collectors.toList()); 				//중복 제거
			}	
		
			String nameList1[] =onlysitename_list.toArray(new String[onlysitename_list.size()]);        //jlist에 넣기위해 배열에 넣음  
			JList list= new JList(nameList1);              
			list.setBorder(new LineBorder(Color.BLACK, 2, true));
			list.setCellRenderer(new ListRenderer());                                // 라벨과 아이콘 맵핑해서 렌더링?
	        list.setSelectionBackground(Color.lightGray);
	        list.setFixedCellHeight(50);                          //리스트 각 셀의 크기를 70으로 고정 
	        list.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent evt) {
	        		  JList list = (JList)evt.getSource();
	        	        if (evt.getClickCount() == 2) {
	        	        	String ff= list.getSelectedValue().toString();
		    	        	System.out.println(ff);
		    	        	InfoDialog Ud = new InfoDialog(resultid,ff);
		    	
	        	        }
	        	}
	        });
	        scrollPane= new JScrollPane(list);                    //스크롤패널에 JList 삽입 
			scrollPane.setBounds(43, 70, 201, 498);                        
			add(scrollPane, BorderLayout.CENTER);
	
	}
	private void basic_setting()
	{
		Main_label1.setForeground(Color.WHITE);
		Main_label1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Main_label1.setBounds(43, 23, 176, 38);
		add(Main_label1);
		
		 JLabel Main_label2 = new JLabel("변경 요망 사이트");
		Main_label2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Main_label2.setForeground(Color.WHITE);
		Main_label2.setBounds(280, 22, 169, 38);
		add(Main_label2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.ORANGE));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(43, 22, 201, 38);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.ORANGE));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(280, 22, 606, 38);
		
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	
	
	
	/*--------------------------------------------------- JList 꾸미기  --------------------------------------------------*/
	
	public class ListRenderer extends DefaultListCellRenderer {

	        Font font = new Font("맑은 고딕", Font.PLAIN, 15);

	        @Override
	        public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
	            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
               // label.setIcon(imageMap.get((String) value));
	            label.setHorizontalTextPosition(JLabel.TRAILING);
	            label.setFont(font);
	            label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
	            return label;
	        }
	        public int getHorizontalAlignment() { //글자 가운데 
                return CENTER;
       }
	        
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
	         graphics.fillRoundRect(0, 0, width, height, 40, 40); 
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
