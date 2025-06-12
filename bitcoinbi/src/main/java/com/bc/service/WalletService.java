package com.bc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bc.entity.Transaction;
import com.bc.entity.Wallet;
import com.bc.repo.TransactionRepo;
//import com.bc.repo.TransactionRepo;
import com.bc.repo.WalletRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WalletService {

	
	@Autowired
	private WalletRepo walletrepo;
	
  	@Autowired
	private TransactionRepo transactionrepo;
	
	
	public Wallet createWallet(Wallet wallet) {
		return walletrepo.save(wallet);
	}
	
	public void deleteWallet(Long id) {
		walletrepo.deleteById(id);
	}
	public List<Wallet> getAllWallets() {
		return walletrepo.findAll();
	}
	public List<Transaction> getTransactionByWallet(Long id) {
		return transactionrepo.getTransactionsByWallet_walletId(id);
	}
	public Transaction initiateNewtransaction(Transaction transaction) {
	Wallet w=	walletrepo.findById(transaction.getWallet().getWalletId()).orElseThrow(()->new RuntimeException("wallet not found"));
	if("DEPOSIT".equalsIgnoreCase(transaction.getTransactionType())) {
		w.setCurrentBalance(w.getCurrentBalance()+transaction.getAmount());
		
		transaction.setTransactionStatus("COMPLETED");
		transactionrepo.save(transaction);
		}
		
	
	else if("WITHDRAWAL".equalsIgnoreCase(transaction.getTransactionType())) {
		if(w.getCurrentBalance()<transaction.getAmount()) {
			
			transaction.setTransactionStatus("PENDING");
			transactionrepo.save(transaction);
			throw new RuntimeException("insuffiecent balance");
			
			
		}
		      w.setCurrentBalance(w.getCurrentBalance()-transaction.getAmount());
		      transaction.setTransactionStatus("COMPLETED");
	}
	walletrepo.save(w);
	return transactionrepo.save(transaction);
	}
}
