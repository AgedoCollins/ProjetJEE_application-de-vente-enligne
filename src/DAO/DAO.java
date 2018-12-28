package DAO;


import com.sun.jersey.api.client.WebResource;

public abstract class DAO<T> {
	  protected WebResource connect = null;
	   
	  public DAO(WebResource conn){
		  this.connect = conn;
	  }
	
	  public abstract String create(T obj);
	
	  public abstract T find(T obj);
	
	  public abstract boolean delete(T obj);
	
	  public abstract boolean update(T obj);
}

