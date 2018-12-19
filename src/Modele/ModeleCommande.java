package Modele;

import DAO.AbstractDAOFactory;
import DAO.DAOCommande;

public class ModeleCommande {
	private  AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  DAOCommande daoCommande = abstractDAOFactory.getDAOCommande();
}
