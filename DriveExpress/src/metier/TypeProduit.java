package metier;

import java.util.Vector;

public class TypeProduit {

    private int idType;
    private String libType;
    private Vector<Produit> lesProduits;

    public TypeProduit(int idType, String libType) {
	lesProduits = new Vector<Produit>();
	this.idType = idType;
	this.libType = libType;
    }
    
    public void addProduit(Produit p) {
	this.lesProduits.add(p);
    }
    
    public Vector<Produit> getLesProduits(){
	return this.lesProduits;
    }

    public int getIdType() {
	return this.idType;
    }

    public String getLibType() {
	return this.libType;
    }

    @Override
    public String toString() {
	return libType;
    }

    
}
