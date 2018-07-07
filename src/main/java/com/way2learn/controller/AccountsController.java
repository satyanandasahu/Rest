package com.way2learn.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.way2learn.model.Account;
import com.way2learn.model.Accounts;
import com.way2learn.repository.AccountRepository;
import com.way2learn.service.BankService;

@Controller
@RequestMapping("/accounts/*")
public class AccountsController {
	
	@Autowired
	private BankService bankService;
	
	@RequestMapping(value="/{accountNumber}",produces={"application/json","application/xml"},method=RequestMethod.GET)
	public @ResponseBody Account getAccountById(@PathVariable("accountNumber") Long accountNumber){
		
		try {
			return bankService.findAccountById(accountNumber);
		} catch (Exception e) {
			throw new AccountNotFoundException();
		}
		
	}
	
	@RequestMapping(value="/all",produces={"application/xml","application/json"})
	public @ResponseBody Accounts getAllAccounts() throws SQLException{
		Accounts accounts= new Accounts();
		  accounts.setAccounts(bankService.getAllAccounts());
		return accounts;	
	}
	
	@RequestMapping(value="/allwithheaders",
			produces={"application/xml","application/json"})
	public HttpEntity<Accounts> getAllAccountsWithHeaders() throws SQLException{
		Accounts accounts= new Accounts();
		  accounts.setAccounts(bankService.getAllAccounts());
		  
		 HttpHeaders httpHeaders= new HttpHeaders();
		 httpHeaders.add("myheader", "AAAAA");
		  
		  HttpEntity<Accounts> httpEntity= new HttpEntity<Accounts>(accounts,httpHeaders);
		 
		  
		return httpEntity;	
	}
	
	@RequestMapping(produces={"application/xml","application/json"}
					,consumes={"application/xml","application/json"},
							method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public  void createAccountAndDisplay(
			@RequestBody Account account) throws SQLException{
		
		bankService.createNewAccount(account);
			
	}
	
	
}
