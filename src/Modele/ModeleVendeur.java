package Modele;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Article;
import Bean.Commande;
import Bean.Vendeur;
import DAO.AbstractDAOFactory;
import DAO.DAOCommande;
import DAO.DAOVendeur;

public class ModeleVendeur {
	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOVendeur daoVendeur = abstractDAOFactory.getDAOVendeur();
	private DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();

	public Vendeur findLogin(String email, String password)
			throws JAXBException, JsonParseException, JsonMappingException, IOException {
		return daoVendeur.findLogin(email, password);
	}

	public List<Article> findArticlesByVendeur(Vendeur vendeur)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		ModeleArticle modeleArticle = new ModeleArticle();
		List<Article> listArticles = modeleArticle.findArticlesByVendeur(vendeur);

		return listArticles;
	}

/*	public List<Commande> findCommandes(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException {
		return daoCommande.findCommandesVendeur(vendeur , "vendeur" );
	}*/

	public String create(String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {
		if (nom.equals("") || prenom.equals("") || dateNaissance.equals("") || telephone.equals("") || email.equals("")
				|| password.equals("")) {
			return "-2";
		} else {
			Vendeur vendeur = new Vendeur();
			vendeur.setNom(nom);
			vendeur.setPrenom(prenom);
			vendeur.setDateNaissance(dateNaissance);
			vendeur.setTelephone(telephone);
			vendeur.setEmail(email);
			vendeur.setPassword(password);
			return daoVendeur.create(vendeur);
		}
	}

	public List<Commande> findCommandesVendeur(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException {
		return daoCommande.findCommandesVendeur(vendeur/* , "vendeur" */);
	}
	
	public boolean alreadyExist(String email)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		boolean alreadyExist = false;
		List<Vendeur> listVendeurs = daoVendeur.findAll();

		for (Vendeur v : listVendeurs) {
			if (String.valueOf(v.getEmail()) .equals(String.valueOf(email))) {
				alreadyExist = true;
			}
		}

		return alreadyExist;
	}
}
