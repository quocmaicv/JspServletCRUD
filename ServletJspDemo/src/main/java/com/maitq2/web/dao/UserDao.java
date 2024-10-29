package com.maitq2.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maitq2.web.model.User;

public class UserDao {
	Connection connection;
	
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root1234");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<User> listAllUser() throws SQLException {
		List<User> listUsers = new ArrayList<>();
		
		connect();
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery("select * from users");

		while (rSet.next()) {
			User user = new User();
			user.setId(rSet.getInt("id"));
			user.setName(rSet.getString("name"));
			user.setEmail(rSet.getString("email"));
			user.setCountry(rSet.getString("country"));
			listUsers.add(user);
		}
		
		rSet.close();
		statement.close();
		connection.close();
		return listUsers;
	}

	public void deleteUser(int id) throws SQLException {
		
		String sqlDeleteString = "Delete from users where id = ?";
		connect();
		
		PreparedStatement statement = connection.prepareStatement(sqlDeleteString);
		statement.setInt(1, id);
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	public void insertUser(String nameString, String emailString, String countryString) throws SQLException {
		
		String sqlInsertString = "Insert into users (name, email, country) values (?, ?, ?)";
		connect();
		
		PreparedStatement statement = connection.prepareStatement(sqlInsertString);
		statement.setString(1, nameString);
		statement.setString(2, emailString);
		statement.setString(3, countryString);
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	public User getUser(int idString) throws SQLException {
		User user = new User();
		connect();
		String sqlSelectString = "select * from users where id = ?";
		PreparedStatement statement = connection.prepareStatement(sqlSelectString);
		statement.setInt(1, idString);
		
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String nameString = resultSet.getString("name");
			String emailString = resultSet.getString("email");
			String countString = resultSet.getString("country");
			user = new User(idString, nameString, emailString, countString);
		}
		resultSet.close();
		statement.close();
		
		return user;
	}

	public void updateUser(int id, String nameString, String emailString, String countString) throws SQLException {
		String sqlUpdate = "Update users set name = ?, email = ?, country = ? where id = ?";
		connect();
		
		PreparedStatement statement = connection.prepareStatement(sqlUpdate);
		statement.setString(1, nameString);
		statement.setString(2, emailString);
		statement.setString(3, countString);
		statement.setInt(4, id);
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}
		
}
