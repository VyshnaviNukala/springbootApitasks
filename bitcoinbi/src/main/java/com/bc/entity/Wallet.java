package com.bc.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long walletId;
	
   private String walletAddress;
   private double currentBalance;
   private String ownerName;
   private String ownerEmail;
   private Date registeredDate;
   
   @OneToMany(mappedBy="wallet",cascade=CascadeType.ALL,orphanRemoval=true)
   @JsonManagedReference
   private List<Transaction> transactions;

public Wallet() {
	
}

public Wallet(Long walletId, String walletAddress, double currentBalance, String ownerName, String ownerEmail,
		Date registeredDate, List<Transaction> transactions) {
	this.walletId = walletId;
	this.walletAddress = walletAddress;
	this.currentBalance = currentBalance;
	this.ownerName = ownerName;
	this.ownerEmail = ownerEmail;
	this.registeredDate = registeredDate;
	this.transactions = transactions;
}

public Long getWalletId() {
	return walletId;
}

public void setWalletId(Long walletId) {
	this.walletId = walletId;
}

public String getWalletAddress() {
	return walletAddress;
}

public void setWalletAddress(String walletAddress) {
	this.walletAddress = walletAddress;
}

public double getCurrentBalance() {
	return currentBalance;
}

public void setCurrentBalance(double currentBalance) {
	this.currentBalance = currentBalance;
}

public String getOwnerName() {
	return ownerName;
}

public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}

public String getOwnerEmail() {
	return ownerEmail;
}

public void setOwnerEmail(String ownerEmail) {
	this.ownerEmail = ownerEmail;
}

public Date getRegisteredDate() {
	return registeredDate;
}

public void setRegisteredDate(Date registeredDate) {
	this.registeredDate = registeredDate;
}

public List<Transaction> getTransactions() {
	return transactions;
}

public void setTransactions(List<Transaction> transactions) {
	this.transactions = transactions;
}
   
   
   
}
