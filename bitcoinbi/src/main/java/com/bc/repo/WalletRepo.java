package com.bc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bc.entity.Wallet;
@Repository
public interface WalletRepo extends JpaRepository<Wallet,Long>{

}
