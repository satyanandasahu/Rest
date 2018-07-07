package com.way2learn.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.way2learn.model.Account;
import com.way2learn.model.TransactionDetail;
import com.way2learn.model.TransactionType;
import com.way2learn.repository.AccountRepository;
import com.way2learn.repository.RewardRepository;
import com.way2learn.repository.TransactionRepository;

public class BankServiceImpl implements BankService {
	
	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;
	private RewardRepository rewardRepository;	
	private EmailService emailService;
	
	public BankServiceImpl() {
		System.out.println("In BankServiceImpl default constructor");
	}
	

	public BankServiceImpl(AccountRepository accountRepository,
			TransactionRepository transactionRepository) {
		super();
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
		System.out.println("In BankServiceImpl parameterised constructor");
	}

	@Transactional
	public Long transfer(Long fromAccountNumber, Long toAccountNumber, int amount) throws SQLException {
	
			Long transactionId= debit(amount,fromAccountNumber);
			credit(amount, toAccountNumber);
			
			return transactionId;
		
		
	}

	@Transactional
	public Long debit(int amount, Long accountNumber) throws SQLException {
		
					
			Account account=accountRepository.findAccountByNumber(accountNumber);		
			account.debit(amount);		
			accountRepository.update(account);
			
			TransactionDetail fromTransactionDetail= 
					new TransactionDetail(accountNumber,new Date(),amount,TransactionType.DEBIT);

			Long transactionId=transactionRepository.addTransaction(fromTransactionDetail);
			emailService.sendMail(account.getEmailAddress(), "admin@mybank.com", amount+" has been debited from your account");
			
			return transactionId;
		
	}

	@Transactional
	public Long credit(int amount, Long accountNumber) throws SQLException {
		
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.credit(amount);		
		accountRepository.update(account);
		TransactionDetail toTransactionDetail= 
				new TransactionDetail(accountNumber,new Date(),amount,TransactionType.CREDIT);

		Long transactionId=transactionRepository.addTransaction(toTransactionDetail);
		emailService.sendMail(account.getEmailAddress(), "admin@mybank.com", amount+" has been credited into your account");
		return transactionId;

		
	}

	public void createNewAccount(Account account) throws SQLException {
		accountRepository.save(account);
		
	}
	
	public void removeAccount(Long accountNumber) throws SQLException {
		accountRepository.delete(accountNumber);
		
		
	}

	public void deActivateAccount(Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.setActive(false);		
		accountRepository.update(account);
		
	}

	public void activateAccount(Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.setActive(true);		
		accountRepository.update(account);
		
	}

	public List<Account> getAllAccounts() throws SQLException {
		System.out.println("BankServiceImpl.getAllAccounts()");
		return accountRepository.findAllAccounts();
	}
	
	public Account findAccountById(Long accountNumber) {
		
		return accountRepository.findAccountByNumber(accountNumber);
	}
	
	public List<TransactionDetail> getAllTransactionDetailsByAccountNumberAndDate(
			Long accountNumber, Date fromDate) throws SQLException {
		return transactionRepository.getAllTransactionDetailsByAccountNumberAndDate(accountNumber, fromDate);
		
	}


	public AccountRepository getAccountRepository() {
		return accountRepository;
	}


	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}


	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}


	public RewardRepository getRewardRepository() {
		return rewardRepository;
	}


	public void setRewardRepository(RewardRepository rewardRepository) {
		this.rewardRepository = rewardRepository;
	}


	public EmailService getEmailService() {
		return emailService;
	}


	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}





	


	
	
	

}
