package metier;

import java.sql.Date;

public class Paiement_CB extends Paiement {

    private int numCarte;
    private Date dateExpiration;

    public Paiement_CB(int idPaiement, double montant, Date datePaiement, int numCarte, Date dateExpiration) {
	super(idPaiement, montant, datePaiement);
	this.numCarte = numCarte;
	this.dateExpiration = dateExpiration;
    }

    public int getNumCarte() {
	return this.numCarte;
    }

    public Date getDateExpiration() {
	return this.dateExpiration;
    }

}
