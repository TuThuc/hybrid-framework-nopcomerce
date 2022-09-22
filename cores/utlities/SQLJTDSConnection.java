package utlities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJTDSConnection {
	public static Connection getSQLServerConnection() {
		// public IP
		String hostName = "localhost";
		String sqlInstanceName = "MSSQLSERVER";
		String database = "automationfc";
		String userName = "sa";
		String password = "automationfc";
		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}

	private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			// Khai báo class driver cho SQL
			// VIệc này cần thiết vs java 5
			// Java 6 tự động tìm kiếm driver thích hợp - không bắt buộc dòng này
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// Cấu trúc URL Connection dành cho SQL
			// Ví dụ: jtds:sqlserver://localhost:1433/automationfc; instance = MSSQLSERVER
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}