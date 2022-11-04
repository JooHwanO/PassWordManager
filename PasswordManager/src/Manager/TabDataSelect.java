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
//Search�ǳڿ� �� �Ƿ��̾ƿ� 
class TabDataSelect extends JPanel{
	private JTextField textField;
    JTable table ;
    JScrollPane scroll ;
    JLabel select_label;
    JPanel panel;
	   public TabDataSelect(String me_name,String id){ //�Ǹ޴� �̸����� ����� ���̵� ���� 
		   	setBackground(Color.DARK_GRAY);
	        ArrayList<User> al = new ArrayList<>();
	        
	        String[] title = {"No", "�з�", "����Ʈ","ID","PW","Name","PW_������","e-mail","�ּ�","��Ÿ"}; //���̺� �÷� �̸� ���� 
	        DefaultTableModel model = new DefaultTableModel(title, 0) //table�𵨿� title ����
	        		{ //���̺� ����Ŭ���ؼ� ������ �Ұ��ϵ��� �ϴ� �ڵ� 
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
	        if(me_name.equals("All")==true) //���� �޾ƿ� �̸����� All�̶�� 
	        {
	        	al=pf.user_info_AllSelect(id); //��������� select �ؼ� ��̿� ���� 
	        }
	        else
	        {
	        	al = tm.tab_menu_select(me_name,id); //All�� �ƴ϶�� ���̸��� ���� ������ ������ �����鸸 ������ 
	        }
	        
	        String[] rows = new String[title.length]; //row(��) ��ŭ �迭 ����
	        for(int i =0;i<al.size();i++) //��� ũ�⸸ŭ for�� �ݺ� �ش� ���� ����
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
	        table= new JTable(model); //���̺� ���� 
	        table_set();
	        setLayout(null);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        scroll =new JScrollPane(table);
	        scroll.setBounds(20, 78, 825, 450);	            //�פ��̺� ������      
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
	        
	        
	      //�˻��ϱ� ���� ������ (����)
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
		   JTableHeader header= table.getTableHeader(); 	//���̺� ��� (�� �÷��κ� ���� ����)
		   header.setBackground(Color.DARK_GRAY);
		   header.setForeground(Color.white);
		   
	       Font font = new Font("���� ���", Font.PLAIN, 12);
		  table.setRowHeight(30); 
		  table.setFont(font);
		  table.setPreferredScrollableViewportSize(new Dimension(602,231));  //58���� ��ũ���̶� ����� 
		   DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		   celAlignCenter.setHorizontalAlignment(JLabel.CENTER); 					//����� ���� 
		   DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		   celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		   table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   
		   table.getColumn("No").setPreferredWidth(44); 				//�� �÷� ũ�� ���� 
		   table.getColumn("No").setCellRenderer(celAlignCenter);;
		   table.getColumn("�з�").setPreferredWidth(60);
		   table.getColumn("�з�").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("����Ʈ").setPreferredWidth(115);
		   table.getColumn("����Ʈ").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("ID").setPreferredWidth(100);
		   table.getColumn("ID").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("PW").setPreferredWidth(100);
		   table.getColumn("PW").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("Name").setPreferredWidth(100);
		   table.getColumn("Name").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("e-mail").setPreferredWidth(200);
		   table.getColumn("e-mail").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("PW_������").setPreferredWidth(120);
		   table.getColumn("PW_������").setCellRenderer(celAlignCenter);;
		   
		   table.getColumn("�ּ�").setPreferredWidth(200);
		   table.getColumn("�ּ�").setCellRenderer(celAlignCenter);;
		   
		   //�÷��� �����Ͽ����� 
		   table.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					  int row = table.getSelectedRow();
					  int col = table.getSelectedColumn();
					  if(col==9||col==0) //0��° �÷�, 9��° �÷��� �����ϸ� �������� ��Ÿ�� 
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



	