package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenReportUI {

	private JFrame frame;
	private JButton btnEmpList;
	private JButton btnTaskList;
	private JButton btnBack;
	private JButton btnEmpTask;
	
	public GenReportUI() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame("Generate Report");
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		btnEmpList = new JButton("Employee List");
		btnEmpList.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnEmpList.setBackground(Color.WHITE);
		btnEmpList.setBounds(10, 30, 245, 75);
		frame.getContentPane().add(btnEmpList);
		
		btnTaskList = new JButton("Task List");
		btnTaskList.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnTaskList.setBackground(Color.WHITE);
		btnTaskList.setBounds(10, 116, 245, 75);
		frame.getContentPane().add(btnTaskList);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 288, 245, 75);
		frame.getContentPane().add(btnBack);
		
		btnEmpTask = new JButton("Employee's Task");
		btnEmpTask.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnEmpTask.setBackground(Color.WHITE);
		btnEmpTask.setBounds(10, 202, 245, 75);
		frame.getContentPane().add(btnEmpTask);
		frame.setBounds(100, 100, 271, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	public JButton getEmployeeListBtn()
	{
		return this.btnEmpList;
	}
	public JButton getTaskListBtn()
	{
		return this.btnTaskList;
	}
	public JButton getBackBtn()
	{
		return this.btnBack;
	}
	public JButton getEmpTaskBtn()
	{
		return this.btnEmpTask;
	}
	public void dispose()
	{
		frame.dispose();
	}
	public void addActionListener(ActionListener l)
	{
		this.btnEmpList.addActionListener(l);
		this.btnTaskList.addActionListener(l);
		this.btnBack.addActionListener(l);
		this.btnEmpTask.addActionListener(l);
	}
}
