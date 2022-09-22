package utlities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getMySQLConnection() {
		// public IP
		String hostName = "localhost";
		String dbName = "automationfc";
		String userName = "root";
		String password = "automationfc";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// Khai báo class driver cho MySQL
			// VIệc này cần thiết vs java 5
			// Java 6 tự động tìm kiếm driver thích hợp - không bắt buộc dòng này
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Cấu trúc URL Connection dành cho MySQL
			// Ví dụ: jdbc:mysql://localhost:3306/automationfc
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}