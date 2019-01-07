package Bean;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String dateCommande;
	private String etat;
	//private double total;
	private Date dateLivraison;

	public Commande() {

	}

	public Commande(int id, String dateCommande, String etat/*, double total, Date dateLivraison*/) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.etat = etat;
		/*this.total = total;
		this.dateLivraison = dateLivraison;*/
	}

	public Commande(String dateCommande, String etat/*, double total, Date dateLivraison*/) {
		this.dateCommande = dateCommande;
		this.etat = etat;
		/*this.total = total;
		this.dateLivraison = dateLivraison;*/
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

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	/*public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
*/
	public void modifierCommande() {

	}

	public void supprimerCommande() {

	}

	public void modifierEtat() {

	}
}
