package metier;

public class Employe {

	private int idEmploye;
	private Poste lePoste;
	private String nomEmploye;
	private String prenomEmploye;
	private String mailEmploye;
	private int numTelEmploye;
	private String adresseEmploye;
	private int cpEmploye;
	private String villeEmploye;
	
	
	public Employe(int idEmploye, Poste lePoste, String nomEmploye, String prenomEmploye, String mailEmploye, int numTelEmploye, String adresseEmploye, int cpEmploye, String villeEmploye) {
		this.idEmploye = idEmploye;
		this.lePoste = lePoste;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.mailEmploye = mailEmploye;
		this.numTelEmploye = numTelEmploye;
		this.adresseEmploye = adresseEmploye;
		this.cpEmploye = cpEmploye;
		this.villeEmploye = villeEmploye;
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


	public int getNumTelEmploye() {
		return this.numTelEmploye;
	}


	public String getAdresseEmploye() {
		return this.adresseEmploye;
	}


	public int getCpEmploye() {
		return this.cpEmploye;
	}


	public String getVilleEmploye() {
		return this.villeEmploye;
	}
	
	
	
}
