package metier;

public class Employe {

    private int idEmploye;
    private Poste lePoste;
    private String nomEmploye;
    private String prenomEmploye;
    private String mailEmploye;
    private String numTelEmploye;
    private String adresseEmploye;
    private String cpEmploye;
    private String villeEmploye;
    private String password;

    public Employe(int idEmploye, Poste lePoste, String nomEmploye, String prenomEmploye, String mailEmploye, String numTelEmploye, String adresseEmploye, String cpEmploye, String villeEmploye, String password) {
	this.idEmploye = idEmploye;
	this.lePoste = lePoste;
	this.nomEmploye = nomEmploye;
	this.prenomEmploye = prenomEmploye;
	this.mailEmploye = mailEmploye;
	this.numTelEmploye = numTelEmploye;
	this.adresseEmploye = adresseEmploye;
	this.cpEmploye = cpEmploye;
	this.villeEmploye = villeEmploye;
	this.password = password;
    }

    public int getIdEmploye() {
	return this.idEmploye;
    }

    public Poste getLePoste() {
	return this.lePoste;
    }

    public String getNomEmploye() {
	return this.nomEmploye;
    }

    public String getPrenomEmploye() {
	return this.prenomEmploye;
    }

    public String getMailEmploye() {
	return this.mailEmploye;
    }

    public String getNumTelEmploye() {
	return this.numTelEmploye;
    }

    public String getAdresseEmploye() {
	return this.adresseEmploye;
    }

    public String getCpEmploye() {
	return this.cpEmploye;
    }

    public String getVilleEmploye() {
	return this.villeEmploye;
    }
    
    public String getPassword() {
	return this.password;
    }
    
    public void setPassword(String password) {
	this.password = password;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public void setMailEmploye(String mailEmploye) {
        this.mailEmploye = mailEmploye;
    }

    public void setNumTelEmploye(String numTelEmploye) {
        this.numTelEmploye = numTelEmploye;
    }

    public void setAdresseEmploye(String adresseEmploye) {
        this.adresseEmploye = adresseEmploye;
    }

    public void setCpEmploye(String cpEmploye) {
        this.cpEmploye = cpEmploye;
    }

    public void setVilleEmploye(String villeEmploye) {
        this.villeEmploye = villeEmploye;
    }
    
    

}
