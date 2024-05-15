package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import utils.DbConnection;

public class DashboardDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	public DashboardDao() {
		conn = DbConnection.getDbConnection();
	}
	
	public int getProductCount() throws SQLException {
		String query = "SELECT COUNT(*) FROM products";
		int count = 0;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	
	public int getOrderCount() throws SQLException {
		String query = "SELECT COUNT(*) FROM orders";
		int count = 0;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	
	public int getMessagesCount() throws SQLException {
		String query = "SELECT COUNT(*) FROM messages";
		int count = 0;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	
	public int getPendingOrderCount() throws SQLException {
		String query = "SELECT COUNT(*) FROM orders WHERE status='pending'";
		int count = 0;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	
	public int getDeliveredOrderCount() throws SQLException {
		String query = "SELECT COUNT(*) FROM orders WHERE status='delivered'";
		int count = 0;
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			count = resultSet.getInt(1);
		}
		return count;
	}
	
	public List<User> getAllUsers() throws SQLException{
		String query  = "Select * from user where role_id=1";
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		List<User> userlist = new ArrayList<User>();
		
		while(resultSet.next()){
			User obj = new User();
			obj.setUsername(resultSet.getString("Username"));
			obj.setEmail(resultSet.getString("Email"));
			obj.setGender(resultSet.getString("Gender"));
			obj.setJoinedOn(resultSet.getDate("CreatedOn"));
			userlist.add(obj);
		}
		
		return userlist;
	}
}