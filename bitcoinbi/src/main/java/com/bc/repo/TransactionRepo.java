package com.bc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bc.entity.Transaction;
@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
   List<Transaction> getTransactionsByWallet_walletId(Long id);
}
