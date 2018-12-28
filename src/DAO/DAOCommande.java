package DAO;

import com.sun.jersey.api.client.WebResource;

import Bean.Commande;

public class DAOCommande extends DAO<Commande>{

	public DAOCommande(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
