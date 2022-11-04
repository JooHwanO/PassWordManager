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
		tab.add("전체", new TabDataSelect("All",resultid)); //모든정보 테이블 생성 
		
		for(int i =0; i<tab_menu_distinct.size();i ++) 
		{
			tab.addTab(tab_menu_distinct.get(i),new TabDataSelect(tab_menu_distinct.get(i),resultid)); //메뉴에맞는 테이블 생성 	
		}
	}
	
	
	
	private void tab_menu()
	{
		for(int i =0; i<mArrayList.size();i++)
		{
			tab_menu_distinct.add(mArrayList.get(i).getDivision()); //DB 분류만 
		}
		tab_menu_distinct = tab_menu_distinct.stream().distinct().collect(Collectors.toList()); //중복 제거후 다시 담기 
	}
	
	
	/*
	class UI extends BasicTabbedPaneUI
	{

		@Override
		protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
			// TODO Auto-generated method stub
			//보통 보이는 부분 여기서 그려주고
			g.setColor(Color.white);
			g.drawRoundRect(x, y, w, h, 5, 5);
			if (isSelected)
			{//여기는 선택시 보여주는 부분을 그려주면 됩니다.   
				g.setColor(Color.black);
				g.drawLine(x+15 , y+15 ,  x+w-15 , y+15); 
			}
		}
	}
*/
	
}
