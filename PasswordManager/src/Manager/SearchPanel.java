package Manager;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import DatabaseQuery.PmUserFind;
import Main.User;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPanel extends JPanel{

	/**
	 * Create the panel.
	 */
	TabDataSelect tds;
	public JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
	private ArrayList<User> mArrayList;
	private String resultid;
	List<String> tab_menu_distinct = new ArrayList<String>();
	PmUserFind pp = new PmUserFind();
	
	public SearchPanel(String resultid) {
		this.mArrayList =pp.user_info_AllSelect(resultid);
		this.resultid = resultid;
		display();
		setBackground(Color.DARK_GRAY);
		setBounds(158, 53, 936, 618);
		setLayout(null);
	}
	
	private void display()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(12, 10, 912, 598);
		add(panel);
		panel.setLayout(null);
		tab.setForeground(Color.BLACK);
		tab.setBackground(Color.ORANGE);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.setBounds(12, 10, 875, 578);
		//tab.setUI(new UI());
		panel.add(tab);
		
		tab_menu();
		tab.add("��ü", new TabDataSelect("All",resultid)); //������� ���̺� ���� 
		
		for(int i =0; i<tab_menu_distinct.size();i ++) 
		{
			tab.addTab(tab_menu_distinct.get(i),new TabDataSelect(tab_menu_distinct.get(i),resultid)); //�޴����´� ���̺� ���� 	
		}
	}
	
	
	
	private void tab_menu()
	{
		for(int i =0; i<mArrayList.size();i++)
		{
			tab_menu_distinct.add(mArrayList.get(i).getDivision()); //DB �з��� 
		}
		tab_menu_distinct = tab_menu_distinct.stream().distinct().collect(Collectors.toList()); //�ߺ� ������ �ٽ� ��� 
	}
	
	
	/*
	class UI extends BasicTabbedPaneUI
	{

		@Override
		protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
			// TODO Auto-generated method stub
			//���� ���̴� �κ� ���⼭ �׷��ְ�
			g.setColor(Color.white);
			g.drawRoundRect(x, y, w, h, 5, 5);
			if (isSelected)
			{//����� ���ý� �����ִ� �κ��� �׷��ָ� �˴ϴ�.   
				g.setColor(Color.black);
				g.drawLine(x+15 , y+15 ,  x+w-15 , y+15); 
			}
		}
	}
*/
	
}
