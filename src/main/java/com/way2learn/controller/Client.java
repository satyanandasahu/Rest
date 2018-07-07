package com.way2learn.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.way2learn.model.Account;
import com.way2learn.model.Accounts;

public class Client {

	public static void main(String[] args) throws Exception {
		RestTemplate restTemplate= new RestTemplate();
		restTemplate.postForLocation("http://localhost:7070/01restbasics/accounts",new Account());
		
		//restTemplate.postfor
		/*ResponseEntity<Account> responseEntity= 
				restTemplate.getForEntity("http://localhost:7070/01restbasics/accounts/1", Account.class);
		
		Account account=responseEntity.getBody();
		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println("Headers : "+headers);
		*/
		/*Account account=restTemplate.getForObject("http://localhost:7070/01restbasics/accounts/{accnum}/{}", 
					Account.class,1 );*/
		//Account account=restTemplate.getForObject("http://localhost:7070/01restbasics/accounts/1", Account.class);
		//System.out.println("Name : "+account.getName());
		
	/*	Map<String , String> urlVariables= new HashMap<String, String>();
		urlVariables.put("id", "1");
		ResponseEntity<Account> responseEntity=
				restTemplate.
				getForEntity("http://localhost:7070/01restbasics/accounts/{id}", 
						Account.class,urlVariables);
		
		System.out.println(responseEntity.getBody().getName());*/
		
		/*ResponseEntity<Accounts> responseEntity=
				restTemplate.getForEntity(
						new URI("http://localhost:7070/01restbasics/accounts/allwithheaders"),
				Accounts.class);
		//restTemplate.getForEntity(url, responseType, urlVariables)
		
		Accounts accounts=responseEntity.getBody();
		for(Account account:accounts.getAccounts()){
			System.out.println(account.getName());
		}
		
		HttpHeaders headers=responseEntity.getHeaders();
		System.out.println(headers);*/
		
		/*Account account=restTemplate.getForObject(
				new URI("http://localhost:7070/01restbasics/accounts/1"), Account.class);

		System.out.println(account.getName());*/
	}

}
