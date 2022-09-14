package codeJam1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TodoFunctions {
	Connector c = new Connector();
	Connection conn = c.connect();

	public static void Affichage() {
		try {
			Connector c = new Connector();
			Connection con = c.connect();
			String query1 = "SELECT * FROM category";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println(rs.getString("id") + "- " + rs.getString("nom") + "\n ");
				String query2 = "SELECT * FROM task WHERE category = " + id;
				Statement st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery(query2);

				while (rs2.next()) {
					System.out.println("     " + rs2.getString("id") + "- " + rs2.getString("name") + "\n");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
