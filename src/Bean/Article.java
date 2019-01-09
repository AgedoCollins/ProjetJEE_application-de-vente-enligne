package Bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import DAO.AbstractDAOFactory;
import DAO.DAOArticle;

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String libelle;
	private double prix;
	private String descriptif;
	private String nomImage;

	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOArticle daoArticle = abstractDAOFactory.getDAOArticle();
	
	public Article() {

	}

	public Article(int id, String libelle, double prix, String descriptif, String nomImage) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
	}

	public Article(String libelle, double prix, String descriptif, String nomImage) {
		this.libelle = libelle;
		this.prix = prix;
		this.descriptif = descriptif;
		this.nomImage = nomImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String create(String libelle, double prix, String descriptif, String nomImage,Vendeur vendeur) {
		if (libelle.equals(""))
			return "-2";
		else {
			Article article = new Article();
			article.setLibelle(libelle);
			article.setPrix(prix);
			article.setDescriptif(descriptif);
			article.setNomImage(nomImage);
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

	public List<Article> findAll() throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoArticle.findAll();
	}
	
	public Article findArticle(String id) throws JsonParseException, JsonMappingException, IOException, JSONException, JAXBException {
		return daoArticle.findArticle(id);
	}
	
	public List<Article> findArticlesByVendeur(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoArticle.findArticlesByVendeur(vendeur);
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", descriptif=" + descriptif
				+ ", nomImage=" + nomImage + "]";
	}
	
	
}
