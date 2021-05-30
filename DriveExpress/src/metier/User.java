package metier;

public class User {
    private int idUser;
    private String nomUser;
    private String prenomUser;
    private String adresse;
    private String ville;
    private String cpUser;
    private String numTel;
    private String userMail;
    private String passwordUser;

    public User(int iDUser, String nomUser, String prenomUser, String adresse, String ville, String cP, String numTel,
	    String userMail, String passwordUser) {
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

    public String getCP() {
	return cpUser;
    }

    public String getNumTel() {
	return numTel;
    }

    public String getUserMail() {
	return userMail;
    }

    public String getPasswordUser() {
	return passwordUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCpUser(String cpUser) {
        this.cpUser = cpUser;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    
    

}
