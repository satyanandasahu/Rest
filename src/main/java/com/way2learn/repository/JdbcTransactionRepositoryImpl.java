package com.way2learn.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.way2learn.model.TransactionDetail;
import com.way2learn.model.TransactionType;

public class JdbcTransactionRepositoryImpl implements TransactionRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	public Long addTransaction(TransactionDetail transactionDetail) throws SQLException {
		System.out.println("Adding transaction : "+transactionDetail.getTxType());
		String query="insert into TransactionDetail(accountnumber,transactiondate,amount,txtype) values(?,?,?,?) ";
		jdbcTemplate.update(query,transactionDetail.getAccountNumber(),transactionDetail.getTransactionDate(),
				transactionDetail.getAmount(),transactionDetail.getTxType().toString());
		
		
		return null;
	}

	public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException {
		String query="select * from TransactionDetail td where td.accountNumber=?";
		
	return jdbcTemplate.query(query, new BeanPropertyRowMapper<TransactionDetail>(TransactionDetail.class));
	}

	public List<TransactionDetail> getAllTransactionDetailsByAccountNumberAndDate(
			Long accountNumber, java.util.Date fromDate) throws SQLException {
		String query="select * from TransactionDetail td where td.accountNumber=? and transactionDate > ?";
		return jdbcTemplate.query(query, new Object[]{accountNumber,new Date(fromDate.getTime())}, 
				new BeanPropertyRowMapper<TransactionDetail>(TransactionDetail.class));
	
	}

	
	
	

}
