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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DatabaseQuery.PmUserFind;
import Main.User;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DetailDialog extends JDialog {

	private  JPanel contentPanel = new JPanel();
	private ArrayList<User> al = new ArrayList<>();
	private String ad = null;
	private final JLabel lblNewLabel_5 = new JLabel("±âÅ¸");
	
/*
	public static void main(String[] args) {
		try {
		//	DetailDialog dialog = new DetailDialog();
		//	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//	dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/

	public DetailDialog(int tem_num) {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);           			//¸ð´ÞÇü½ÄÀ¸·Î ¸ð´ÞÀº ÇöÀçÃ¢ÀÌ ´Ý±âÀü±îÁö ´Ù¸¥Çàµ¿À» ¸øÇÔ.
		setBounds(228, 100, 359, 707); //À§Ä¡ ¹× Å©±â 
		setLocationRelativeTo(null); 	//À©µµ¿ìÃ¢ °¡¿îµ¥ ¶ç¿ò 
		setResizable(false);                //Å©±âÁ¶Àý ¸øÇÏ°Ô 
		PmUserFind pm =new PmUserFind();
		al= pm.Detail_info_select(tem_num); //ÇØ´ç ÀÏ·Ã¹øÈ£ÀÇ Á¤º¸¸¦ ºÒ·¯¿È.
		one();
	}
	
	private void one()
	{
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 341, 670);
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
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 0, 165, 51);
		
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(5, 57, 330, 456);
		contentPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2,0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\uC77C\uB828\uBC88\uD638");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		JLabel label1 = new JLabel("New label");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_2);
		
		
		JLabel label2 = new JLabel("New label");
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label2);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_4);
		
		JLabel label3 = new JLabel("New label");
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label3);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uC0AC\uC774\uD2B8 \uC774\uB984");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_4_1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel_1.add(lblNewLabel_4_1);
		
		JLabel sitename = new JLabel("New label");
		sitename.setHorizontalAlignment(SwingConstants.CENTER);
		sitename.setForeground(Color.WHITE);
		sitename.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		panel_1.add(sitename);
		
		JLabel lblNewLabel_6 = new JLabel("\uAC00\uC785\uC774\uB984");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_6);
		
		JLabel label4 = new JLabel("New label");
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label4);
		
		JLabel lblNewLabel_11 = new JLabel("Email");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_11);
		
		JLabel label5 = new JLabel("New label");
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label5);
		
		JLabel lblNewLabel_10 = new JLabel("\uAC00\uC785\uC77C \uB610\uB294 \uBCC0\uACBD\uC77C");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_10);
		
		JLabel label6 = new JLabel("New label");
		label6.setForeground(Color.WHITE);
		label6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label6);
		
		JLabel lblNewLabel_12 = new JLabel("\uBD84\uB958");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_12);
		
		JLabel label7 = new JLabel("New label");
		label7.setForeground(Color.WHITE);
		label7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label7);
		
		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)) );

		panel_1.add(lblNewLabel_1);
		
		JLabel label8 = new JLabel("New label");
		label8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setForeground(UIManager.getColor("Menu.acceleratorForeground"));
		panel_1.add(label8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(5, 513, 330, 147);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(132, 10, 64, 32);
		panel_2.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 46, 306, 87);
		panel_2.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setLineWrap(true); //ÀÚµ¿ ÁÙ¹Ù²Þ
		textArea.disable();
		textArea.setDisabledTextColor(Color.white);
		scrollPane.setViewportView(textArea);
		
		for(int i =0; i<al.size();i++) //°¢ Text°ª¿¡ ºÒ·¯¿Â Á¤º¸¸¦ »ðÀÔ 
		{
				label1.setText(Integer.toString(al.get(i).getTem_num()));
				label2.setText(al.get(i).getPage_id());
				label3.setText(al.get(i).getPage_password());
				label4.setText(al.get(i).getPage_name());
				label5.setText(al.get(i).getPage_email());
				label6.setText(al.get(i).getSingupdate());
				label7.setText(al.get(i).getDivision());
				label8.setText(al.get(i).getPageaddress());
				textArea.setText(al.get(i).getRemarks());
				sitename.setText(al.get(i).getWebsitename());
				ad=al.get(i).getPageaddress();
		}
		
		label8.addMouseListener(new MouseAdapter() { //¹öÆ° ¸¶¿ì½º Å¬¸¯ÀÌº¥Æ®
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
					   if (e.getClickCount() == 1) {
							Desktop.getDesktop().browse(new URI(ad)); //ÇØ´çÁÖ¼Ò·Î ÀÌµ¿ 
	        	        } else if (e.getClickCount() == 3) {

	        	        }
					 
				} catch (IOException | URISyntaxException e1) {
					// TODO ÀÚµ¿ »ý¼ºµÈ catch ºí·Ï
					e1.printStackTrace();
				}
			}
		});
		
	}
}
