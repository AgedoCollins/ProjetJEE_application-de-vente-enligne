package Bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import DAO.AbstractDAOFactory;
import DAO.DAOCommande;

public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String dateCommande;
	private String etat;

	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();

	public Commande() {

	}

	public Commande(int id, String dateCommande, String etat) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.etat = etat;
	}

	public Commande(String dateCommande, String etat) {
		this.dateCommande = dateCommande;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String create(Commande commande, Client client) {
		return daoCommande.create(commande, client);

	}

	public String createLigneCommande(Commande commande, Article article, int quantite) {
		return daoCommande.createLigneCommande(commande, article, quantite);

	}

	public List<Article> findAll(Vendeur vendeur)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findAllArticle(vendeur);
	}

	public List<Commande> findAllForLastId()
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.findAllForLastId();
	}

	public int findLastId() throws JsonParseException, JsonMappingException, IOException, JSONException {
		int lastID = 0;
		List<Commande> listCommandes = daoCommande.findAllForLastId();

		for (Commande commande : listCommandes) {
			commande = listCommandes.get(listCommandes.size() - 1);
			lastID = commande.getId();
		}

		return lastID;
	}

	public String updateTraite(Article article) throws JsonParseException, JsonMappingException, IOException, JSONException {
		return daoCommande.updateTraite(article);
	}

	public List<Commande> findCommandesClient(Client client) throws JsonParseException, JsonMappingException, IOException {
		return daoCommande.findCommandesClient(client);
	}

}
