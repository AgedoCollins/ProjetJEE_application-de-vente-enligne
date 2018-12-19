package Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Vendeur extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Article> listArticles;

	public Vendeur() {

	}

	public Vendeur(int id, String nom, String prenom, Date dateNaissance, String telephone, String email,
			String password, String nomImage, List<Article> listArticles) {
		super(id, nom, prenom, dateNaissance, telephone, email, password, nomImage);
		this.listArticles = listArticles;
	}

	public Vendeur(String nom, String prenom, Date dateNaissance, String telephone, String email, String password,
			String nomImage, Article article, List<Article> listArticles) {
		super(nom, prenom, dateNaissance, telephone, email, password, nomImage);
		this.listArticles = listArticles;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}
}
