package codeJam1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task {
	Connector c = new Connector();
	Connection conn = c.connect();

	public void updateTask(int id, String nom, int category) {
		String query = "update task set name=?, category=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, nom);
			preparedStatement.setInt(2, category);
			preparedStatement.setInt(3, id);
			int rowsAffected = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTask(int id) {
		String sql = "DELETE FROM task WHERE id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addTask(String category, String Task) {
		try {
			PreparedStatement ps1, ps2;
			ResultSet rs1;
			int rs2;

			String query1 = "SELECT id FROM category WHERE nom =?;";
			String query2 = "INSERT INTO task (name, category) VALUES (?,?);";

			ps1 = conn.prepareStatement(query1);
			ps1.setString(1, category);
			rs1 = ps1.executeQuery();
			rs1.next();
			// System.out.println(rs1.getInt("idCategory"));

			ps2 = conn.prepareStatement(query2);
			ps2.setString(1, Task);
			ps2.setInt(2, rs1.getInt("id"));
			rs2 = ps2.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		System.out.println("-----Done adding task-----");
	}
}
