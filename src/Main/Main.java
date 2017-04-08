package Main;

import Controller.LoginCtrl;
import Model.User;
import View.LoginUI;

public class Main 
{
	public static void main(String []args) throws Exception
	{
		LoginUI loginUI = new LoginUI();
		User user = new User();
		
		LoginCtrl loginCtrl = new LoginCtrl(user, loginUI);
	}
}
