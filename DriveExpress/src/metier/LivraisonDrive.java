package metier;

import java.sql.Date;

public class LivraisonDrive {

    private int idLivraison;
    private Employe employeLivreur;
    private Employe employePreparateur;
    private Paiement lePaiement;
    private Panier lePanier;
    private Date dateRemise;

    public LivraisonDrive(int idLivraison, Employe employeLivreur, Employe employePreparateur, Paiement lePaiement, Panier lePanier, Date dateRemise) {
	this.idLivraison = idLivraison;
	this.employeLivreur = employeLivreur;
	this.employePreparateur = employePreparateur;
	this.lePaiement = lePaiement;
	this.lePanier = lePanier;
	this.dateRemise = dateRemise;
    }

    public int getIdLivraison() {
	return idLivraison;
    }

    public Employe getEmployeLivreur() {
	return employeLivreur;
    }

    public Employe getEmployePreparateur() {
	return employePreparateur;
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
