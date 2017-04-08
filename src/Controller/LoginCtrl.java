package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Model.ConnectDB;
import Model.User;
import Model.UserDA;
import View.LoginUI;
import View.MainUI;

public class LoginCtrl 
{
	private LoginUI loginUI;
	private User user;
	
	public LoginCtrl(User user, LoginUI loginUI) throws Exception
	{
		this.user = user;
		this.loginUI = loginUI;
		
		this.loginUI.addActionListener(new Action());
		this.loginUI.addMouseListener(new Action());
		this.loginUI.addKeyListener(new Action());
	}
	class Action implements ActionListener, MouseListener, KeyListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(loginUI.getButton()))
			{
				try {
					if(verifyAccount())
					{
						showMainUI();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if(e.getSource().equals(loginUI.getUsernameTF()))
			{
				loginUI.getUsernameTF().setText("");
				loginUI.getUsernameTF().setForeground(Color.BLACK);
			}
			else if(e.getSource().equals(loginUI.getPasswordTF()))
			{
				loginUI.getPasswordTF().setText("");
				loginUI.getPasswordTF().setForeground(Color.BLACK);
			}
			
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) 
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				try {
					if(verifyAccount())
					{
						showMainUI();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public void showMainUI()
	{
		MainUI mainUI = new MainUI();
		
		MainCtrl mainCtrl = new MainCtrl(user, mainUI);
		
		loginUI.dispose();
	}
	public boolean verifyAccount() throws Exception 
	{
		UserDA userDA = new UserDA();
		
		ArrayList<String> allUserList = userDA.getUserDetails();
		ArrayList<String> userList = new ArrayList<String>();
		
		String username = loginUI.getUserName();
		String password = loginUI.getPassword();
		
		if(allUserList.contains(username))
		{
			for(int ctr=0; ctr<allUserList.size(); ctr++)
			{
				if(allUserList.get(ctr).equals(username))
				{
					if(allUserList.get(ctr+1).equals(password))
					{
						for(int ctr2=ctr-4; ctr2<ctr+4;ctr2++)
						{
							userList.add(allUserList.get(ctr2));
						}
						setUserDetails(userList);
						return true;
					}
					else
					{
						loginUI.displayErrorMessage("The password you've entered is incorrect.", "Invalid password");
						return false;
					}
						
				}
			}
		}
		else
		{
			loginUI.displayErrorMessage("This account doesn't exist. Please enter a valid username.", "Invalid username");
		}
		return false;
	}
	private void setUserDetails(ArrayList<String> userList) 
	{
		user.setId(userList.get(0));
		user.setName(userList.get(1));
		user.setTitle(userList.get(2));
		user.setEmail(userList.get(3));
		user.setUsername(userList.get(4));
		user.setPassword(userList.get(5));
		user.setType(userList.get(6));
		user.setMobile(userList.get(7));
	}	
}