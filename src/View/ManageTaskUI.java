package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ManageTaskUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JList list;
	private JButton btnClose;

	public ManageTaskUI() {
		initialize();
	}
	
	private void initialize() 
	{
		frame = new JFrame("Manage Task");
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.setBackground(new Color(50, 205, 50));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(22, 13, 188, 60);
		btnSave.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnSave.setBackground(Color.WHITE);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(220, 13, 188, 60);
		btnReset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReset.setBackground(Color.WHITE);
		frame.getContentPane().add(btnReset);
		
		btnClose = new JButton("Back");
		btnClose.setBounds(418, 13, 188, 60);
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnClose.setBackground(Color.WHITE);
		frame.getContentPane().add(btnClose);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(50, 205, 50));
		panel_1.setBounds(22, 84, 1324, 298);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1300, 276);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblProject = new JLabel("Project");
		lblProject.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblProject.setBounds(130, 45, 59, 24);
		panel.add(lblProject);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblType.setBounds(130, 109, 46, 24);
		panel.add(lblType);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblCategories.setBounds(659, 45, 101, 24);
		panel.add(lblCategories);
		
		JLabel lblAssignedEmployees = new JLabel("Assign Employee");
		lblAssignedEmployees.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblAssignedEmployees.setBounds(659, 109, 142, 24);
		panel.add(lblAssignedEmployees);
		
		JLabel lblTask = new JLabel("Task");
		lblTask.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblTask.setBounds(130, 217, 46, 24);
		panel.add(lblTask);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Project1", "Project2", "Project3"}));
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		comboBox.setBounds(235, 45, 220, 24);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Type1", "Type2", "Type3"}));
		comboBox_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		comboBox_1.setBounds(235, 109, 220, 24);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Category1", "Catergory2", "Category3"}));
		comboBox_2.setBounds(880, 47, 220, 24);
		panel.add(comboBox_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(880, 111, 220, 143);
		panel.add(scrollPane);
		
		list = new JList();
		list.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		textField.setBounds(235, 219, 566, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(50, 205, 50));
		panel_2.setBounds(22, 393, 1324, 301);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 1304, 279);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblScheduleDate = new JLabel("Schedule Date");
		lblScheduleDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblScheduleDate.setBounds(76, 46, 108, 24);
		panel_3.add(lblScheduleDate);
		
		JLabel lblNewLabel = new JLabel("Duration");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(76, 153, 108, 24);
		panel_3.add(lblNewLabel);
		
		JLabel lblWorkingHours = new JLabel("Working Hours");
		lblWorkingHours.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblWorkingHours.setBounds(76, 207, 108, 24);
		panel_3.add(lblWorkingHours);
		
		JLabel lblNewLabel_1 = new JLabel("Expiration Date");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(76, 100, 122, 24);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(228, 48, 180, 24);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(228, 102, 180, 24);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(228, 155, 100, 24);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(228, 209, 100, 24);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		frame.setVisible(true);
	}
	public JList getJList()
	{
		return this.list;
	}
	public void addActionListener()
	{
	}
}
