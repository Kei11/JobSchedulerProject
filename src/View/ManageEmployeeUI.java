package View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ManageEmployeeUI {

	private JFrame frame;
	private JTextField titleTextField;
	private JTextField mobileTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField passwordTextField;
	private JTable table_2;
	private JComboBox userTypeComboBox;
	private JButton btnSave;
	private JButton btnReset;
	private JButton btnClose;
	private JTextField usernameTextField;
	private JLabel lblUserId;
	private JTextField userIdTF;
	private JButton btnDelete;

	public ManageEmployeeUI() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Manage Employee");
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.setBackground(new Color(50, 205, 50));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnSave = new JButton("Add/Save");
		btnSave.setBounds(22, 13, 188, 60);
		btnSave.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnSave.setBackground(Color.WHITE);
		frame.getContentPane().add(btnSave);
		
		btnReset = new JButton("Clear");
		btnReset.setBounds(220, 13, 188, 60);
		btnReset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReset.setBackground(Color.WHITE);
		frame.getContentPane().add(btnReset);
		
		btnClose = new JButton("Back");
		btnClose.setBounds(1158, 13, 188, 60);
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnClose.setBackground(Color.WHITE);
		frame.getContentPane().add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 89, 1336, 223);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(50, 205, 50));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 1316, 201);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblPassword.setBounds(695, 101, 124, 24);
		panel_1.add(lblPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblUserType.setBounds(695, 150, 124, 24);
		panel_1.add(lblUserType);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(874, 103, 197, 24);
		panel_1.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		userTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin", "Proj. Manager"}));
		userTypeComboBox.setBounds(874, 150, 145, 24);
		panel_1.add(userTypeComboBox);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(119, 64, 124, 24);
		panel_1.add(lblEmployeeName);
		lblEmployeeName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(119, 138, 124, 24);
		panel_1.add(lblTitle);
		lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Mobile No.");
		lblNewLabel.setBounds(119, 99, 124, 24);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(695, 32, 124, 24);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		titleTextField = new JTextField();
		titleTextField.setBounds(296, 142, 197, 24);
		panel_1.add(titleTextField);
		titleTextField.setColumns(10);
		
		mobileTextField = new JTextField();
		mobileTextField.setBounds(296, 101, 197, 24);
		panel_1.add(mobileTextField);
		mobileTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(296, 66, 197, 24);
		panel_1.add(nameTextField);
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(872, 34, 197, 24);
		panel_1.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblUsername.setBounds(695, 66, 124, 24);
		panel_1.add(lblUsername);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(874, 68, 197, 24);
		panel_1.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblUserId.setBounds(119, 32, 89, 24);
		panel_1.add(lblUserId);
		
		userIdTF = new JTextField();
		userIdTF.setEditable(false);
		userIdTF.setBounds(296, 32, 197, 24);
		panel_1.add(userIdTF);
		userIdTF.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(50, 205, 50));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 323, 1336, 371);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1316, 349);
		panel_2.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		scrollPane.setViewportView(table_2);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnDelete.setBounds(418, 13, 188, 60);
		frame.getContentPane().add(btnDelete);
		frame.setVisible(true);
	}
	public JButton getBtnDelete()
	{
		return this.btnDelete;
	}
	public JTextField getTitle()
	{
		return this.titleTextField;
	}
	public JTextField getMobile()
	{
		return this.mobileTextField;
	}
	public JTextField getEmail()
	{
		return this.emailTextField;
	}
	public JTextField getName()
	{
		return this.nameTextField;
	}
	public JTextField getPassword()
	{
		return this.passwordTextField;
	}
	public JTextField getID()
	{
		return this.userIdTF;
	}
	public JTextField getUsername()
	{
		return this.usernameTextField;
	}
	public JComboBox getUserTypeCB()
	{
		return this.userTypeComboBox;
	}
	public String getUserType()
	{
		return String.valueOf(this.userTypeComboBox.getSelectedItem());
	}
	public JButton getSaveBtn()
	{
		return this.btnSave;
	}
	public JButton getBackBtn()
	{
		return this.btnClose;
	}
	public JButton getResetBtn()
	{
		return this.btnReset;
	}
	public void dispose()
	{
		frame.dispose();
	}
	public void displayMessage (String message, String title)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	public JTable getTable()
	{
		return this.table_2;
	}
	public void addActionListener(ActionListener l)
	{
		this.btnSave.addActionListener(l);
		this.btnClose.addActionListener(l);
		this.btnReset.addActionListener(l);
		this.btnDelete.addActionListener(l);
	}
	public void addMouseListener(MouseListener l)
	{
		this.table_2.addMouseListener(l);
	}
}
