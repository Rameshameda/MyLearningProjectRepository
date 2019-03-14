package com.learning.client;

import javax.ws.rs.core.MediaType;

import com.learning.bean.EmploayeeBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestJersyClient {
	
	public static void main(String[] args) {
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/MyApp/rest/welcome/comsumeExample");
		ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, "{\"EmployeeID\": 1,\"firstName\": \"rameshmeda\",\"hobbies\": [\"tik tok\",\"face Book\",\"whatsapp\"],\"lastName\": \"bysani\"}");
		System.out.println(clientResponse.getStatus());
		System.out.println(clientResponse.getEntity(String.class));
	}

}
