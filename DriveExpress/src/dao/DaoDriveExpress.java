package dao;

import java.sql.*;

public class DaoDriveExpress 
{
	private static final String nomPilote = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mysql://bch5pl5adcyod7rdbeyl-mysql.services.clever-cloud.com:3306:bch5pl5adcyod7rdbeyl";
	private static final String user = "uf5o6ck7ntrtuzw7";
	private static final String password = "vIt8MTnd0AfFn6lNTGaJ";
	
	public static Connection SQLConnection() {
		
		Connection connect = null;
		
		try {
			Class.forName(nomPilote);
		} catch (ClassNotFoundException e1) {
			System.out.println("pb driver");
			e1.printStackTrace();
		}
		
		try {
			connect = DriverManager.getConnection(DaoDriveExpress.url,DaoDriveExpress.user,DaoDriveExpress.password);
		} catch (SQLException e) {
			System.out.println("pb lors de la connection a la base de données");
			e.printStackTrace();
		}
		
		return connect;
	}
	
}
