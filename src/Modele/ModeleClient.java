package Modele;

import java.util.Date;

import javax.xml.bind.JAXBException;

import Bean.Client;
import DAO.AbstractDAOFactory;
import DAO.DAOClient;

public class ModeleClient {
	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOClient daoClient = abstractDAOFactory.getDAOClient();

	public Client findLogin(String email, String password) throws JAXBException {
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
