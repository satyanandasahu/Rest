package com.way2learn.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="allaccounts",namespace="http://way2learn.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts {
	
	@XmlElementWrapper(name="accounts")
	@XmlElement(name="account")
	
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
	

}
