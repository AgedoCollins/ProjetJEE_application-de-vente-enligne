package Bean;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String dateCommande;
	

	public Commande() {

	}

	public Commande(int id, String dateCommande) {
		this.id = id;
		this.dateCommande = dateCommande;
	}

	public Commande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public void modifierCommande() {

	}

	public void supprimerCommande() {

	}

	public void modifierEtat() {

	}
}
