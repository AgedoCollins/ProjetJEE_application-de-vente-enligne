package Bean;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import DAO.AbstractDAOFactory;
import DAO.DAOVendeur;

public class Vendeur extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Article> listArticles;

	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOVendeur daoVendeur = abstractDAOFactory.getDAOVendeur();
	
	public Vendeur() {

	}

	public Vendeur(int id, String nom, String prenom, String dateNaissance, String telephone, String email,
			String password, List<Article> listArticles) {
		super(id, nom, prenom, dateNaissance, telephone, email, password);
		this.listArticles = listArticles;
	}

	public Vendeur(String nom, String prenom, String dateNaissance, String telephone, String email, String password,
			Article article, List<Article> listArticles) {
		super(nom, prenom, dateNaissance, telephone, email, password);
		this.listArticles = listArticles;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}
	
	@Override
	public Vendeur findLogin(Utilisateur utilisateur)
			throws JAXBException, JsonParseException, JsonMappingException, IOException {
		return daoVendeur.findLogin(utilisateur);
	}

	public List<Article> findArticlesByVendeur(Vendeur vendeur)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		Article article = new Article();
		List<Article> listArticles = article.findArticlesByVendeur(vendeur);

		return listArticles;
	}
	
	@Override
	public String create(Utilisateur utilisateur) {
		if (utilisateur.getNom().equals("") || utilisateur.getPrenom().equals("") || utilisateur.getDateNaissance().equals("") || utilisateur.getTelephone().equals("") || utilisateur.getEmail().equals("")
				|| utilisateur.getPassword().equals("")) {
			return "-2";
		} else {
			return daoVendeur.create((Vendeur)utilisateur);
		}
	}

	@Override
	public boolean alreadyExist(Utilisateur utilisateur)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		boolean alreadyExist = false;
		List<Vendeur> listVendeurs = daoVendeur.findAll();

		for (Vendeur v : listVendeurs) {
			if (String.valueOf(v.getEmail()) .equals(String.valueOf(utilisateur.getEmail()))) {
				alreadyExist = true;
			}
		}

		return alreadyExist;
	}
	
	/*	public List<Commande> findCommandes(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException {
	return daoCommande.findCommandesVendeur(vendeur , "vendeur" );
}*/
}
