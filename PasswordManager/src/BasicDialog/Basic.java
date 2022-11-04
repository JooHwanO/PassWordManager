package BasicDialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Basic extends JDialog {

	private  JPanel contentPanel = new JPanel();
	 /*
	public static void main(String[] args) {
		try {
			Basic dialog = new Basic("zzz");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Basic(String str) {
		setTitle("Message");
		setBackground(Color.WHITE);
		setBounds(100, 100, 310, 138);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel);
		contentPanel.setBounds(1, 0, 300, 100);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 26, 276, 23);
		contentPanel.add(lblNewLabel);
		
		JButton okButton = new JButton("OK");               //오케이 누를시 창 꺼짐 
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okButton.setBackground(Color.LIGHT_GRAY);
		okButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		okButton.setBounds(120, 67, 60, 25);
		okButton.setActionCommand("OK");
		contentPanel.add(okButton);
		
	    setLocationRelativeTo(null);            //윈도우창 가운데 띄움 
		setResizable(false);                    //크기조절 못하게 
		setModal(true);                          //모달형태의 다이얼로그
	
	}
	
	
}
