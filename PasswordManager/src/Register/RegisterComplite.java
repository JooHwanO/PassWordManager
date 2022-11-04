package Register;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import BasicDialog.Basic;
import DatabaseQuery.RegisterInsertQuery;

public class RegisterComplite extends JDialog  {

	private final JPanel contentPanel = new JPanel();
	private final JButton okButton = new JButton("OK");
	private  String id_insert;
	private  String check_insert;
	private  String name_insert;
	private  String ph_insert1;
	private  String ph_insert2;
	private  String ph_insert3;
	private String phone;
	private int ok= 0;
	private Basic bc= null;
	
	public RegisterComplite( String id_insert,String check_insert,String name_insert, String ph_insert1,String ph_insert2,String ph_insert3) {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Password Manager");
		this.id_insert=id_insert;
		this. check_insert=check_insert;
		this. name_insert=name_insert;
		this.ph_insert1=ph_insert1;
		this.ph_insert2=ph_insert2;
		this.ph_insert3=ph_insert3;
		
		 phone=this.ph_insert1+"-"+this.ph_insert2+"-"+this.ph_insert3; //�ڵ��� ��ȣ �̾���̱� 
		 
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 138);
		getContentPane().setLayout(null);
		
		contentPanel.setBounds(1, 0, 300, 100);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("�ش� ������ �Է��Ͻðڽ��ϱ�?");
			lblNewLabel.setBounds(22, 26, 246, 23);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		
		okButton.setBounds(79, 59, 60, 23);
		contentPanel.add(okButton);
		okButton.setFont(new Font("���� ���", Font.PLAIN, 12));
		okButton.setForeground(Color.BLACK);
		okButton.setBackground(Color.LIGHT_GRAY);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterInsertQuery RI=new  RegisterInsertQuery();
				int t = RI.insert(id_insert, check_insert, name_insert, phone); //���� 
				if(t==1)																					//�����ΰ��1�� ��ȯ 
				{
					bc=new Basic("ȸ������ �Ϸ�");
					bc.setVisible(true);
					ok=1; //Ȯ���� ������� �θ�â�� Register_Dialog�� �����ϱ����� getter�� 1�� ���� ���� �����Ѵ�
					dispose();
				}
				else if(t==0)
				{
					bc=new Basic("�޴���ȭ�� �̹� �����մϴ�.");
					bc.setVisible(true);
					ok=0;
					dispose();
				}
			}
		});
		
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(145, 59, 80, 23);
			contentPanel.add(cancelButton);
			cancelButton.setFont(new Font("���� ���", Font.PLAIN, 12));
			cancelButton.setForeground(Color.BLACK);
			cancelButton.setBackground(Color.LIGHT_GRAY);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		setModal(true); //��������� ���̾�α�
		setLocationRelativeTo(null); //������â ��� ��� 
		setResizable(false);
	}
	
	public int getOk()//ȸ�������� �����ߴ����� �ٸ� ũ������ �˸��� ����
	{
		return ok;
	}
}
