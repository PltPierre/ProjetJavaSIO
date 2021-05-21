package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.*;

import metier.*;

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
		u = new User(resultat.getInt(1), resultat.getString(2), resultat.getString(3), resultat.getString(7),
			resultat.getString(9), resultat.getString(8), resultat.getString(6), resultat.getString(4),
			resultat.getString(5));
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
	    String req = "SELECT NOMUSER, PRENOMUSER FROM USERS WHERE IDUSER=" + idUser + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res = resultat.getString(2) + " " + resultat.getString(1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }

    public static void CreationPanier(Connection connect, int idUser) {
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO PANIER(IDUSER, DATECRATION) VALUES(" + idUser + ", DATE_FORMAT(now(), %Y-%m-%d))";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
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
	DaoDriveExpress.CreationPanier(connect, user.getIDUser());
    }

    public static Vector<TypeProduit> getTypeProduit(Connection connect) {
	Vector<TypeProduit> res = new Vector<TypeProduit>();

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM TYPEPRODUIT";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res.add(new TypeProduit(resultat.getInt(1), resultat.getString(2)));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }

    public static Vector<Produit> getProduits(Connection connect, Vector<TypeProduit> lesTypes) {
	Vector<Produit> res = new Vector<Produit>();
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM PRODUIT";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res.add(new Produit(resultat.getInt(1), lesTypes.get(resultat.getInt(2) - 1), resultat.getString(3),
			resultat.getString(4), resultat.getDouble(5), resultat.getDouble(6)));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return res;
    }

    public static Panier getPanier(Connection connect, User user) {
	Panier p = null;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM PANIER WHERE IDUSER =" + user.getIDUser() + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		p = new Panier(resultat.getInt(1), user);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return p;
    }

    public static Produit getProduit(Connection connect, int idProduit) {
	Produit p = null;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM PRODUIT WHERE IDPRODUIT =" + idProduit + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		p = new Produit(idProduit, DaoDriveExpress.getTypeProduit(connect).get(resultat.getInt(2) - 1),
			resultat.getString(3), resultat.getString(4), resultat.getDouble(5), resultat.getDouble(6));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return p;
    }

    public static HashMap<Produit, Integer> getContenuPanier(Connection connect, User user) {
	HashMap<Produit, Integer> c = new HashMap<Produit, Integer>();
	Panier p = DaoDriveExpress.getPanier(connect, user);

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT IDPRODUIT, QUANTITE FROM CONTIENT_PANIER_PRODUIT WHERE IDPANIER =" + p.getIdPanier()
		    + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);

	    while (resultat.next()) {
		Produit leProduit = DaoDriveExpress.getProduit(connect, resultat.getInt(1));
		c.put(leProduit, resultat.getInt(2));

	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return c;
    }

    public static boolean checkProduitPanier(Connection connect, User user, Produit produit) {
	boolean b = false;
	Panier panier = DaoDriveExpress.getPanier(connect, user);

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT COUNT(*) FROM CONTIENT_PANIER_PRODUIT WHERE IDPANIER =" + panier.getIdPanier() + " AND IDPRODUIT ="+ produit.getIdProduit();
	    ResultSet resultat = stLienBD.executeQuery(req);

	    while (resultat.next()) {
		if(resultat.getInt(1) != 0) {
		    b = true;
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return b;
    }

    public static void ajoutPanier(Connection connect, User user, Produit p, int quantite) {

	if (DaoDriveExpress.checkProduitPanier(connect, user, p)) {
	    Statement stLienBD;
	    try {
		stLienBD = connect.createStatement();
		String req = "UPDATE CONTIENT_PANIER_PRODUIT SET QUANTITE = QUANTITE + " + quantite + ";";
		stLienBD.executeUpdate(req);
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} else {
	    try {
		Statement stLienBD = connect.createStatement();
		String req = "INSERT INTO CONTIENT_PANIER_PRODUIT VALUES("
			+ DaoDriveExpress.getPanier(connect, user).getIdPanier() + "," + p.getIdProduit() + ","
			+ quantite + ");";
		stLienBD.executeUpdate(req);
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    
    public static void supprContenuPanierUser(Connection connect, User user) {
	Panier p = DaoDriveExpress.getPanier(connect, user);
	    try {
		Statement stLienBD = connect.createStatement();
		String req = "DELETE FROM CONTIENT_PANIER_PRODUIT WHERE IDPANIER =" + p.getIdPanier();
		stLienBD.executeUpdate(req);
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
    }
}
