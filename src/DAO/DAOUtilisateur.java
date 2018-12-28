package DAO;

import com.sun.jersey.api.client.WebResource;

import Bean.Utilisateur;

public class DAOUtilisateur extends DAO<Utilisateur>{

	public DAOUtilisateur(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur find(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
