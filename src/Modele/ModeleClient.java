package Modele;

import DAO.AbstractDAOFactory;
import DAO.DAOClient;

public class ModeleClient {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOClient daoClient = abstractDAOFactory.getDAOClient();
}
