package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	public static Connection getConnection() {
		try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			return DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
	}

	public static void closeStatemenet(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {

		try (InputStream is = DB.class.getClassLoader().getResourceAsStream("db.properties")) {
			if (is == null) {
				throw new DbException("Arquivo db.properties não encontrado");
			}
			Properties props = new Properties();
			props.load(is);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

}
