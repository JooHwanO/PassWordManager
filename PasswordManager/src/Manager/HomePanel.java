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
 
	List<String> onlysitename90 = new ArrayList<String>(); //90�ϳ��� ����� ����Ʈ �̸��� ������� 
	List<String> onlyDiff90 = new ArrayList<String>(); //90�ϳ��� ����� �Ⱓ ���̸� ��� ���� 
	List<String> onlyAdrress90 = new ArrayList<String>(); // 90�� ���� ����� ����Ʈ �ּ� ��ü�� ��� ����
	List<String> onlyID90 = new ArrayList<String>(); // 90�� ���� ����� ����Ʈ Id ������� 
	List<String> onlyPassword90 = new ArrayList<String>(); // 90�� ���� ����� ����Ʈ ����� ������� 
	List<Integer> onlyintTem90 = new ArrayList<Integer>(); // 90�� ���� ����� �Ϸù�ȣ ��� ����
	List<String> onlysitename_list = new ArrayList<String>(); //����ִ� ��� ����Ʈ �̸��� ��� ���� 
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
		this.mArrayList =puf.user_info_AllSelect(resultid); //������ �ҷ�����.
		this.resultid=resultid;
		setBounds(158, 53, 936, 618);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		basic_setting();
		home_difine();
	}
	
	/*--------------------------------------------------- Ȩ ���� --------------------------------------------------*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void home_difine( )
	{
		managerScroll= new JScrollPane(); //��� ����Ʈ �̸��� ��� ���̾ƿ� �� ���� ������ ��ũ���г�  
		  JPanel borderlaypanel = new JPanel();  //��ũ�� �гξȿ� border���̾ƿ� (���ʺ��� �Ʒ��� �����ϱ� ���� ) 
		  JPanel Gridlaypanel = new JPanel();  // �������̾ƿ� �ȿ� grid �����̿� ( �ϳ��� �÷��� �����ϱ� ����) 
		     
		managerScroll.setBounds(280, 70, 606, 498);
		add(managerScroll);
		managerScroll.setViewportView(borderlaypanel);
		
		borderlaypanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		borderlaypanel.setBackground(Color.WHITE);
		borderlaypanel.setLayout(new BorderLayout(0, 0)); //�������̾ƿ��� ������ 
		borderlaypanel.add(Gridlaypanel, BorderLayout.NORTH);  //�������̾ƿ��� �׸��� ���̾ƿ��� �ְ�, ���κ��� north�� ����
		Gridlaypanel.setLayout(new GridLayout(0,1,0,6));
		
		
		/*-------------------------------��й�ȣ ������ 90�� �̻�� ����Ʈ�� ǥ���ϱ����� ���� �۾� ------------------------*/
		for(int i =0; i < this.mArrayList.size();i++ )
		{
			 DateDiff df = new DateDiff();            //��¥���	
			int Dfdate =df.datediff(this.mArrayList.get(i).getSingupdate()); //��¥ ���� ���
			if(Dfdate>=90) //���糯¥���� ���̰� 90�� �̻��� �͵���  
			{ 
				onlyID90.add(mArrayList.get(i).getPage_id());
				onlyPassword90.add(mArrayList.get(i).getPage_password());
				onlysitename90.add(mArrayList.get(i).getWebsitename());                  // �̸��� �����ϴ� ��̸���Ʈ                                           
				onlyDiff90.add(Integer.toString(Dfdate));                                //��¥���̰� �����ϴ� ��̸���Ʈ
				onlyAdrress90.add(mArrayList.get(i).getPageaddress());         // Ȩ������ �ּҰ� �����ϴ� ��� ����Ʈ 
				onlyintTem90.add(mArrayList.get(i).getTem_num());
			}
		}  
		
		
		/*----------------------------------------90�� ���� ����� ������ ����Ʈ�� ǥ���ϴ� �ǳ�   ----------------------------------------------*/
		for(i=0;i<onlysitename90.size();i++)   //90�� ���� ����Ʈ�� �����ϴ� onlysitename ���
		{
			rowPanel = new JPanel(); 
			rowPanel.setPreferredSize(new Dimension(100,50));    //�ش� ������� where�� ������ŭ �ǳ��� ����
			int d=Integer.parseInt(onlyDiff90.get(i));                           // �ش� ����Ʈ�� ���̳��� ��¥�� �޾ƿ� 
			if(d>90&&d<=180) 														//90~180�� ���̴� �׷��̹���
			{
				rowPanel.setBackground(Color.gray);
				rowPanel.setBorder(BorderFactory.createLineBorder(Color.gray,2));
			}
			else if(d>180&&d<250) // 180~250�� ���̴� ������ ���� �������� red�� �������� �����Ͽ� �߿伺�� �˸� 
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
			Gridlaypanel.add(rowPanel); //94�ٿ� ������ �׸��巹�̾ƿ��� rowPanel�� ���� 
			                                  
	        Font font = new Font("���� ���", Font.PLAIN, 15);
			JButton jb = new JButton();    				  //����Ʈ �ּҷ� ���� ��ư �߰� 
			jb.setText(onlysitename90.get(i));            // �ش� �̸��� �̸��� ������ ���� 
	        jb.setFont(font);
	        jb.setBackground(Color.DARK_GRAY);
	        jb.setForeground(Color.white);
	        jb.setBounds(2,2,200,46);
			String address = onlyAdrress90.get(i);     // �ش� �ּҴ� �ּҸ� �ִ� onlyAdrress90���� ������ ���� 
			jb.addMouseListener(new MouseAdapter() { //��ư ���콺 Ŭ���̺�Ʈ
				@Override
				public void mouseClicked(MouseEvent e) {
					 try {
						 	Desktop.getDesktop().browse(new URI(address)); //�ش��ּҷ� �̵� 
					} catch (IOException | URISyntaxException e1) {
						// TODO �ڵ� ������ catch ���
						e1.printStackTrace();
					}
				}
			});
			
	        Font font2 = new Font("���� ���", Font.BOLD, 15);
			JLabel jl =new JLabel();  //90���̻� ǥ���ϴ� �� �߰� 
			jl.setBounds(365,2,120,46);
			jl.setText(onlyDiff90.get(i)+"�� ���"); //�ϼ����̸� �ִ� where2���� ���̸� ���� ���� 
			jl.setFont(font2);
			jl.setForeground(Color.black);
			jl.setHorizontalAlignment(JLabel.TRAILING);
			
			JLabel jlid =new JLabel(); //���̵� ���̰� 
			jlid.setBounds(220,8,150,80);
			jlid.setVerticalAlignment(JLabel.TOP);
			jlid.setText("ID    : " + onlyID90.get(i));
			jlid.setForeground(Color.black);
			
			JLabel jlpw =new JLabel();
			jlpw.setBounds(220,25,150,80);
			jlpw.setVerticalAlignment(JLabel.TOP);
			jlpw.setText("PW : " + onlyPassword90.get(i));
			jlpw.setForeground(Color.black);
			
	        Font font3 = new Font("���� ���", Font.PLAIN, 11);
	       
	        RoundedButton pastbut = new  RoundedButton();    				  //����Ʈ �ּҷ� ���� ��ư �߰� 
			pastbut.setText("��� ����");            // �ش� �̸��� �̸��� ������ ���� 
			pastbut.setFont(font3);
			pastbut.setBackground(Color.DARK_GRAY);
			pastbut.setForeground(Color.white);
			pastbut.setBounds(496,8,100,35);
			pastbut.addMouseListener(new MouseAdapter() { //��ư ���콺 Ŭ���̺�Ʈ
			int tem_num =onlyintTem90.get(i);
				@Override
				public void mouseClicked(MouseEvent e) {
					QuickChangeDialog qcd = new QuickChangeDialog(tem_num,resultid);
					qcd.setVisible(true);
				}
			});
	
			rowPanel.add(jlpw); //��� ��
			rowPanel.add(jlid); //���̵� �� 
			rowPanel.add(jb);//��ư�߰�
			rowPanel.add(jl); //���߰� 
			rowPanel.add(pastbut); //�� ���� ��ư
			rowPanel.setLayout(null); //���ַ�Ʈ ���̾ƿ� 
			
	         //  �������� 90�� ���� ����Ʈ�� �̸��� ��ư�� �ֱ����� �ش����� ����
            // ��ũ���ǳ�(�������̾ƿ��ǳ�(�׸��巹�̾ƿ��ǳ�(���ַ�Ʈ�ǳ�(�̸���,��ư))))
			}
		
		/*---------------------------------------���  �̸��� ��Ÿ���� JList  ------------------------------------------*/		
		
			for(int i =0; i < this.mArrayList.size();i++ )
			{
				onlysitename_list.add(mArrayList.get(i).getWebsitename());								//�̹���, �󺧿����� �󺧿� �� �κ� 
				onlysitename_list = onlysitename_list.stream().distinct().collect(Collectors.toList()); 				//�ߺ� ����
			}	
		
			String nameList1[] =onlysitename_list.toArray(new String[onlysitename_list.size()]);        //jlist�� �ֱ����� �迭�� ����  
			JList list= new JList(nameList1);              
			list.setBorder(new LineBorder(Color.BLACK, 2, true));
			list.setCellRenderer(new ListRenderer());                                // �󺧰� ������ �����ؼ� ������?
	        list.setSelectionBackground(Color.lightGray);
	        list.setFixedCellHeight(50);                          //����Ʈ �� ���� ũ�⸦ 70���� ���� 
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
	        scrollPane= new JScrollPane(list);                    //��ũ���гο� JList ���� 
			scrollPane.setBounds(43, 70, 201, 498);                        
			add(scrollPane, BorderLayout.CENTER);
	
	}
	private void basic_setting()
	{
		Main_label1.setForeground(Color.WHITE);
		Main_label1.setFont(new Font("���� ���", Font.BOLD, 20));
		Main_label1.setBounds(43, 23, 176, 38);
		add(Main_label1);
		
		 JLabel Main_label2 = new JLabel("���� ��� ����Ʈ");
		Main_label2.setFont(new Font("���� ���", Font.BOLD, 20));
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
	
	
	
	/*--------------------------------------------------- JList �ٹ̱�  --------------------------------------------------*/
	
	public class ListRenderer extends DefaultListCellRenderer {

	        Font font = new Font("���� ���", Font.PLAIN, 15);

	        @Override
	        public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
	            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
               // label.setIcon(imageMap.get((String) value));
	            label.setHorizontalTextPosition(JLabel.TRAILING);
	            label.setFont(font);
	            label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
	            return label;
	        }
	        public int getHorizontalAlignment() { //���� ��� 
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
	         Color c=new Color(255,247,242); //���� ����
	         Color o=new Color(0, 0, 0); //���ڻ� ����
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
