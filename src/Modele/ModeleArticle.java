package Modele;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Article;
import Bean.Vendeur;
import DAO.AbstractDAOFactory;
import DAO.DAOArticle;

public class ModeleArticle {
	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOArticle daoArticle = abstractDAOFactory.getDAOArticle();

	public List<Article> findAll() throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoArticle.findAll();
	}
	
	public List<Article> findArticlesByVendeur(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoArticle.findArticlesByVendeur(vendeur);
	}

	
	public String create(String libelle, double prix, String descriptif, String nomImage,Vendeur vendeur) {
		if (libelle.equals(""))
			return "-2";
		else {
			Article article = new Article();
			article.setLibelle(libelle);
			article.setPrix(prix);
			article.setDescriptif(descriptif);
			return daoArticle.create(article, vendeur);
		}
	}

	public String update(int id, String libelle, double prix, String descriptif, String nomImage) {
		if (libelle.equals(""))
			return "-2";
		else {
			Article article = new Article();
			article.setId(id);
			article.setLibelle(libelle);
			article.setPrix(prix);
			article.setDescriptif(descriptif);
			return daoArticle.updateArticle(article);
		}
	}
	
	public boolean delete(Article article) {
		return daoArticle.delete(article);
	}
}
