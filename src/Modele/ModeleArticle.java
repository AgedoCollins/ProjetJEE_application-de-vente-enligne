package Modele;

import DAO.AbstractDAOFactory;
import DAO.DAOArticle;

public class ModeleArticle {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOArticle daoArticle = abstractDAOFactory.getDAOArticle();
}
