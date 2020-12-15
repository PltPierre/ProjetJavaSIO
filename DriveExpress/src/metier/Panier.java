package metier;

import java.sql.*;

public class Panier {

	private int idPanier;
	private User user;
	private Date dateCreation;
	
	public Panier(int idPanier, metier.User user, Date dateCreation) {
		this.idPanier = idPanier;
		this.user = user;
		this.dateCreation = dateCreation;
	}

	public int getIdPanier() {
		return this.idPanier;
	}

	public User getUser() {
		return this.user;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}
	
	
	
	
}
