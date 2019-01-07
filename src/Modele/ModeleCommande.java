package Modele;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Article;
import Bean.Commande;
import DAO.AbstractDAOFactory;
import DAO.DAOCommande;

public class ModeleCommande {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();
	
	public List<Commande> findAll() throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findAll();
	}
	
	public List<Article> findArticlesByCommande(Commande commande) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findArticlesByCommande(commande);
	}
	
	public String updateTraite(Commande commande) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.updateTraite(commande);
	}
}
