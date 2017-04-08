package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewTaskUI {

	private JFrame frame;
	private JTable table;
	private JButton btnReset;

	public ViewTaskUI() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("View Task");
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.getContentPane().setLayout(null);
		
		btnReset = new JButton("Back");
		btnReset.setBounds(1119, 44, 188, 60);
		btnReset.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReset.setBackground(Color.WHITE);
		frame.getContentPane().add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setForeground(new Color(50, 205, 50));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 161, 1336, 504);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1316, 482);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEmployeesTask = new JLabel("EMPLOYEES TASK");
		lblEmployeesTask.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		lblEmployeesTask.setBounds(361, 57, 485, 51);
		frame.getContentPane().add(lblEmployeesTask);
		frame.setBackground(new Color(50, 205, 50));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void dispose()
	{
		frame.dispose();
	}
	public JButton getBackBtn()
	{
		return this.btnReset;
	}
	public JTable getTable()
	{
		return this.table;
	}
	public void addActionListener(ActionListener l)
	{
		this.btnReset.addActionListener(l);
	}
}
