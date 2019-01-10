package DAO;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.json.JSONException;
import Bean.Client;
import Bean.Utilisateur;
import DAO.DAO;

public class DAOClient extends DAO<Client>{

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
		
		System.out.println("CONNECTION : " + connect);
		
		return connect.path("clients").accept(MediaType.TEXT_PLAIN).post(String.class, f);
	}

	@Override
	public Client find(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @throws JAXBException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException ******************************************************/
	public Client findLogin(Utilisateur uti) throws JAXBException, JsonParseException, JsonMappingException, IOException {
		Client client = null;
		
		String jsonAnswer = connect.
				path("clients").queryParam("email", uti.getEmail())
				.queryParam("password", uti.getPassword())
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			client = mapper.readValue(jsonAnswer, Client.class);
			SimpleDateFormat old = new SimpleDateFormat("YYYY-MM-dd");
			SimpleDateFormat nouv= new SimpleDateFormat("dd/MM/YYYY");
			Date tmp;
			String date;
			date = client.getDateNaissance();
			try {
				tmp = old.parse(date);
				date = nouv.format(tmp);
				client.setDateNaissance(date);
			}
			catch (Exception err) {}
		}
		else
		{
			client = null;
		}
		 
			return client;
	}
	
	public List<Client> findAll() throws JsonParseException, JsonMappingException, IOException, JSONException{
		Client cli = null;

		List<Client> listClients = new ArrayList<>();
		String jsonAnswer = connect
				.path("clients")
				.path("all")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		if(!jsonAnswer.equals("")) {
			ObjectMapper mapper = new ObjectMapper();
			Client[] client = mapper.readValue(jsonAnswer, Client[].class);
			
			for (Client c : client) {
				cli = new Client();
				cli.setId(c.getId());
				cli.setNom(c.getNom());
				cli.setPrenom(c.getPrenom());
				cli.setDateNaissance(c.getDateNaissance());	
				cli.setTelephone(c.getTelephone());	
				cli.setEmail(c.getEmail());	
				cli.setPassword(c.getPassword());	
				listClients.add(cli);
			}
			/*JSONObject json = new JSONObject(jsonAnswer);
			JSONArray tab_articles = json.getJSONArray("articles");*/
			//int n = tab_articles.length();
			/*for(int i = 0; i<n; i++) {
				listArticles.add(art);
			}*/
		}
		
		return listClients;
	}
	
	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client client) {
		Form f = new Form();
		f.add("nom", client.getNom());
		f.add("prenom", client.getPrenom());
		f.add("dateNaissance", client.getDateNaissance());
		f.add("telephone", client.getTelephone());
		f.add("email", client.getEmail());
		f.add("password", client.getPassword());
		f.add("id", client.getId());
		connect.path("clients").path("update").put(String.class,f);
		return true;
	}
}