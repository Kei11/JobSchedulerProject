package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LoginUI
{
	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JLabel lblJobSchedulerSystem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginUI() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Login");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(585, 379, 250, 65);
		btnLogin.setBackground(new Color(51, 204, 51));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		btnLogin.setBorder(new LineBorder(new Color(0, 153, 0), 5, true));
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(532, 273, 351, 42);
		txtUsername.setForeground(SystemColor.activeCaptionBorder);
		txtUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		txtUsername.setText("Username");
		txtUsername.setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(532, 326, 351, 42);
		txtPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		txtPassword.setText("Password");
		txtPassword.setBackground(SystemColor.inactiveCaptionBorder);
		txtPassword.setForeground(SystemColor.activeCaptionBorder);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBounds(436, 176, 532, 380);
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), null, null));
		lblNewLabel.setIcon(new ImageIcon("image/tuding.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Logo = new JLabel("");
		Logo.setBounds(1102, 482, 260, 222);
		Logo.setIcon(new ImageIcon("image/scheduler.jpg"));
		
		frame.getContentPane().add(Logo);
		
		lblJobSchedulerSystem = new JLabel("Job Scheduler System");
		lblJobSchedulerSystem.setBounds(368, 51, 674, 126);
		lblJobSchedulerSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblJobSchedulerSystem.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
		frame.getContentPane().add(lblJobSchedulerSystem);
		frame.setVisible(true);	
	}
	public JButton getButton()
	{
		return btnLogin;
	}
	public String getUserName()
	{
		return this.txtUsername.getText();
	}
	public String getPassword()
	{
		return this.txtPassword.getText();
	}
	public JTextField getUsernameTF()
	{
		return this.txtUsername;
	}
	public JTextField getPasswordTF()
	{
		return this.txtPassword;
	}
	public void addActionListener(ActionListener action)
	{
		this.btnLogin.addActionListener(action);
	}
	public void addMouseListener(MouseListener l)
	{
		this.txtUsername.addMouseListener(l);
		this.txtPassword.addMouseListener(l);
	}
	public void addKeyListener(KeyListener l)
	{
		this.txtPassword.addKeyListener(l);
		this.txtUsername.addKeyListener(l);
	}
	public void dispose()
	{
		frame.dispose();
	}
	public void displayErrorMessage(String errorMessage, String title)
	{
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
