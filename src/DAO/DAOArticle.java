package DAO;

import com.sun.jersey.api.client.WebResource;

import Bean.Article;

public class DAOArticle extends Idao<Article>{

	public DAOArticle(WebResource conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String create(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article find(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
