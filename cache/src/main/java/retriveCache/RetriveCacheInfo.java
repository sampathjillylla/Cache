package retriveCache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RetriveCacheInfo {

	private static Map<String, UserInfo> userData = new HashMap<String, UserInfo>();

	public static UserInfo getUserRow(String Id) {
		UserInfo userRecord = new UserInfo();
		userRecord = RetriveCacheInfo.userData.get(Id);
		if (userRecord == null) {
			System.out.println("Not able to find symbol from symbolMap > " + Id);
			return userRecord;
		}
		return userRecord;
	}

	public static void getInfo() throws SQLException {
		Connection connection = null;
		ResultSet results = null;2
		try {
			// Load the MySQL JDBC driver
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			// Create a connection to the database
			String serverName = "localhost";
			String schema = "getcache";
			String url = "jdbc:mysql://" + serverName + "/" + schema;
			String uName = "admin";
			String pswd = "admin";
			connection = DriverManager.getConnection(url, uName, pswd);
			ps = connection.prepareStatement("SELECT * FROM CACHE_DETIALS");
			results = ps.executeQuery();
			System.out.println("Successfully Connected to the database!");
			if (!results.isBeforeFirst())
				System.out.println("No Symbols Found");
			while (results.next()) {
				UserInfo row = new UserInfo(results);
				RetriveCacheInfo.userData.put(results.getString("id"), row);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class not find the database driver " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Class not connect to the database " + e.getMessage());
		} catch (Exception e) {
			e.getMessage();

		} finally {
			results.close();
			ps.close();
			connection.close();
		}
	}
	public static void main(String[] args) throws SQLException {
		getInfo();
		System.out.println("details are" + getUserRow("1"));
	}

}