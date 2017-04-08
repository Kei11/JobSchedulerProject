package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import View.ManageEmployeeUI;
import View.ViewTaskUI;

public class MainUI {

	private JFrame frame;
	private JButton btnManageEmployees;
	private JButton btnManageProjects;
	private JButton btnExit;
	private JButton btnAssignTasks;
	private JButton btnGenerateReports;

	public MainUI() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Main");
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.setBackground(new Color(50, 205, 50));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnManageEmployees = new JButton("Manage Employees");
		btnManageEmployees.setForeground(new Color(0, 0, 0));
		btnManageEmployees.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnManageEmployees.setBounds(66, 64, 200, 70);
		btnManageEmployees.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnManageEmployees);
		
		btnManageProjects = new JButton("Manage Projects");
		btnManageProjects.setForeground(new Color(0, 0, 0));
		btnManageProjects.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnManageProjects.setBounds(66, 164, 200, 70);
		btnManageProjects.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnManageProjects);
		
		btnAssignTasks = new JButton("View Tasks");
		btnAssignTasks.setForeground(new Color(0, 0, 0));
		btnAssignTasks.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnAssignTasks.setBounds(66, 264, 200, 70);
		btnAssignTasks.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnAssignTasks);
		
		btnGenerateReports = new JButton("Generate Reports");
		btnGenerateReports.setForeground(new Color(0, 0, 0));
		btnGenerateReports.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnGenerateReports.setBounds(66, 364, 200, 70);
		btnGenerateReports.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnGenerateReports);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnExit.setBounds(66, 582, 200, 70);
		btnExit.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnExit);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(50, 205, 50));
		lblNewLabel.setBounds(503, 132, 828, 421);
		lblNewLabel.setIcon(new ImageIcon("image/jobMain.png"));
		frame.getContentPane().add(lblNewLabel);
		
		
		
		frame.setVisible(true);
	}
	public JButton getViewTaskBtn()
	{
		return this.btnAssignTasks;
	}
	public JButton getManageEmployeeBtn()
	{
		return this.btnManageEmployees;
	}
	public JButton getManageTaskBtn()
	{
		return this.btnManageProjects;
	}
	public JButton getExitBtn()
	{
		return this.btnExit;
	}
	public JButton getGenReportBtn()
	{
		return this.btnGenerateReports;
	}
	public void addActionListener(ActionListener l)
	{
		this.btnManageEmployees.addActionListener(l);
		this.btnManageProjects.addActionListener(l);
		this.btnAssignTasks.addActionListener(l);
		this.btnExit.addActionListener(l);
		this.btnGenerateReports.addActionListener(l);
	}
	public void dispose()
	{
		frame.dispose();
	}
}
