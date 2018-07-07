package com.way2learn.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.way2learn.model.TransactionDetail;

public interface TransactionRepository {

	public Long addTransaction(TransactionDetail transactionDetail) throws SQLException;
	public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException;
	public List<TransactionDetail> getAllTransactionDetailsByAccountNumberAndDate(Long accountNumber,Date fromDate) throws SQLException;

}
