package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import Bean.Article;
import Bean.Client;
import Bean.Commande;
import Bean.Vendeur;

public class DAOCommande extends DAO<Commande>{

	public DAOCommande(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String create(Commande commande, Client client) {
		Form f = new Form();
		f.add("dateCommande", commande.getDateCommande());
		f.add("id_utilisateur", client.getId());
		return connect.path("commandes").path("ajoutercommande").accept(MediaType.TEXT_PLAIN).post(String.class, f);
	}
	

	public String createLigneCommande(Commande commande, Article article, int quantite) {
		Form f = new Form();
		f.add("id_commande", commande.getId());
		f.add("id_article", article.getId());
		f.add("quantite", quantite);
		return connect.path("commandes").accept(MediaType.TEXT_PLAIN).post(String.class, f);
	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<Commande> findCommandesVendeur(Vendeur vendeur, String classe) throws JsonParseException, JsonMappingException, IOException{
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				//.path(vendeur.getId()+"")
				//.queryParam("classe", classe)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Commande[] comm = mapper.readValue(jsonAnswer, Commande[].class);
			
			for (Commande com : comm) {
				commande = new Commande();
				commande.setId(com.getId());
				commande.setDateCommande(com.getDateCommande());
				commande.setEtat(com.getEtat());
				//commande.setTotal(com.getTotal());
				//commande.setDateLivraison(com.getDateLivraison());
				listCommandes.add(commande);
			}
		}
		
		return listCommandes;
	}*/
	
	public List<Commande> findCommandesClient(Client client/*, String classe*/) throws JsonParseException, JsonMappingException, IOException{
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				//.path(client.getId()+"")
				//.queryParam("classe", classe)
				.queryParam("id", String.valueOf(client.getId()))
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Commande[] comm = mapper.readValue(jsonAnswer, Commande[].class);
			
			for (Commande com : comm) {
				commande = new Commande();
				commande.setId(com.getId());
				commande.setDateCommande(com.getDateCommande());
				listCommandes.add(commande);
			}
		}
		
		return listCommandes;
	}
	
	public List<Commande> findCommandesVendeur(Vendeur vendeur/*, String classe*/) throws JsonParseException, JsonMappingException, IOException{
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				.path("all")
				//.path(client.getId()+"")
				//.queryParam("classe", classe)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Commande[] comm = mapper.readValue(jsonAnswer, Commande[].class);
			
			for (Commande com : comm) {
				commande = new Commande();
				commande.setId(com.getId());
				commande.setDateCommande(com.getDateCommande());
				listCommandes.add(commande);
			}
		}
		
		return listCommandes;
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
	
	public List<Article> findAllArticle(String id) throws JsonParseException, JsonMappingException, IOException, JSONException{
		List<Article> listArticles = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				.path("all")
				.queryParam("id", id)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Article[] articles = mapper.readValue(jsonAnswer, Article[].class);
			
			for (Article art : articles) {
				Article article = new Article();
				article.setId(art.getId());
				article.setLibelle(art.getLibelle());
				article.setDescriptif(art.getDescriptif());
				listArticles.add(article);
			}
		}
		
		return listArticles;
	}
	
	public List<Commande> findAllForLastId() throws JsonParseException, JsonMappingException, IOException, JSONException{
		Commande comm = null;

		List<Commande> listCommandes = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				.path("lastId")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Commande[] commande = mapper.readValue(jsonAnswer, Commande[].class);
			
			for (Commande com : commande) {
				comm = new Commande();
				comm.setId(com.getId());
				comm.setDateCommande(com.getDateCommande());
				listCommandes.add(comm);
			}
		}
		
		return listCommandes;
	}
	
	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String updateTraite(int id) {
		Form f = new Form();
		f.add("id_article", id);
		return connect.path("commandes").accept(MediaType.TEXT_PLAIN).put(String.class, f);
	}
	
	

}
