package metier;

public class ContientPanierProduit {

	private Panier lePanier;
	private Produit leProduit;
	private int quantite;
	
	
	public ContientPanierProduit(Panier lePanier, Produit leProduit, int quantite) {
		this.lePanier = lePanier;
		this.leProduit = leProduit;
		this.quantite = quantite;
	}


	public Panier getLePanier() {
		return this.lePanier;
	}


	public Produit getLeProduit() {
		return this.leProduit;
	}


	public int getQuantite() {
		return this.quantite;
	}
	
	
	
}
