package Manager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import BasicDialog.Basic;
import BasicDialog.DetailDialog;
import DatabaseQuery.PmUserFind;
import DatabaseQuery.TabMenuQuery;
import Main.User;

@SuppressWarnings("serial")
//Search판넬에 들어갈 탭레이아웃 
class TabDataSelect extends JPanel{
	private JTextField textField;
    JTable table ;
    JScrollPane scroll ;
    JLabel select_label;
    JPanel panel;
	   public TabDataSelect(String me_name,String id){ //탭메뉴 이름값과 사용자 아이디를 받음 
		   	setBackground(Color.DARK_GRAY);
	        ArrayList<User> al = new ArrayList<>();
	        
	        String[] title = {"No", "분류", "사이트","ID","PW","Name","PW_변경일","e-mail","주소","기타"}; //테이블 컬럼 이름 선언 
	        DefaultTableModel model = new DefaultTableModel(title, 0) //table모델에 title 삽입
	        		{ //테이블 더블클릭해서 수정이 불가하도록 하는 코드 
	        	    	public boolean isCellEditable(int row, int column) {
	        	    		if (column >= 0) {
	        	    			return false;
	        	        } else {
	        	            return true;
	        	        }
	        	    }
	        	};
	        
	        PmUserFind pf = new PmUserFind();        
	        TabMenuQuery tm = new TabMenuQuery();
	        if(me_name.equals("All")==true) //만약 받아온 이름값이 All이라면 
	        {
	        	al=pf.user_info_AllSelect(id); //모든정보를 select 해서 어레이에 넣음 
	        }
	        else
	        {
	        	al = tm.tab_menu_select(me_name,id); //All이 아니라면 탭이름과 같은 유형을 가지는 정보들만 가져옴 
	        }
	        
	        String[] rows = new String[title.length]; //row(행) 만큼 배열 생성
	        for(int i =0;i<al.size();i++) //어레이 크기만큼 for문 반복 해당 정보 삽입
	        {
	        		rows[0] = Integer.toString(al.get(i).getTem_num());
	        		rows[1] = al.get(i).getDivision();
	        		rows[2] = al.get(i).getWebsitename();
	        		rows[3] = al.get(i).getPage_id();
	        		rows[4] = al.get(i).getPage_password();
	        		rows[5] = al.get(i).getPage_name();
	        		rows[6] = al.get(i).getSingupdate();
	        		rows[7] = al.get(i).getPage_email();
	        		rows[8] = al.get(i).getPageaddress();
	        		rows[9] = al.get(i).getRemarks();
	        		model.addRow(rows);
	        	}
	        table= new JTable(model); //테이블 생성 
	        table_set();
	        setLayout(null);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        scroll =new JScrollPane(table);
	        scroll.setBounds(20, 78, 825, 450);	            //테ㅐ이블 사이즈      
	        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        add(scroll);
	        
	        select_label = new JLabel("Search :");
	        select_label.setForeground(Color.WHITE);
	        select_label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
	        select_label.setHorizontalAlignment(SwingConstants.CENTER);
	        select_label.setBounds(30, 25, 88, 30);
	        add(select_label);
	        
	         panel= new JPanel();
	        panel.setBackground(Color.DARK_GRAY);
	        panel.setBorder(new MatteBorder(0, 0, 4, 0, (Color) new Color(255, 200, 0)));
	        panel.setBounds(30, 22, 340, 47);
	        add(panel);
	        panel.setLayout(null);
	        
	        textField = new JTextField();
	        textField.setBounds(96, 0, 244, 33);
	        panel.add(textField);
	        
	        
	      //검색하기 위한 리스너 (필터)
	        textField.addKeyListener(new KeyAdapter() { 
	        	@Override
	        	public void keyReleased(KeyEvent e) {
	        		String search = textField.getText().toString();
	        		TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(model);
	        		table.setRowSorter(trs);
	        		trs.setRowFilter(RowFilter.regexFilter(search));
	        	}
	        });
	        textField.setColumns(10);
	        
	    }

	   private void table_set()
	   {
		   JTableHeader header= table.getTableHeader(); 	//테이블 헤더 (즉 컬럼부분 색깔 변경)
		   header.setBackground(Color.DARK_GRAY);
		   header.setForeground(Color.white);
		   
	       Font font = new Font("맑은 고딕", Font.PLAIN, 12);
		  table.setRowHeight(30); 
		  table.setFont(font);
		  table.setPreferredScrollableViewportSize(new Dimension(602,231));  //58줄의 스크롤이랑 맞출것 
		   DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		   celAlignCenter.setHorizontalAlignment(JLabel.CENTER); 					//가운데로 정렬 
		   DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		   celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		   table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   
		   table.getColumn("No").setPreferredWidth(44); 				//각 컬럼 크기 설정 
		   table.getColumn("No").setCellRenderer(celAlignCenter);;
		   table.getColumn("분류").setPreferredWidth(60);
		   table.getColumn("분류").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("사이트").setPreferredWidth(115);
		   table.getColumn("사이트").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("ID").setPreferredWidth(100);
		   table.getColumn("ID").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("PW").setPreferredWidth(100);
		   table.getColumn("PW").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("Name").setPreferredWidth(100);
		   table.getColumn("Name").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("e-mail").setPreferredWidth(200);
		   table.getColumn("e-mail").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("PW_변경일").setPreferredWidth(120);
		   table.getColumn("PW_변경일").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("주소").setPreferredWidth(200);
		   table.getColumn("주소").setCellRenderer(celAlignCenter);;
		   
		   //컬럼을 선택하였을때 
		   table.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					  int row = table.getSelectedRow();
					  int col = table.getSelectedColumn();
					  if(col==9||col==0) //0번째 컬럼, 9번째 컬럼을 선택하면 상세정보가 나타남 
					  {
						  int detail= Integer.parseInt(table.getValueAt(row,0).toString());
						  DetailDialog dd = new DetailDialog(detail);
						  dd.setVisible(true);
					  }
				

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		   
	   });
	   }

}



	