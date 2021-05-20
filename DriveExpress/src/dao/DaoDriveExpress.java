package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.*;

import metier.User;

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
	    String req = "USE betwyfxudjixqiaiwmlv";
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

    public static int Connect(String mail, String mdp, Connection connect) {
	int res;
	res = 0;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT PRENOMUSER, NOMUSER FROM USERS WHERE MAILUSER = '" + mail + "' AND MDPUSER = '" + mdp
		    + "';";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res++;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }

    public static int ConnectEmployee(String mail, String mdp, Connection connect) {
	int res;
	res = 0;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT PRENOME, NOME FROM EMPLOYE WHERE MAILE = '" + mail + "' AND MDPE = '" + mdp + "';";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res++;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	    Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
	Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
	return matcher.find();
    }

    public static int getLastIDUser(Connection connect) {
	int res = 0;

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT IDUSER FROM USERS";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res = resultat.getInt(1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }
    
    public static User getUser(String mail, String mdp, Connection connect) {
	User u;
	u = null;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM USERS WHERE MAILUSER = '" + mail + "' AND MDPUSER = '" + mdp + "';";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		u = new User(resultat.getInt(1), resultat.getString(2), resultat.getString(3), resultat.getString(7), resultat.getString(9), resultat.getString(8), resultat.getString(6), resultat.getString(4), resultat.getString(5));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return u;
    }
    
    public static String getFullName(Connection connect, int idUser) {
	String res = "";

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT NOMUSER, PRENOMUSER FROM USERS WHERE IDUSER="+ idUser +";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res = resultat.getString(2) + " " + resultat.getString(1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }

    public static void inscriptionUser(Connection connect, User user) {

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO USERS VALUES(" + user.getIDUser() + ", '" + user.getNomUser() + "','"
		    + user.getPrenomUser() + "','" + user.getUserMail() + "','" + user.getPasswordUser() + "','"
		    + user.getNumTel() + "','" + user.getAdresse() + "','" + user.getCP() + "','" + user.getVille()
		    + "')";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
