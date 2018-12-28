package ServiceWeb;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class Link_WebService {
	
	public static WebResource getService(){
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		return service;
	}

	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/Projet_REST/rest").build();
	}

}


