package Bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import DAO.AbstractDAOFactory;
import DAO.DAOClient;
import DAO.DAOCommande;

public class Client extends Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	private Panier panier;

	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOClient daoClient = abstractDAOFactory.getDAOClient();
	private DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();
	
	public Client() {

	}

	public Client(int id, String nom, String prenom, String dateNaissance, String telephone, String email,
			String password, Panier panier) {
		super(id, nom, prenom, dateNaissance, telephone, email, password);
		this.panier = panier;
	}

	public Client(String nom, String prenom, String dateNaissance, String telephone, String email, String password,
			Panier panier) {
		super(nom, prenom, dateNaissance, telephone, email, password);
		this.panier = panier;
	}

	public Client(String nom, String prenom, String dateNaissance, String telephone, String email, String password) {
		super(nom, prenom, dateNaissance, telephone, email, password);
		
	}
	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Client findLogin(String email, String password) throws JAXBException, JsonParseException, JsonMappingException, IOException {
		return daoClient.findLogin(email, password);
	}

	public String create(Client client) {

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
	
	public boolean alreadyExist(Client client, String email)
			throws JsonParseException, JsonMappingException, IOException, JSONException {
		boolean alreadyExist = false;
		List<Client> listClients = daoClient.findAll();

		for (Client c : listClients) {
			if(c.getId() > 0)
			{
				if (String.valueOf(c.getEmail()) .equals(String.valueOf(email)) && c.getId() != client.getId()) {
					alreadyExist = true;
				}
			}
			else
			{
				if (String.valueOf(c.getEmail()) .equals(String.valueOf(email)))
				{
					alreadyExist = true;
				}
			}
		}
		return alreadyExist;
	}
}
