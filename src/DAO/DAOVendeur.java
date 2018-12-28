package DAO;

import java.io.StringReader;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import Bean.Client;
import Bean.Vendeur;

public class DAOVendeur extends Idao<Vendeur>{

	public DAOVendeur(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Vendeur vendeur) {
		Form f = new Form();
		f.add("nom", vendeur.getNom());
		f.add("prenom", vendeur.getPrenom());
		f.add("dateNaissance", vendeur.getDateNaissance());
		f.add("telephone", vendeur.getTelephone());
		f.add("email", vendeur.getEmail());
		f.add("password", vendeur.getPassword());
		return connect.path("utilisateurs").accept(MediaType.TEXT_PLAIN).post(String.class, f);
	}

	@Override
	public Vendeur find(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @throws JAXBException ******************************************************/
	public Vendeur findLogin(String email, String password) throws JAXBException {
		Vendeur vendeur = null;
		
		String xmlAnswer = connect.
				path("utilisateurs").queryParam("email", email)
				.queryParam("password", password)
				.accept(MediaType.APPLICATION_XML)
				.get(String.class);
		
		if(!xmlAnswer.equals("")) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlAnswer);
			vendeur = (Vendeur) unmarshaller.unmarshal(reader);
		}
		 
			return vendeur;
	}
	
	@Override
	public boolean delete(Vendeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vendeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
