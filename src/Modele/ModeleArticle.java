package Modele;

import java.util.List;

import Bean.Article;
import DAO.AbstractDAOFactory;
import DAO.DAOArticle;

public class ModeleArticle {
	private AbstractDAOFactory abstractDAOFactory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOArticle daoArticle = abstractDAOFactory.getDAOArticle();

/*	public List<Article> findAll() {
		return daoArticle.findAll();
	}*/
}
