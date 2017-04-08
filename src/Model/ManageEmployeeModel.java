package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageEmployeeModel 
{
	public void addEmployee(String values) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("INSERT INTO ACCOUNTDETAILS VALUES(" + values + ")");
		
		conn.close();
	}
}
