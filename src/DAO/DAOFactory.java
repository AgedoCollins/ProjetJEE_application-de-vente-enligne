package DAO;

import com.sun.jersey.api.client.WebResource;

public class DAOFactory extends AbstractDAOFactory {
	protected static final WebResource connect = Link_WebService.getService();

	@Override
	public DAOArticle getDAOArticle() {
		return new DAOArticle(connect);
	}

	@Override
	public DAOClient getDAOClient() {
		return new DAOClient(connect);
	}

	@Override
	public DAOVendeur getDAOVendeur() {
		return new DAOVendeur(connect);
	}

	@Override
	public DAOCommande getDAOCommande() {
		return new DAOCommande(connect);
	}

}
