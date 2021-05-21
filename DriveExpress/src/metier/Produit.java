package metier;

public class Produit {

    private int idProduit;
    private TypeProduit leTypeProduit;
    private String libProduit;
    private String descProduit;
    private double PrixProduit;
    private double promotionProduit;

    public Produit(int idProduit, TypeProduit leTypeProduit, String libProduit, String descProduit, double prixProduit, double promotionProduit) {
	this.idProduit = idProduit;
	this.leTypeProduit = leTypeProduit;
	this.libProduit = libProduit;
	this.descProduit = descProduit;
	this.PrixProduit = prixProduit;
	
	if(promotionProduit == 0) {
	    this.promotionProduit = 1;
	}
	
	leTypeProduit.addProduit(this);
    }

    public double getPromotionProduit() {
	return this.promotionProduit;
    }

    public void setPromotionProduit(double promotionProduit) {
	this.promotionProduit = promotionProduit;
    }

    public int getIdProduit() {
	return this.idProduit;
    }

    public TypeProduit getLeTypeProduit() {
	return this.leTypeProduit;
    }

    public String getLibProduit() {
	return this.libProduit;
    }

    public String getDescProduit() {
	return this.descProduit;
    }

    public double getPrixProduit() {
	return this.PrixProduit;
    }

    @Override
    public String toString() {
	return libProduit;
    }
    
    

}
