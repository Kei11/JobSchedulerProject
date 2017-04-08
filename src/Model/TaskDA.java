package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class TaskDA 
{
	public ArrayList<String> getTaskDetails() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM TASKDETAILS ");
		
		ArrayList<String> userDetailsList = new ArrayList<String>();
		
		while(rs.next())
		{
			userDetailsList.add(rs.getString(1));
			userDetailsList.add(rs.getString(2));
			userDetailsList.add(rs.getString(3));
			userDetailsList.add(rs.getString(4));
			userDetailsList.add(rs.getString(5));
			userDetailsList.add(rs.getString(6));
		}
		conn.close();
		return userDetailsList;
	}
	public ArrayList<String> getViewTaskList() throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT U.ID, U.NAME, U.TASK, T.DESCRIPTION, T.START_DATE, T.END_DATE, T.LEADER FROM USERDETAILS U LEFT JOIN TASKDETAILS T WHERE U.TASK=T.NAME");
		
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
		}
		conn.close();
		return userDetailsList;
	}
	public void deleteDataFromDB(String id) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "DELETE FROM TASKDETAILS WHERE TASK_ID=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.execute();
		
		conn.close();
	}
	public ArrayList<String> getAssignedEmployee(String leader) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT ASSIGNED_MEMBERS FROM TASKDETAILS WHERE LEADER='" + leader + "'");
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		while(rs.next())
		{
			nameList.add(rs.getString(1));
		}
		
		conn.close();
		return nameList;
	}
	
	public void updateTaskDetails(String name, String desc, Date start, Date end, String leader, String id) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "UPDATE TASKDETAILS SET NAME=?, DESCRIPTION=?, START_DATE=?, END_DATE=?, LEADER=? WHERE TASK_ID=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		java.sql.Date s = convertUtilToSql(start);
		java.sql.Date e = convertUtilToSql(end);
		
		ps.setString(1, name);
		ps.setString(2, desc);
		ps.setDate(3, s);
		ps.setDate(4, e);
		ps.setString(5, leader);
		ps.setString(6, id);
		ps.execute();
		
		conn.close();
	}
	public void addTaskToDB(String name, String description, Date start, Date end, String leader, String members) throws Exception
	{
		ConnectDB connectDB = new ConnectDB();
		Connection conn = connectDB.getConnection();
		
		String query = "INSERT INTO TASKDETAILS VALUES(next value for TASK_SEQ,?,?,?,?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		java.sql.Date s = convertUtilToSql(start);
		java.sql.Date e = convertUtilToSql(end);

		
		ps.setString(1, name);
		ps.setString(2, description);
		ps.setDate(3, s);
		ps.setDate(4, e);
		ps.setString(5, leader);
		ps.setString(6, members);
		ps.execute();
		
		conn.close();
	}
	
	 private static java.sql.Date convertUtilToSql(java.util.Date uDate) 
	 {
		    java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			return sDate;
	 }

}
