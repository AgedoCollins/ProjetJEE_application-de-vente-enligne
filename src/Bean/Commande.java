package Bean;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date dateCommande;
	private String etat;
	private double total;
	private Date dateLivraison;

	public Commande(Date dateCommande, String etat, double total, Date dateLivraison) {
		this.dateCommande = dateCommande;
		this.etat = etat;
		this.total = total;
		this.dateLivraison = dateLivraison;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getTotal() {
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

	public void modifierCommande() {

	}

	public void supprimerCommande() {

	}

	public void modifierEtat() {

	}
}
