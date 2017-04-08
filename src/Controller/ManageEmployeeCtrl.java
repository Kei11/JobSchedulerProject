package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.h2.jdbc.JdbcSQLException;

import Model.User;
import Model.UserDA;
import View.MainUI;
import View.ManageEmployeeUI;

public class ManageEmployeeCtrl 
{
	private ManageEmployeeUI meUI;
	private User user;
	private DefaultTableModel tableModel;
	private int data;
	private int columnNames;
	UserDA userDA = new UserDA();
	
	public ManageEmployeeCtrl(User user, ManageEmployeeUI meUI) throws Exception
	{
		this.user = user;
		this.meUI = meUI;
		
		this.meUI.addActionListener(new Action());
		this.meUI.addMouseListener(new Action());
		this.addDataToTable();
	}
	class Action implements ActionListener, MouseListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(meUI.getSaveBtn()))
			{
				try {
					if(meUI.getID().getText().equals(""))
					{
						if(checkTextfieldsIfEmpty())
							meUI.displayMessage("Please fill up all fields", "Error");
						else
							addAccount();
					}
					else
						if(checkTextfieldsIfEmpty())
							meUI.displayMessage("Please fill up all fields", "Error");
							
						else
							updateDetails();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			else if(e.getSource().equals(meUI.getBackBtn()))
			{
				MainUI mainUI = new MainUI();
				
				MainCtrl mainCtrl = new MainCtrl(user, mainUI);
				
				meUI.dispose();
			}
			else if(e.getSource().equals(meUI.getBtnDelete()))
			{
				try {
					if(confirmDelete())
					{
						deleteUser();
						clearTextFields();
						addDataToTable();
						meUI.displayMessage("User successfully deleted", "Success");
					}
				}
				catch(JdbcSQLException e1)
				{
					meUI.displayMessage("Error deleting the data", "Error");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(meUI.getResetBtn()))
			{
				clearTextFields();
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			int i = meUI.getTable().getSelectedRow();
			
			meUI.getID().setText(tableModel.getValueAt(i, 0).toString());
			meUI.getTitle().setText(tableModel.getValueAt(i, 2).toString());
			meUI.getName().setText(tableModel.getValueAt(i, 1).toString());
			meUI.getEmail().setText(tableModel.getValueAt(i, 3).toString());
			meUI.getUsername().setText(tableModel.getValueAt(i, 4).toString());
			meUI.getPassword().setText(tableModel.getValueAt(i, 5).toString());
			meUI.getUserTypeCB().setSelectedItem(tableModel.getValueAt(i, 6).toString());
			meUI.getMobile().setText(tableModel.getValueAt(i, 7).toString());
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {	
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	public void clearTextFields()
	{
		meUI.getTitle().setText("");
		meUI.getName().setText("");
		meUI.getMobile().setText("");
		meUI.getEmail().setText("");
		meUI.getUsername().setText("");
		meUI.getPassword().setText("");
		meUI.getID().setText("");
		meUI.getUserTypeCB().setSelectedIndex(0);
	}
	public void deleteUser() throws Exception
	{
		String id = meUI.getID().getText();
		
		userDA.deleteUserFromDB(id);
	}
	public void updateDetails() throws Exception
	{
			ArrayList userList = userDA.getUserDetails();
			userList.remove(meUI.getUsername().getText());
			
			if(!userList.contains(meUI.getUsername().getText()))
			{
				String title = meUI.getTitle().getText();
				int mobNo = Integer.parseInt(meUI.getMobile().getText());
				String email = meUI.getEmail().getText();
				String empName = meUI.getName().getText();
				String password = meUI.getPassword().getText();
				String userType = meUI.getUserType();
				String username = meUI.getUsername().getText();
				String id = meUI.getID().getText();
				
				userDA.updateDetails(empName, title, email, username, password, userType, mobNo, id);
				addDataToTable();
				meUI.displayMessage("Updated successfully!" , "Success!");
			}
			else
				meUI.displayMessage("Username is already taken.", "Error");
			
		
	}
	public void addAccount() throws Exception
	{
		try
		{
			ArrayList userList = userDA.getUserDetails();
			if(!userList.contains(meUI.getUsername().getText()))
			{
				String title = meUI.getTitle().getText();
				int mobNo = Integer.parseInt(meUI.getMobile().getText());
				String email = meUI.getEmail().getText();
				String empName = meUI.getName().getText();
				String password = meUI.getPassword().getText();
				String userType = meUI.getUserType();
				String username = meUI.getUsername().getText();
				
				userDA.addAcountToDB(empName, title, email, username, password, userType, mobNo);
				addDataToTable();
				meUI.displayMessage("User added successfully!" , "Success!");
			}
			else
				meUI.displayMessage("Username is already taken.", "Error");
			
		}
		catch (NumberFormatException e){
			meUI.displayMessage("Please enter a valid mobile no." , "Error");
		}
	}
	public void setTableModel()
	{
		String col[] = {"ID", "Employee Name", "Title", "Email","Username", "Password", "User Type", "Mobile No."};
		tableModel = new DefaultTableModel(col, 0);
		meUI.getTable().setModel(tableModel);
		meUI.getTable().getColumnModel().getColumn(0).setPreferredWidth(5);
		meUI.getTable().getColumnModel().getColumn(2).setPreferredWidth(175);
		meUI.getTable().getColumnModel().getColumn(3).setPreferredWidth(150);
		meUI.getTable().getColumnModel().getColumn(1).setPreferredWidth(125);
	}
	public void addDataToTable() throws Exception
	{
		setTableModel();
		ArrayList<String> userList = userDA.getUserDetails();
		
		for(int ctr=0; ctr<userList.size();ctr++)
		{
			Object[] data = {userList.get(ctr), userList.get(ctr+1), userList.get(ctr+2), userList.get(ctr+3), userList.get(ctr+4), 
					userList.get(ctr+5),  userList.get(ctr+6),
						userList.get(ctr+7)};
			ctr+=7;
			
			tableModel.addRow(data);
			tableModel.fireTableDataChanged();
		}
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
	public boolean checkTextfieldsIfEmpty()
	{
		boolean isEmpty;
		
		if(!meUI.getName().getText().equals("") && !meUI.getMobile().getText().equals("") && !meUI.getTitle().getText().equals("")
				&& !meUI.getEmail().getText().equals("") && !meUI.getUsername().getText().equals("") && !meUI.getPassword().getText().equals(""))
			isEmpty=false;
		else
			isEmpty=true;
		
		return isEmpty;
	}
}
