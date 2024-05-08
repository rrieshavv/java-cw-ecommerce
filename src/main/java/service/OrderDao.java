package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import utils.DbConnection;

public class OrderDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	
	public OrderDao() {
		conn = DbConnection.getDbConnection();
	}
	
	public List<Order> getAllOrders() throws SQLException{
		String query = "SELECT o.id, u.FirstName, u.LastName, p.Title, o.OrderedOn, o.Quantity, o.status "
				+ "FROM Orders AS o "
				+ "LEFT JOIN User AS u ON o.UserId = u.Id "
				+ "LEFT JOIN Products AS p ON o.ProductId = p.Id "
				+ "ORDER BY o.id DESC";
		
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		List<Order> listOfOrders = new ArrayList<Order>();
		
		while(resultSet.next()) {
			Order order = new Order();
			order.setId(resultSet.getInt("id"));
			order.setCustomerName(resultSet.getString("FirstName")+" "+resultSet.getString("LastName"));
			order.setProductName(resultSet.getString("Title"));
			order.setOrderedon(resultSet.getTimestamp("OrderedOn").toLocalDateTime());
			order.setQuantity(resultSet.getInt("Quantity"));
			order.setStatus(resultSet.getString("status"));
			
			listOfOrders.add(order);
		}
		
		return listOfOrders;
	}
	
}
