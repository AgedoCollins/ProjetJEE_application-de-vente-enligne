package DAO;

import com.sun.jersey.api.client.WebResource;

import Bean.Client;
import ServiceWeb.Link_WebService;

public class Main {

	public static void main(String[] args) {
		WebResource connect = Link_WebService.getService();
		DAOClient daoClient = new DAOClient(connect);
		System.out.println(daoClient.create(new Client("testtt", "testtt", "18/02/1994", "+32474747474", "a@a.com", "aaaa")));

	}

}
