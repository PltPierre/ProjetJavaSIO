package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.*;

import metier.*;

public class DaoDriveExpress {
    // var infos de la bdd
    private static final TreeMap<String, String> properties = DaoDriveExpress.GetDatabaseProperties();

    // connection bdd
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

    // récup les infos de la bdd
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

    // fonction de login
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

    // fonction login employee
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

    // fonctions pour valider adresse mail (utilisé dans inscription)
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	    Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
	Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
	return matcher.find();
    }

    // get last id user dans la bdd
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

    // get un user dans la bdd avec mail et mdp
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

    // get un user dans la bdd avec l'id
    public static User getUser(int idUser, Connection connect) {
	User u;
	u = null;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM USERS WHERE IDUSER = " + idUser + ";";
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

    // get un poste avec l'id
    public static Poste getPoste(Connection connect, int idPoste) {
	Poste p;
	p = null;

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM POSTE WHERE IDPOSTE = " + idPoste + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		p = new Poste(resultat.getInt(1), resultat.getString(2));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return p;
    }

    // get un employé avec mail et mdp
    public static Employe getEmploye(String mail, String mdp, Connection connect) {
	Employe employe;
	employe = null;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM EMPLOYE WHERE MAILE = '" + mail + "' AND MDPE = '" + mdp + "';";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		employe = new Employe(resultat.getInt(1), DaoDriveExpress.getPoste(connect, resultat.getInt(2)),
			resultat.getString(3), resultat.getString(4), resultat.getString(5), resultat.getString(6),
			resultat.getString(7), resultat.getString(8), resultat.getString(9), mdp);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return employe;
    }

    // get nom + prenom user
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

    // insert un panier dans la base de données
    public static void CreationPanier(Connection connect, int idUser) {
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO PANIER(IDUSER, DATECREATION) VALUES(" + idUser + ", '"
		    + new Date(Instant.now().toEpochMilli()) + "');";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    // get inscription d'un utilisateur
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

    // get les type de produits
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

    // get les produits (le vector lestypes est inutile tkt)
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

    // get le panier d'un utilisateur
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

    // get le panier d'un utilisateur avec l'idPanier
    public static Panier getPanier(Connection connect, int idPanier) {
	Panier p = null;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM PANIER WHERE IDPANIER =" + idPanier + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		p = new Panier(idPanier, DaoDriveExpress.getUser(resultat.getInt(2), connect));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return p;
    }

    // get un produit avec l'idProduit
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

    // get le contenu d'un panier avec les produit + la quantité/produit
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

    // check si le panier contient des produits
    public static boolean checkProduitPanier(Connection connect, User user, Produit produit) {
	boolean b = false;
	Panier panier = DaoDriveExpress.getPanier(connect, user);

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT COUNT(*) FROM CONTIENT_PANIER_PRODUIT WHERE IDPANIER =" + panier.getIdPanier()
		    + " AND IDPRODUIT =" + produit.getIdProduit();
	    ResultSet resultat = stLienBD.executeQuery(req);

	    while (resultat.next()) {
		if (resultat.getInt(1) != 0) {
		    b = true;
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return b;
    }

    // ajoute un produit dans un panier
    public static void ajoutPanier(Connection connect, User user, Produit p, int quantite) {

	if (DaoDriveExpress.checkProduitPanier(connect, user, p)) {
	    Statement stLienBD;
	    try {
		stLienBD = connect.createStatement();
		String req = "UPDATE CONTIENT_PANIER_PRODUIT SET QUANTITE = QUANTITE + " + quantite
			+ " WHERE IDPRODUIT= " + p.getIdProduit() + ";";
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

    // supprime le contenu d'un panier en entier
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

    // ajoute le paiement d'un panier
    public static void ajoutPaiementLivraison(Connection connect, double total, Date date, int idPanier) {

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO PAIEMENT(MONTANT, DATEPAIEMENT) VALUES(" + total + ", '" + date + "');";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	Paiement p = new Paiement(1, total, date);

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT IDPAIEMENT FROM PAIEMENT WHERE MONTANT=" + p.getMontant() + " AND DATEPAIEMENT='"
		    + p.getDatePaiement() + "';";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		p = new Paiement(resultat.getInt(1), p.getMontant(), p.getDatePaiement());
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	System.out.println(p.getIdPaiement());
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO LIVRAISONDRIVE(IDPAIEMENT, IDPANIER) VALUES(" + p.getIdPaiement() + ", '"
		    + idPanier + "');";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    // update les infos d'un utilisateur
    public static void updateUser(Connection connect, User user) {
	Statement stLienBD;
	try {
	    stLienBD = connect.createStatement();
	    String req = "UPDATE USERS SET NOMUSER = '" + user.getNomUser() + "', PRENOMUSER = '" + user.getPrenomUser()
		    + "', MAILUSER = '" + user.getUserMail() + "', MDPUSER = '" + user.getPasswordUser()
		    + "', TELUSER = '" + user.getNumTel() + "', ADRESSEUSER = '" + user.getAdresse() + "', CPUSER = '"
		    + user.getCP() + "', VILLEUSER = '" + user.getVille() + "'  WHERE IDUSER= " + user.getIDUser()
		    + ";";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    // update les infos d'un employee
    public static void updateEmploye(Connection connect, Employe employe) {
	Statement stLienBD;
	try {
	    stLienBD = connect.createStatement();
	    String req = "UPDATE EMPLOYE SET MDPE= '" + employe.getPassword() + "', NOME = '" + employe.getNomEmploye()
		    + "', PRENOME = '" + employe.getPrenomEmploye() + "', MAILE = '" + employe.getMailEmploye()
		    + "', TELE = '" + employe.getNumTelEmploye() + "', ADRESSEE = '" + employe.getAdresseEmploye()
		    + "', CPE = '" + employe.getCpEmploye() + "', VILLEE = '" + employe.getVilleEmploye()
		    + "'  WHERE IDEMPLOYE= " + employe.getIdEmploye() + ";";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    // check si l'user a une livraisons
    public static int CheckUserHasLivraison(Connection connect, User user) {
	int res = 0;
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM LIVRAISONDRIVE WHERE (DATEREMISE IS NULL OR DATEREMISE <= '"
		    + new Date(Instant.now().toEpochMilli())
		    + "') AND IDPANIER=(SELECT IDPANIER FROM PANIER WHERE IDUSER = " + user.getIDUser() + ");";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		res++;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return res;
    }

    // get un paiement avec l'idPaiement
    public static Paiement getPaiement(Connection connect, int idPaiement) {
	Paiement p = null;

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM PAIMEMENT WHERE IDPAIEMENT= " + idPaiement + ";";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		p = new Paiement(idPaiement, resultat.getDouble(2), resultat.getDate(3));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return p;
    }

    // get les livraison sans date de remise
    public static Vector<LivraisonDrive> getLesLivraisonsEnAttente(Connection connect) {
	Vector<LivraisonDrive> ld = new Vector<LivraisonDrive>();

	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "SELECT * FROM LIVRAISONDRIVE WHERE DATEREMISE IS NULL;";
	    ResultSet resultat = stLienBD.executeQuery(req);
	    while (resultat.next()) {
		ld.add(new LivraisonDrive(resultat.getInt(1), DaoDriveExpress.getPaiement(connect, resultat.getInt(2)),
			DaoDriveExpress.getPanier(connect, resultat.getInt(3))));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return ld;
    }

    // ajout d'un type de produit
    public static void ajoutTypeProduit(Connection connect, String lib) {
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO TYPEPRODUIT(LIBTYPE) VALUES('" + lib + "');";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    // ajout d'un produit
    public static void ajoutProduit(Connection connect, Produit p) {
	try {
	    Statement stLienBD = connect.createStatement();
	    String req = "INSERT INTO PRODUIT(IDTYPE, LIBPRODUIT, DESCPRODUIT, PRIXPRODUIT) VALUES("
		    + p.getLeTypeProduit().getIdType() + ", '" + p.getLibProduit() + "', '" + p.getDescProduit() + "', "
		    + p.getPrixProduit() + ");";
	    stLienBD.executeUpdate(req);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
