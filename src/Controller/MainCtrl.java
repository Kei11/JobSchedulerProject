package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Reports;
import Model.User;
import View.GenReportUI;
import View.LoginUI;
import View.MainUI;
import View.ManageEmployeeUI;
import View.ManageJobUI;
import View.ViewTaskUI;

public class MainCtrl 
{
	private MainUI mainUI;
	private User user;
	
	public MainCtrl(User user, MainUI mainUI)
	{
		this.user = user;
		this.mainUI = mainUI;
		
		this.mainUI.addActionListener(new Action());
		checkUserRights();
	}
	private void checkUserRights() 
	{
		if(user.getType().equals("User"))
		{
			mainUI.getManageEmployeeBtn().setEnabled(false);
			mainUI.getManageTaskBtn().setEnabled(false);
		}
		else if(user.getType().equals("Proj. Manager"))
		{
			mainUI.getManageEmployeeBtn().setEnabled(false);
		}
	}
	class Action implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(mainUI.getManageEmployeeBtn()))
			{
				ManageEmployeeUI meUI = new ManageEmployeeUI();
				
				try {
					ManageEmployeeCtrl meCtrl = new ManageEmployeeCtrl(user, meUI);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				mainUI.dispose();
			}
			else if(e.getSource().equals(mainUI.getGenReportBtn()))
			{
				GenReportUI grUI = new GenReportUI();
				GenReportCtrl grCtrl = new GenReportCtrl(user, grUI);
				
				mainUI.dispose();
			}
			else if(e.getSource().equals(mainUI.getManageTaskBtn()))
			{
					try {
						showManageTaskUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainUI.dispose();
			}
			else if(e.getSource().equals(mainUI.getViewTaskBtn()))
			{
				try {
					showViewTaskUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				mainUI.dispose();
			}
			else if(e.getSource().equals(mainUI.getExitBtn()))
			{
				
				
				try {
					LoginUI logUI = new LoginUI();
					LoginCtrl logCtrl = new LoginCtrl(user, logUI);
					mainUI.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		public void showViewTaskUI() throws Exception
		{
			ViewTaskUI vtUI = new ViewTaskUI();
			
			ViewTaskCtrl vtCtrl = new ViewTaskCtrl(user, vtUI);
		}
		public void showManageTaskUI() throws Exception
		{
			ManageJobUI mjUI = new ManageJobUI();
			
			ManageJobCtrl mjCtrl = new ManageJobCtrl(user, mjUI);
		}
	}
}
