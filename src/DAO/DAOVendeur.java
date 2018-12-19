package DAO;

import com.sun.jersey.api.client.WebResource;

import Bean.Vendeur;

public class DAOVendeur extends Idao<Vendeur>{

	public DAOVendeur(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendeur find(Vendeur obj) {
		// TODO Auto-generated method stub
		return null;
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
