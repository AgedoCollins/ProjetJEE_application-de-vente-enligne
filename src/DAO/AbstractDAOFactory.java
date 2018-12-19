package DAO;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	public abstract DAOArticle getDAOArticle();

	public abstract DAOClient getDAOClient();

	public abstract DAOVendeur getDAOVendeur();

	public abstract DAOCommande getDAOCommande();

	// M�thode permettant de r�cup�rer les Factory
	public static AbstractDAOFactory getFactory(int type) {
		switch (type) {
		case DAO_FACTORY:
			return new DAOFactory();
		case XML_DAO_FACTORY:
			return null;// new XMLDAOFactory();
		default:
			return null;
		}
	}
}
