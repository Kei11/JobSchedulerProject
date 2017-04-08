package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Reports;
import Model.User;
import View.GenReportUI;
import View.MainUI;

public class GenReportCtrl 
{
	private User user;
	private GenReportUI grUI;
	Reports reports = new Reports();
	
	public GenReportCtrl(User user, GenReportUI grUI)
	{
		this.user = user;
		this.grUI = grUI;
		
		this.grUI.addActionListener(new Action());
	}
	class Action implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(grUI.getEmployeeListBtn()))
			{
				try {
					reports.viewUserList();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(grUI.getTaskListBtn()))
			{
				try {
					reports.viewTaskList();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(grUI.getBackBtn()))
			{
				MainUI mainUI = new MainUI();
				MainCtrl mainCtrl = new MainCtrl(user, mainUI);
				
				grUI.dispose();
			}
			else if(e.getSource().equals(grUI.getEmpTaskBtn()))
			{
				try {
					reports.viewEmpTask();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
}
