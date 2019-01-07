package Modele;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Article;
import Bean.Client;
import Bean.Commande;
import Bean.Vendeur;
import DAO.AbstractDAOFactory;
import DAO.DAOCommande;

public class ModeleCommande {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();
	
	public String create(String dateCommande, String etat, Client client) {
		Commande commande = new Commande();
		commande.setDateCommande(dateCommande);
		commande.setEtat(etat);
		return daoCommande.create(commande, client);
		
	}
	
	public String createLigneCommande(Commande commande, Article article) {
		return daoCommande.createLigneCommande(commande, article);
		
	}
	
	public List<Commande> findAll() throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findAll();
	}
	
	public List<Commande> findAllForLastId() throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findAllForLastId();
	}
	
	public List<Article> findArticlesByCommande(Commande commande) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findArticlesByCommande(commande);
	}
	
	public int findLastId() throws JsonParseException, JsonMappingException, IOException, JSONException
	{
		int lastID = 0;
		List<Commande> listCommandes = daoCommande.findAllForLastId();
		
		for(Commande commande : listCommandes)
		{
			commande = listCommandes.get(listCommandes.size()-1);
			lastID = commande.getId();
		}
		
		return lastID;
	}
	
	public String updateTraite(Commande commande) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.updateTraite(commande);
	}
}
