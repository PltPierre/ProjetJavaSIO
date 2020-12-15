package test;

import java.sql.*;

import dao.DaoDriveExpress;

public class test {

	public static void main(String[] args) {

		Connection connect = DaoDriveExpress.SQLConnection();
		
		try {
			Statement stLienBD = connect.createStatement();
			String req = "SELECT * FROM USERS";
			ResultSet resultat = stLienBD.executeQuery(req);
			while(resultat.next()) {
				System.out.println(resultat.getString(1) + "\t" + resultat.getString(2) + "\t" + resultat.getString(3));
			}
			
			if(connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
