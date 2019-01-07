package DAO;

import java.util.Date;

import com.sun.jersey.api.client.WebResource;

import Bean.Client;


public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebResource connect = Link_WebService.getService();
		DAOClient daoClient = new DAOClient(connect);
		System.out.println(daoClient.create(new Client("testtt", "testtt", "18/02/1994", "+32474747474", "a@a.com", "aaaa")));

	}

}
