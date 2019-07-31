package com.usa.state.gov.his.restclient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
public class RestClientForStateValidation {
	
	
	public String getStateName(Long ssnNumber)
	{
	    
	
	final String uri = "http://localhost:8888/restValidation/state";
    
    Client client = Client.create();
    WebResource webResource = client.resource(uri);
    ClientResponse clientResponse = webResource.header("ssnNumber", ssnNumber).get(ClientResponse.class);
    String msg = clientResponse.getEntity(String.class);
    System.out.println("from client" +msg);
    return msg;
    
     
    /*RestTemplate restTemplate = new RestTemplate();
     
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<String>("ssnNumber", headers);
     
    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
     
    System.out.println("from client code " +result);
    
		final String uri = "http://localhost:8888/restValidation/state/"+ssnNumber;
		RestTemplate restTemplate = new RestTemplate();
		String msg =  restTemplate.getForObject(uri, String.class);
		System.out.println("comming from local"+msg);
		return msg;*/
	}
    
}
