package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ManageJobUI {

	private JFrame frame;
	private JButton btnClose;
	private JTextField nameTF;
	private JTextField descTF;
	private JTable table;
	private JTextField taskIdTF;
	private JButton btnSave;
	private JButton btnReset;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JDateChooser dateChooserEnd;
	private JDateChooser dateChooserStart;
	private JTextField taskLeaderTF;
	private JList list;
	private JButton btnDelete;
	
	public ManageJobUI() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame("Manage Job");
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.setBackground(new Color(50, 205, 50));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(20, 13, 188, 60);
		btnSave.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnSave.setBackground(Color.WHITE);
		frame.getContentPane().add(btnSave);
		
		btnReset = new JButton("Clear");
		btnReset.setBounds(220, 13, 188, 60);
		btnReset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReset.setBackground(Color.WHITE);
		frame.getContentPane().add(btnReset);
		
		btnClose = new JButton("Back");
		btnClose.setBounds(1120, 13, 188, 60);
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnClose.setBackground(Color.WHITE);
		frame.getContentPane().add(btnClose);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(420, 13, 188, 60);
		btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnDelete.setBackground(Color.WHITE);
		frame.getContentPane().add(btnDelete);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(50, 205, 50));
		panel.setBounds(10, 84, 1336, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 1316, 228);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTaskName = new JLabel("Task Name");
		lblTaskName.setBounds(73, 92, 112, 24);
		panel_1.add(lblTaskName);
		lblTaskName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(73, 150, 112, 24);
		panel_1.add(lblDescription);
		lblDescription.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		nameTF = new JTextField();
		nameTF.setBounds(195, 94, 200, 24);
		panel_1.add(nameTF);
		nameTF.setColumns(10);
		
		descTF = new JTextField();
		descTF.setBounds(195, 152, 200, 24);
		panel_1.add(descTF);
		descTF.setColumns(10);
		
		JLabel lblTaskId = new JLabel("Task ID");
		lblTaskId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblTaskId.setBounds(73, 41, 112, 24);
		panel_1.add(lblTaskId);
		
		taskIdTF = new JTextField();
		taskIdTF.setEditable(false);
		taskIdTF.setBounds(195, 43, 200, 24);
		panel_1.add(taskIdTF);
		taskIdTF.setColumns(10);
		
		lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblStartDate.setBounds(501, 41, 148, 24);
		panel_1.add(lblStartDate);
		
		lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblEndDate.setBounds(501, 98, 112, 24);
		panel_1.add(lblEndDate);
		
		dateChooserStart = new JDateChooser();
		dateChooserStart.setDateFormatString("yyyy-MM-dd");
		dateChooserStart.setBounds(659, 41, 148, 24);
		panel_1.add(dateChooserStart);
		
		dateChooserEnd = new JDateChooser();
		dateChooserEnd.setDateFormatString("yyyy-MM-dd");
		dateChooserEnd.setBounds(659, 98, 148, 24);
		panel_1.add(dateChooserEnd);
		
		JLabel lblAssingLeader = new JLabel("Assign Employees");
		lblAssingLeader.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblAssingLeader.setBounds(921, 86, 136, 24);
		panel_1.add(lblAssingLeader);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1078, 21, 175, 184);
		panel_1.add(scrollPane_1);
		
		list = new JList();
		list.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		scrollPane_1.setViewportView(list);
		
		JLabel lblTaskLeader = new JLabel("Task Leader");
		lblTaskLeader.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblTaskLeader.setBounds(501, 155, 84, 14);
		panel_1.add(lblTaskLeader);
		
		taskLeaderTF = new JTextField();
		taskLeaderTF.setBounds(659, 152, 200, 24);
		panel_1.add(taskLeaderTF);
		taskLeaderTF.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(50, 205, 50));
		panel_2.setForeground(new Color(50, 205, 50));
		panel_2.setBounds(10, 345, 1336, 349);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1316, 327);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
	}
	public JTextField getTaskNameTF()
	{
		return this.nameTF;
	}
	public JTextField getTaskIdTF()
	{
		return this.taskIdTF;
	}
	public JTextField getDescTF()
	{
		return this.descTF;
	}
	public JDateChooser getStartDate()
	{
		return this.dateChooserStart;
	}
	public JDateChooser getEndDate()
	{
		return this.dateChooserEnd;
	}
	public JButton getBtnClose()
	{
		return this.btnClose;
	}
	public JButton getBtnSave()
	{
		return this.btnSave;
	}
	public JButton getBtnDelete()
	{
		return this.btnDelete;
	}
	public JButton getBtnReset()
	{
		return this.btnReset;
	}
	public void dispose()
	{
		frame.dispose();
	}
	public JTable getTable()
	{
		return this.table;
	}
	public JTextField getLeaderTF()
	{
		return this.taskLeaderTF;
	}
	public void displayMessage (String message, String title)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	public void addActionListener(ActionListener l)
	{
		this.btnClose.addActionListener(l);
		this.btnReset.addActionListener(l);
		this.btnSave.addActionListener(l);
		this.btnDelete.addActionListener(l);
	}
	public void addMouseListener(MouseListener l)
	{
		this.table.addMouseListener(l);
	}
	public JList getJList()
	{
		return this.list;
	}
}
