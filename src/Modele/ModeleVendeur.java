package Modele;

import DAO.AbstractDAOFactory;
import DAO.DAOVendeur;

public class ModeleVendeur {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOVendeur daoVendeur = abstractDAOFactory.getDAOVendeur();
}
