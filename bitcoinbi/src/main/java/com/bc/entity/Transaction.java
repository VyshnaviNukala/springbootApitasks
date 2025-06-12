package com.bc.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long transactionId;
	
  private Date timestamp;
  private double amount;
  private String transactionType;
  private String transactionStatus;
  
  @ManyToOne
  @JoinColumn(name="wfk")
  @JsonBackReference
  private Wallet wallet;

public Transaction() {
	
}

public Transaction(Long transactionId, Date timestamp, double amount, String transactionType, String transactionStatus,
		Wallet wallet) {
	this.transactionId = transactionId;
	this.timestamp = timestamp;
	this.amount = amount;
	this.transactionType = transactionType;
	this.transactionStatus = transactionStatus;
	this.wallet = wallet;
}

public Long getTransactionId() {
	return transactionId;
}

public void setTransactionId(Long transactionId) {
	this.transactionId = transactionId;
}

public Date getTimestamp() {
	return timestamp;
}

public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getTransactionType() {
	return transactionType;
}

public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}

public String getTransactionStatus() {
	return transactionStatus;
}

public void setTransactionStatus(String transactionStatus) {
	this.transactionStatus = transactionStatus;
}

public Wallet getWallet() {
	return wallet;
}

public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}
  
  
  
  
  
  
  
  
  
  
  
}
