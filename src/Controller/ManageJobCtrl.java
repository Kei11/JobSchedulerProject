package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.h2.jdbc.JdbcSQLException;

import Model.TaskDA;
import Model.User;
import Model.UserDA;
import View.MainUI;
import View.ManageJobUI;

public class ManageJobCtrl 
{
	private User user;
	private ManageJobUI mjUI;
	private DefaultTableModel tableModel;
	private DefaultListModel<String> listModel;
	TaskDA taskDA = new TaskDA();
	
	public ManageJobCtrl(User user, ManageJobUI mjUI) throws Exception
	{
		this.user = user;
		this.mjUI = mjUI;
		
		this.mjUI.addActionListener(new Action());
		this.mjUI.addMouseListener(new Action());
		this.addTaskToTable();
		
		UserDA userDA = new UserDA();
		this.addDataToJList(userDA.getEmployeeNames());
	}
	class Action implements ActionListener, MouseListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(mjUI.getBtnClose()))
			{
				showMainMenu();
			}
			else if(e.getSource().equals(mjUI.getBtnSave()))
			{
				try {
					if(mjUI.getTaskIdTF().getText().equals(""))
					{
						if(!checkFieldsIfEmpty())
						{
							String listString = "";
							
							List<String> memList = new ArrayList<String>();
							memList = mjUI.getJList().getSelectedValuesList();
							
							if(memList.contains(mjUI.getLeaderTF().getText()))
							{
								addTaskToDB();
								addTaskToUser(memList);
							}
								
							else
								mjUI.displayMessage("Task leader name is invalid", "Error");
							
						}
							
						else
							mjUI.displayMessage("Please fill up all fields", "Error");
					}
					else
						updateTaskDetails();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(mjUI.getBtnReset()))
			{
				clearTextFields();
			}
			else if(e.getSource().equals(mjUI.getBtnDelete()))
			{
				if(confirmDelete())
				{
					try {
						deleteUser();
						clearTextFields();
						addTaskToTable();
						mjUI.displayMessage("Task successfully deleted", "Success");
					} catch(JdbcSQLException e1){
						mjUI.displayMessage("Error deleting the data", "Error");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int i = mjUI.getTable().getSelectedRow();
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = null;
			Date end = null;
			try {
				start = format.parse(tableModel.getValueAt(i, 3).toString());
				end = format.parse(tableModel.getValueAt(i, 4).toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			mjUI.getTaskIdTF().setText(tableModel.getValueAt(i, 0).toString());
			mjUI.getTaskNameTF().setText(tableModel.getValueAt(i, 1).toString());
			mjUI.getDescTF().setText(tableModel.getValueAt(i, 2).toString());
			mjUI.getStartDate().setDate(start);
			mjUI.getEndDate().setDate(end);
			mjUI.getLeaderTF().setText(tableModel.getValueAt(i, 5).toString());
			try {
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				UserDA userDA = new UserDA();
				addDataToJList(userDA.getAssignedEmployee(mjUI.getTaskNameTF().getText()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public void deleteUser() throws Exception
	{
		String id =mjUI.getTaskIdTF().getText();
		
		taskDA.deleteDataFromDB(id);
	}
	public boolean confirmDelete()
	{
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete this user?","Warning",dialogButton);
		
		if(dialogResult == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
		
	}
	public void setTableModel()
	{
		String col[] = {"TaskID", "Task Name", "Description", "Start Date", "End Date", "Task Leader"};
		tableModel = new DefaultTableModel(col, 0);
		mjUI.getTable().setModel(tableModel);
	}
	public void addDataToJList(ArrayList<String> list) throws Exception
	{
		listModel = new DefaultListModel<>();
		mjUI.getJList().setModel(listModel);
		listModel.removeAllElements();
		
		
		for(int ctr=0; ctr<list.size(); ctr++)
		{
			listModel.addElement(list.get(ctr));
		}
	}
	public void addTaskToTable() throws Exception
	{
		setTableModel();
		
		ArrayList<String> taskList = taskDA.getTaskDetails();
		
		for(int ctr=0; ctr<taskList.size(); ctr++)
		{
			Object[] data = {taskList.get(ctr), taskList.get(ctr+1), taskList.get(ctr+2), taskList.get(ctr+3), taskList.get(ctr+4), 
					taskList.get(ctr+5)};
			
			ctr+=5;
			
			tableModel.addRow(data);
			tableModel.fireTableDataChanged();
		}
	}
	public void updateTaskDetails() throws Exception
	{
		try
		{
			String name = mjUI.getTaskNameTF().getText();
			String desc = mjUI.getDescTF().getText();
			Date start = mjUI.getStartDate().getDate();
			Date end = mjUI.getEndDate().getDate();
			String leader = mjUI.getLeaderTF().getText();
			String id = mjUI.getTaskIdTF().getText();
				
			taskDA.updateTaskDetails(name, desc, start, end, leader, id);
			addTaskToTable();
			mjUI.displayMessage("Updated successfully!" , "Success!");
		}
		catch(NullPointerException e)
		{
			mjUI.displayMessage("Please fill up the date field", "Error");
		}
		
	}
	public void addTaskToUser(List<String> memList) throws Exception
	{
		UserDA userDA = new UserDA();
		for(int ctr=0;ctr<memList.size();ctr++)
		{
			
			userDA.addTaskToUser(mjUI.getTaskNameTF().getText(), memList.get(ctr));
		}
		
	}
	public void addTaskToDB() throws Exception
	{
		try
		{
			String name = mjUI.getTaskNameTF().getText();
			String desc = mjUI.getDescTF().getText();
			Date start = mjUI.getStartDate().getDate();
			Date end = mjUI.getEndDate().getDate();
			String leader = mjUI.getLeaderTF().getText();
			
			String listString = "";
			
			List<String> memList = new ArrayList<String>();
			memList = mjUI.getJList().getSelectedValuesList();
			for (String s : memList)
			{
			    listString += s + ", ";
			}
			String members = listString;
			
			taskDA.addTaskToDB(name, desc, start, end, leader, members);
			addTaskToTable();
			mjUI.displayMessage("Task added successfully!" , "Success!");
		}
		catch(NullPointerException e)
		{
			mjUI.displayMessage("Please fill up the date field", "Error");
		}
			
		
	}
	public boolean checkFieldsIfEmpty()
	{	
		boolean isEmpty;
		
		if(mjUI.getTaskNameTF().getText().equals("") && mjUI.getTaskNameTF().getText().equals("") && mjUI.getTaskNameTF().getText().equals(""))
			isEmpty=true;
		else
			isEmpty=false;
		
		return isEmpty;
	}
	public void showMainMenu() 
	{
		MainUI mainUI = new MainUI();
		MainCtrl mainCtrl = new MainCtrl(user, mainUI);
		
		mjUI.dispose();
	}	
	public void clearTextFields()
	{
		mjUI.getTaskIdTF().setText("");
		mjUI.getTaskNameTF().setText("");
		mjUI.getDescTF().setText("");
		mjUI.getStartDate().setCalendar(null);
		mjUI.getEndDate().setCalendar(null);
		mjUI.getLeaderTF().setText("");
		
		UserDA userDA = new UserDA();
		try {
			addDataToJList(userDA.getEmployeeNames());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
