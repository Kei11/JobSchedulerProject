package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB 
{
	public Connection getConnection() throws Exception
	{
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
		
		return conn;
	}
	public void createTableUserDetails() throws Exception
	{
		String createTable="CREATE TABLE IF NOT EXISTS USERDETAILS(ID INT PRIMARY KEY, NAME VARCHAR(255), TITLE VARCHAR(255), EMAIL VARCHAR(255), USERNAME VARCHAR(255), PASSWORD VARCHAR(255), TYPE VARCHAR(255), MOBILE_NO BIGINT)";
		
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		st.execute(createTable);
		insertInitialValues();
	}
	public void insertInitialValues() throws Exception
	{
		String insert="INSERT INTO USERDETAILS VALUES (1, 'John Doe', 'CEO', 'free2rhyme@gmail.com', 'admin', 'admin', 'Admin', 09875617283)";

		Connection conn = getConnection();
		Statement st = conn.createStatement();
		st.execute(insert);
	}
}
