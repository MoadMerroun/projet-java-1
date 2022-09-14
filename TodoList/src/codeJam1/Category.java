package codeJam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Category {
	Connector c = new Connector();
	Connection conn = c.connect();

	public void updateCategory(int id, String nom) {
		String query = "update category set nom=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, nom);
			preparedStatement.setInt(2, id);
			int rowsAffected = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCategory(int id) {
		String sql = "DELETE FROM category WHERE id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("This category is not empty !");
		}

	}

	public void addCategory(String name) {
		try {
			PreparedStatement ps;
			int rs;
			String query = "INSERT INTO category (nom) VALUES (?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		System.out.println("-----Done adding Category-----");
	}
}
