package DAO;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Bean.Client;
import DAO.Idao;

public class DAOClient extends Idao<Client>{

	public DAOClient(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Client client) {
		Form f = new Form();
		f.add("nom", client.getNom());
		f.add("prenom", client.getPrenom());
		f.add("dateNaissance", client.getDateNaissance());
		f.add("telephone", client.getTelephone());
		f.add("email", client.getEmail());
		f.add("password", client.getPassword());
		
		System.out.println("CONNECTION : " + connect.path("utilisateurs").accept(MediaType.TEXT_PLAIN).post(String.class, f));
		return "a";
	}

	@Override
	public Client find(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @throws JAXBException ******************************************************/
	public Client findLogin(String email, String password) throws JAXBException {
		Client client = null;
		
		String xmlAnswer = connect.
				path("utilisateurs").queryParam("email", email)
				.queryParam("password", password)
				.accept(MediaType.APPLICATION_XML)
				.get(String.class);
		
		if(!xmlAnswer.equals("")) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlAnswer);
			client = (Client) unmarshaller.unmarshal(reader);
		}
		 
			return client;
	}
	
	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
