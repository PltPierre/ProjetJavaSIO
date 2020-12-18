package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.TreeMap;

public class DaoDriveExpress {
    private static final TreeMap<String, String> properties = DaoDriveExpress.GetDatabaseProperties();

    public static Connection SQLConnection() {

	Connection connect = null;

	try {
	    Class.forName(properties.get("driver"));
	} catch (ClassNotFoundException e1) {
	    System.out.println("pb driver");
	    e1.printStackTrace();
	}

	try {
	    connect = DriverManager.getConnection(properties.get("url"), properties.get("login"),
		    properties.get("password"));
	} catch (SQLException e) {
	    System.out.println("pb lors de la connection a la base de données");
	    e.printStackTrace();
	}

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "USE bch5pl5adcyod7rdbeyl";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		System.out.println(resultat.getString(1));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return connect;
    }

    private static TreeMap<String, String> GetDatabaseProperties() {
	TreeMap<String, String> properties = new TreeMap<String, String>();

	Properties props = new Properties();
	try {
	    FileInputStream fis = new FileInputStream("./model/conf.properties");
	    props.load(fis);
	} catch (Exception e) {
	    e.getStackTrace();
	}

	properties.put("driver", props.getProperty("jdbc.driver"));
	properties.put("url", props.getProperty("jdbc.url"));
	properties.put("login", props.getProperty("jdbc.login"));
	properties.put("password", props.getProperty("jdbc.password"));

	return properties;
    }

    public static String getFullNameUser(String mail, String mdp, Connection connect) {
	String res;
	res = "";
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT PRENOMUSER, NOMUSER FROM USERS WHERE MAILUSER = '" + mail + "' AND MDPUSER = '" + mdp
		    + "';";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res = resultat.getString(1) + " " + resultat.getString(2);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	if (res.equals("")) {
	    res = "Utilisateur inconnu";
	}

	return res;
    }
}
