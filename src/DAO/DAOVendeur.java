package DAO;

import java.io.IOException;
import java.io.StringReader;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import Bean.Client;
import Bean.Vendeur;

public class DAOVendeur extends DAO<Vendeur>{

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
		return connect.path("vendeurs").accept(MediaType.TEXT_PLAIN).post(String.class, f);
	}

	@Override
	public Vendeur find(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @throws JAXBException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException ******************************************************/
	public Vendeur findLogin(String email, String password) throws JAXBException, JsonParseException, JsonMappingException, IOException {
		Vendeur vendeur = null;
		
		String jsonAnswer = connect.
				path("vendeurs").queryParam("email", email)
				.queryParam("password", password)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			vendeur = mapper.readValue(jsonAnswer, Vendeur.class);
		}
		else
		{
			vendeur = null;
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
