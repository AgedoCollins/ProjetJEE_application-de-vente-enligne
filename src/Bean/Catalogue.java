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

	public Article rechercherArticleListe(String libelle) {
		Article article = new Article();
		for (Article art : listArticles) {
			if (art.getLibelle() == libelle) {
				article.setLibelle(art.getLibelle());
				article.setDescriptif(art.getDescriptif());
				article.setPrix(art.getPrix());
				article.setNomImage(art.getNomImage());
			}
		}

		return article;
	}

	public List<Article> consulterListe() {
		List<Article> listArt = new ArrayList<>();
		Article article = new Article();
		for (Article art : listArticles) {

			article.setLibelle(art.getLibelle());
			article.setDescriptif(art.getDescriptif());
			article.setPrix(art.getPrix());
			article.setNomImage(art.getNomImage());

		}

		return listArt;
	}
}
