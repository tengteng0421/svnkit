package utils;

import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConTest {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// DriverManager.setLogWriter(new PrintWriter("D:/JDBC.txt"));
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nm_inbound2_0", "histaxqj", "richfit123");
	}
}
