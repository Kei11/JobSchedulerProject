package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.TaskDA;
import Model.User;
import View.MainUI;
import View.ViewTaskUI;

public class ViewTaskCtrl 
{
	private User user;
	private ViewTaskUI vtUI;
	private DefaultTableModel tableModel;
	TaskDA taskDA = new TaskDA();
	
	public ViewTaskCtrl(User user, ViewTaskUI vtUI) throws Exception
	{
		this.user = user;
		this.vtUI = vtUI;
		
		this.vtUI.addActionListener(new Action());
		addDataToTable();
	}
	class Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(vtUI.getBackBtn()))
			{
				showMainMenu();
			}
		}
		
	}
	public void showMainMenu() 
	{
		MainUI mainUI = new MainUI();
		
		MainCtrl mainCtrl = new MainCtrl(user, mainUI);
		
		vtUI.dispose();
	}
	public void setTableModel() 
	{
		String col[] = {"Emp. ID", "Emp. Name", "Task", "Description", "Start Date", "End Date", "Leader"};
		tableModel = new DefaultTableModel(col, 0);
		vtUI.getTable().setModel(tableModel);
	}
	public void addDataToTable() throws Exception
	{
		setTableModel();
		
		ArrayList<String> viewList = taskDA.getViewTaskList();
		for(int ctr=0; ctr<viewList.size();ctr++)
		{
			Object[] data = {viewList.get(ctr), viewList.get(ctr+1), viewList.get(ctr+2), viewList.get(ctr+3), viewList.get(ctr+4), 
					viewList.get(ctr+5),  viewList.get(ctr+6)};
			ctr+=6;
			
			tableModel.addRow(data);
			tableModel.fireTableDataChanged();
		}
	}
}
