package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalogue implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Article> listArticles;

	public Catalogue() {
		listArticles = new ArrayList<>();
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	public void ajouterArticleListe(Article article) {
		listArticles.add(article);
	}

	public void supprimerArticleListe(Article article) {
		listArticles.remove(article);
	}
}
