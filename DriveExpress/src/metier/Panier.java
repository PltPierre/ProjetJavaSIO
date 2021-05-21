package metier;


public class Panier {

    private int idPanier;
    private User user;

    public Panier(int idPanier, metier.User user) {
	this.idPanier = idPanier;
	this.user = user;
    }

    public int getIdPanier() {
	return this.idPanier;
    }

    public User getUser() {
	return this.user;
    }

}
