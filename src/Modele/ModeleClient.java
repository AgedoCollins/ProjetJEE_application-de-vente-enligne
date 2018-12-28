package Modele;

import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Bean.Client;
import DAO.AbstractDAOFactory;
import DAO.DAOClient;

public class ModeleClient {
	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOClient daoClient = abstractDAOFactory.getDAOClient();

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
}
