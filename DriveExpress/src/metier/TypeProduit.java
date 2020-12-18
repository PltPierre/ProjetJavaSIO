package metier;

public class TypeProduit {

    private int idType;
    private String libType;

    public TypeProduit(int idType, String libType) {

	this.idType = idType;
	this.libType = libType;
    }

    public int getIdType() {
	return this.idType;
    }

    public String getLibType() {
	return this.libType;
    }

}
