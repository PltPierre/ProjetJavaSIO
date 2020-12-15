package metier;

public class Poste {

	private int idPoste;
	private String libPoste;
	
	public Poste(int idPoste, String libPoste) {

		this.idPoste = idPoste;
		this.libPoste = libPoste;
	}

	public int getIdPoste() {
		return this.idPoste;
	}

	public String getLibPoste() {
		return this.libPoste;
	}
	
}
