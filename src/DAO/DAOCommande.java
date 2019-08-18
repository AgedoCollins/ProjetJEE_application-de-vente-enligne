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
		f.add("prix_Totale", commande.getPrixTotale());
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
	
	public List<Commande> findCommandesClient(Client client) throws JsonParseException, JsonMappingException, IOException{
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				.queryParam("id", String.valueOf(client.getId()))
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Commande[] comm = mapper.readValue(jsonAnswer, Commande[].class);
			
			for (Commande com : comm) {
				commande = new Commande();
				commande.setId(com.getId());
				commande.setEtat(com.getEtat());
				commande.setDateCommande(com.getDateCommande());
				commande.setPrixTotale(com.getPrixTotale());
				listCommandes.add(commande);
			}
		}
		
		return listCommandes;
	}
	
	public List<Commande> findCommandesVendeur(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException{
		Commande commande = null;
		List<Commande> listCommandes = new ArrayList<>();
		String jsonAnswer = connect
				.path("commandes")
				.path("all")
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
	
	public String updateTraite(Article article) {
		Form f = new Form();
		f.add("id_article", article.getId());
		f.add("id_commande", article.getId_commande());
		return connect.path("commandes").accept(MediaType.TEXT_PLAIN).put(String.class, f);
	}
	
	

}
