package metier;

public class User {
	private int IDUser;
	private String NomUser;
	private String PrenomUser;
	private String adresse;
	private String Ville;
	private int CP;
	private int NumTel;
	private String userMail;
	private String userPassword
	
	public User(int iDUser, String nomUser, String prenomUser, String adresse, String ville, int cP, int numTel, String userMail) {
		this.IDUser = iDUser;
		this.NomUser = nomUser;
		this.PrenomUser = prenomUser;
		this.adresse = adresse;
		this.Ville = ville;
		this.CP = cP;
		this.NumTel = numTel;
		this.userMail = userMail;
	}
	
	
}
