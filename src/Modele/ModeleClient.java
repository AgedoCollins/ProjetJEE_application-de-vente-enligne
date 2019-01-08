package Modele;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Client;
import Bean.Commande;

import DAO.AbstractDAOFactory;
import DAO.DAOClient;
import DAO.DAOCommande;

public class ModeleClient {
	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOClient daoClient = abstractDAOFactory.getDAOClient();
	private DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();
	
	public Client findLogin(String email, String password) throws JAXBException, JsonParseException, JsonMappingException, IOException {
		return daoClient.findLogin(email, password);
	}

	public String create(String nom, String prenom, String dateNaissance, String telephone, String email,
			String password) {

		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDateNaissance(dateNaissance);
		client.setTelephone(telephone);
		client.setEmail(email);
		client.setPassword(password);
		return daoClient.create(client);

	}
	
	public List<Commande> findCommandesClient(Client client) throws JsonParseException, JsonMappingException, IOException {
		return daoCommande.findCommandesClient(client/* , "client" */);
	}
	
	public boolean update(String nom, String prenom, String dateNaissance, String telephone, String email,String password, int id) {
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDateNaissance(dateNaissance);
		client.setTelephone(telephone);
		client.setEmail(email);
		client.setPassword(password);
		client.setId(id);
		return daoClient.update(client);
	}
	
	public boolean alreadyExist(String email)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		boolean alreadyExist = false;
		List<Client> listClients = daoClient.findAll();

		for (Client c : listClients) {
			if (String.valueOf(c.getEmail()) .equals(String.valueOf(email))) {
				alreadyExist = true;
			}
		}

		return alreadyExist;
	}
}
