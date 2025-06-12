package com.bc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bc.entity.Transaction;
import com.bc.entity.Wallet;
import com.bc.service.WalletService;

@RestController
@RequestMapping("/bitcoin")
public class WalletController {
 
	@Autowired 
	private WalletService walletservice;
	
	@PostMapping
	public ResponseEntity<Wallet> create(@RequestBody Wallet wallet){
		Wallet w=walletservice.createWallet(wallet);
		return ResponseEntity.status(HttpStatus.CREATED).body(w);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		walletservice.deleteWallet(id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Wallet>> getAll(){
		List<Wallet> ww=walletservice.getAllWallets();
		return ResponseEntity.ok().body(ww);
		}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<Transaction>> getTransaction(@PathVariable Long id){
	List<Transaction>l=	walletservice.getTransactionByWallet(id);
	return ResponseEntity.ok().body(l);
	}
	
	@PostMapping("/initate")
	public Transaction initateTransaction(@RequestBody Transaction transaction) {
	   return  walletservice.initiateNewtransaction(transaction);
	   
	}
}
