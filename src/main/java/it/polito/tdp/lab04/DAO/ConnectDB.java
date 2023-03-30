package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost/iscritticorsi?user=root&password=";
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Errore di connessione!");
			e.printStackTrace();
			return null;
		}
	}
}
