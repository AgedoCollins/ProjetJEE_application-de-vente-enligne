package Bean;

import java.io.Serializable;
import java.util.List;

public class Panier implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Article> listArticles;
	private Commande commande;
	
	public Panier(List<Article> listArticles, Commande commande)
	{
		this.listArticles=listArticles;
		this.commande=commande;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
}
