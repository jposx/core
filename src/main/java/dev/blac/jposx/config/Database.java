package dev.blac.jposx.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.stream.*;

import io.github.cdimascio.dotenv.Dotenv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database {
	private static Connection connection;
	private static Logger logger = LoggerFactory.getLogger(Database.class);
	private static Dotenv dotenv = Dotenv.load();

	static int port = Integer.parseInt(dotenv.get("PORT"));
	static final String user = dotenv.get("DB_USER");
	static final String pass = dotenv.get("DB_PASS");
	static final String db_address = dotenv.get("DB_ADDRESS");
	static final String db_port = dotenv.get("DB_PORT");
	static final String url = "jdbc:mysql://" + db_address + ":" + db_port
			+ "/javadb?useSSL=false&allowPublicKeyRetrieval=true";

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, pass);
		}
		return connection;
	}

	public static void initTable() {
		try {
			Database.getConnection();
			Statement stmt = connection.createStatement();
			InputStream in = Database.class.getResourceAsStream("/init.sql");

			String sql = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));

			for (String s : sql.split(";")) {
				if (!s.trim().isEmpty()) {
					stmt.execute(s);
				}
			}
			logger.info("Database initialised");
		} catch (Exception e) {
			logger.error("Database initilisation failed: " + e);
		}
	}
}
