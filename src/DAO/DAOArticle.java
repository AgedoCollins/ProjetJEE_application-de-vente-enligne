package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import Bean.Article;
import Bean.Commande;
import Bean.Vendeur;

public class DAOArticle extends DAO<Article>{

	public DAOArticle(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Article article) {
		return "a";
	}
	
	public String create(Article article, Vendeur vendeur) {
		Form f = new Form();
		f.add("libelle",article.getLibelle());
		f.add("prix", article.getPrix());
		f.add("descriptif", article.getDescriptif());
		f.add("nomimage", article.getNomImage());
		f.add("id_utilisateur", vendeur.getId());
		return connect.path("articles").accept(MediaType.TEXT_PLAIN).post(String.class, f);
	}

	@Override
	public Article find(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> findAll() throws JsonParseException, JsonMappingException, IOException, JSONException{
		Article arti = null;

		List<Article> listArticles = new ArrayList<Article>();
		String jsonAnswer = connect
				.path("articles")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Article[] article = mapper.readValue(jsonAnswer, Article[].class);
			
			for (Article art : article) {
				arti = new Article();
				arti.setId(art.getId());
				arti.setLibelle(art.getLibelle());
				arti.setPrix(art.getPrix());
				arti.setDescriptif(art.getDescriptif());
				arti.setNomImage(art.getNomImage());
				listArticles.add(arti);
			}
		}
		
		return listArticles;
	}
	
	public Article findArticle(Article article) throws JsonParseException, JsonMappingException, IOException, JAXBException 
	{
			// TODO Auto-generated method stub
			Article arti = null;

			String jsonAnswer = connect
					.path("articles/afficher")
					.path(article.getId() + "")
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);

			if(!jsonAnswer.equals("")) {
				ObjectMapper mapper = new ObjectMapper();
				arti = mapper.readValue(jsonAnswer, Article.class);
			}
			
			return arti;
	}
	
	public List<Article> findAllArticle(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException, JSONException{
		List<Article> listArticles = new ArrayList<>();
		String jsonAnswer = connect
				.path("articles")
				.path("all") 
				.queryParam("id", vendeur.getId() + "")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Article[] articles = mapper.readValue(jsonAnswer, Article[].class);
			
			for (Article art : articles) {
				Article article = new Article();
				article.setId(art.getId());
				article.setLibelle(art.getLibelle());
				article.setPrix(art.getPrix());
				article.setDescriptif(art.getDescriptif());
				article.setId_commande(art.getId_commande());
				listArticles.add(article);
			}
		}
		
		return listArticles;
	}
	
	public List<Article> findArticlesByVendeur(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException, JSONException{
		Article arti = null;
		
		List<Article> listArticles = new ArrayList<Article>();
		String jsonAnswer = connect
				.path("articles")
				.path(vendeur.getId() + "")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Article[] article = mapper.readValue(jsonAnswer, Article[].class);
			
			for (Article art : article) {
				arti = new Article();
				arti.setId(art.getId());
				arti.setLibelle(art.getLibelle());
				arti.setPrix(art.getPrix());
				arti.setDescriptif(art.getDescriptif());
				arti.setNomImage(art.getNomImage());
				listArticles.add(arti);
			}
		}
		
		return listArticles;
	}
	
	public List<Article> findArticlesByCommande(Commande commande) throws JsonParseException, JsonMappingException, IOException, JSONException{
		Article arti = null;

		List<Article> listArticles = new ArrayList<Article>();
		String jsonAnswer = connect
				.path("commandes")
				.path(commande.getId() + "")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Article[] article = mapper.readValue(jsonAnswer, Article[].class);
			
			for (Article art : article) {
				arti = new Article();
				arti.setId(art.getId());
				arti.setLibelle(art.getLibelle());
				arti.setPrix(art.getPrix());
				arti.setDescriptif(art.getDescriptif());
				arti.setNomImage(art.getNomImage());
				listArticles.add(arti);
			}
		}
		
		return listArticles;
	}
	
	@Override
	public boolean delete(Article article) {
		String rsp = connect
				.path("articles")
				.path(article.getId()+"")
				.accept(MediaType.TEXT_PLAIN)
				.delete(String.class);
		if(rsp.equals("ok"))
			return true;
		else
			return false;
	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String updateArticle(Article article) {
			Form f = new Form();
			f.add("id", article.getId());
			f.add("libelle",article.getLibelle());
			f.add("prix", article.getPrix());
			f.add("descriptif", article.getDescriptif());
			f.add("nomImage", article.getNomImage());
			return connect.path("articles").accept(MediaType.TEXT_PLAIN).put(String.class, f);

	}
}
