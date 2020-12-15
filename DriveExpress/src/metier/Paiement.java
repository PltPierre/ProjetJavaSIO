package metier;

import java.sql.Date;

public class Paiement {

	private int idPaiement;
	private double montant;
	private Date datePaiement;
	
	public Paiement(int idPaiement, double montant, Date datePaiement) {

		this.idPaiement = idPaiement;
		this.montant = montant;
		this.datePaiement = datePaiement;
	}

	public int getIdPaiement() {
		return this.idPaiement;
	}

	public double getMontant() {
		return this.montant;
	}

	public Date getDatePaiement() {
		return this.datePaiement;
	}
	
	
	
}
