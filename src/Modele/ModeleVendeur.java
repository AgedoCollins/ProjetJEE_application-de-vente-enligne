package Modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Article;
import Bean.Client;
import Bean.Vendeur;
import DAO.AbstractDAOFactory;
import DAO.DAOVendeur;

public class ModeleVendeur {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOVendeur daoVendeur = abstractDAOFactory.getDAOVendeur();
	
	public Vendeur findLogin(String email, String password) throws JAXBException, JsonParseException, JsonMappingException, IOException {
		return daoVendeur.findLogin(email, password);
	}
	
	public List<Article> findArticlesByVendeur(Vendeur vendeur) throws JsonParseException, JsonMappingException, IOException, JSONException{
		ModeleArticle modeleArticle = new ModeleArticle();
		List<Article> listArticles = modeleArticle.findArticlesByVendeur(vendeur);
		
		return listArticles;
	}
	
	public String create(String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		if(nom.equals("") || prenom.equals("") || dateNaissance.equals("") || telephone.equals("") || email.equals("") || password.equals(""))
		{
			return "-2";
		}
		else 
		{
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
}
