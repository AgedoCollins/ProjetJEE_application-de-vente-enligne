package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Panier implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Article> listArticles = new ArrayList<>();
	private Commande commande;
	
	public Panier()
	{
		
	}
	
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
	
	public void ajouterArticle(Article article)
	{
		listArticles.add(article);
	}
	
	public void supprimerArticle(Article article)
	{
		listArticles.remove(article);
	}
	
	public String payer(Commande commande, Client client)
	{
		return new Commande().create(commande, client);
	}
	
	public boolean articleAlreadyExist(Article art) 
	{
		boolean alreadyExist = false;
		
		for(Article a : listArticles) 
		{
			if(a.getId() == art.getId()) 
			{
				alreadyExist = true;
			}
		}
		return alreadyExist;
	}
}
