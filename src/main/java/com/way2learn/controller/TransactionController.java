package com.way2learn.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.way2learn.model.TransactionDetail;
import com.way2learn.repository.TransactionRepository;

@Controller
@RequestMapping("/transactions/*")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	

	
	@RequestMapping(value="/{accountNumber}/{fromDate}")
	public List<TransactionDetail> getTransactionsfromDate(@RequestParam Long accountNumber,
			@RequestParam @DateTimeFormat(iso=ISO.DATE,pattern="dd-MM-yyyy") Date fromDate ) throws SQLException{
		
		List<TransactionDetail> transactionDetails=
				transactionRepository.getAllTransactionDetailsByAccountNumberAndDate(accountNumber, fromDate);
		return transactionDetails;
		
	}

}
