package metier;

public class Produit {

    private int idProduit;
    private TypeProduit leTypeProduit;
    private String libProduit;
    private String descProduit;
    private double PrixProduit;
    private double promotionProduit;

    public Produit(int idProduit, TypeProduit leTypeProduit, String libProduit, String descProduit, double prixProduit) {
	this.idProduit = idProduit;
	this.leTypeProduit = leTypeProduit;
	this.libProduit = libProduit;
	this.descProduit = descProduit;
	this.PrixProduit = prixProduit;
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

}
