package Puddly.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class KoneksiDatabase {

	public Connection conn;
	private Statement st;
	ImageIcon icon = new ImageIcon("Image/success.png");

	public void connect() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pudding_database?useSSL=false&serverTimezone=UTC",
					"root", "");
			this.st = conn.createStatement();
		} catch (Exception e) {
			throw e;
		}
	}

	public ResultSet query(String q) throws SQLException {
		return this.st.executeQuery(q);
	}

	public boolean queryDel(String q) throws SQLException {
		if (this.st.execute(q)) {
			return true;
		}
		return false;
	}

}
