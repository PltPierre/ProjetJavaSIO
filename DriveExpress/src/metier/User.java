package metier;

public class User {
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String adresse;
    private String ville;
    private int cpUser;
    private int numTel;
    private String userMail;
    private String passwordUser;

    public User(int iDUser, String nomUser, String prenomUser, String adresse, String ville, int cP, int numTel, String userMail, String passwordUser) {
	this.idUser = iDUser;
	this.nomUser = nomUser;
	this.prenomUser = prenomUser;
	this.adresse = adresse;
	this.ville = ville;
	this.cpUser = cP;
	this.numTel = numTel;
	this.userMail = userMail;
	this.passwordUser = passwordUser;
    }

    public int getIDUser() {
	return this.idUser;
    }

    public String getNomUser() {
	return this.nomUser;
    }

    public String getPrenomUser() {
	return this.prenomUser;
    }

    public String getAdresse() {
	return this.adresse;
    }

    public String getVille() {
	return this.ville;
    }

    public int getCP() {
	return cpUser;
    }

    public int getNumTel() {
	return numTel;
    }

    public String getUserMail() {
	return userMail;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
    
    

}
