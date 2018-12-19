package DAO;

import com.sun.jersey.api.client.WebResource;

import Bean.Client;

public class DAOClient extends Idao<Client>{

	public DAOClient(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client find(Client obj) {
		// TODO Auto-generated method stub
		return null;
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
