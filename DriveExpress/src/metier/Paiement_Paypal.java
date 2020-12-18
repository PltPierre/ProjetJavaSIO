package metier;

import java.sql.Date;

public class Paiement_Paypal extends Paiement {

    private String numCompte;

    public Paiement_Paypal(int idPaiement, double montant, Date datePaiement, String numCompte) {
	super(idPaiement, montant, datePaiement);
	this.numCompte = numCompte;
    }

    public String getNumCompte() {
	return this.numCompte;
    }

}
