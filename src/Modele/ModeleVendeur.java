package Modele;

import java.util.Date;

import javax.xml.bind.JAXBException;

import Bean.Client;
import Bean.Vendeur;
import DAO.AbstractDAOFactory;
import DAO.DAOVendeur;

public class ModeleVendeur {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOVendeur daoVendeur = abstractDAOFactory.getDAOVendeur();
	
	public Vendeur findLogin(String email, String password) throws JAXBException {
		return daoVendeur.findLogin(email, password);
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
