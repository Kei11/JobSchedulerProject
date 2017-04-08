package Model;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDA 
{
	
	public ArrayList<String> getUserDetails() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM USERDETAILS ");
		
		ArrayList<String> userDetailsList = new ArrayList<String>();
		
		while(rs.next())
		{
			userDetailsList.add(rs.getString(1));
			userDetailsList.add(rs.getString(2));
			userDetailsList.add(rs.getString(3));
			userDetailsList.add(rs.getString(4));
			userDetailsList.add(rs.getString(5));
			userDetailsList.add(rs.getString(6));
			userDetailsList.add(rs.getString(7));
			userDetailsList.add(rs.getString(8));
		}
		
		conn.close();
		return userDetailsList;
	}
	public void addTaskToUser(String task, String name) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "UPDATE USERDETAILS SET TASK=? WHERE NAME=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setString(1, task);
		ps.setString(2, name);
		ps.execute();
		
		conn.close();
	}
	public void deleteUserFromDB(String id) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "DELETE FROM USERDETAILS WHERE ID=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.execute();
		
		conn.close();
	}
	public void addAcountToDB(String name, String title, String email, String username, 
			String password, String type, int mobile) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "INSERT INTO USERDETAILS VALUES(next value for MY_SEQUENCE,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setString(2, title);
		ps.setString(3, email);
		ps.setString(4, username);
		ps.setString(5, password);
		ps.setString(6, type);
		ps.setInt(7, mobile);
		ps.setString(8, null);
		ps.execute();
		
		conn.close();
	}
	public ArrayList<String> getAssignedEmployee(String task) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT NAME FROM USERDETAILS WHERE TASK='" + task + "'");
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		while(rs.next())
		{
			nameList.add(rs.getString(1));
		}
		
		return nameList;
	}
	public ArrayList<String> getEmployeeNames() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT NAME FROM USERDETAILS WHERE TASK is NULL");
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		while(rs.next())
		{
			nameList.add(rs.getString(1));
		}
		
		return nameList;
	}
	public void updateDetails(String name, String title, String email, String username, String password, String type,
			int mobNo, String id) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "UPDATE USERDETAILS SET NAME=?, TITLE=?, EMAIL=?, USERNAME=?, PASSWORD=?, TYPE=?, MOBILE_NO=? WHERE ID=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setString(2, title);
		ps.setString(3, email);
		ps.setString(4, username);
		ps.setString(5, password);
		ps.setString(6, type);
		ps.setInt(7, mobNo);
		ps.setString(8, id);
		ps.execute();
		
		conn.close();
	}
	
}
