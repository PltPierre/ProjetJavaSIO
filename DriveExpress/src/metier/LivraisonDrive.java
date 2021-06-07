package metier;

import java.sql.Date;

public class LivraisonDrive {

    private int idLivraison;
    private Paiement lePaiement;
    private Panier lePanier;
    private Date dateRemise;

    public LivraisonDrive(int idLivraison, Paiement lePaiement, Panier lePanier) {
	this.idLivraison = idLivraison;
	this.lePaiement = lePaiement;
	this.lePanier = lePanier;
    }

    public int getIdLivraison() {
	return idLivraison;
    }

    public Paiement getLePaiement() {
	return lePaiement;
    }

    public Panier getLePanier() {
	return lePanier;
    }

    public Date getDateRemise() {
	return dateRemise;
    }

}
