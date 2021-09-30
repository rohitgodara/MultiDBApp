package com.multidb.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidb.wallet.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	Wallet findByUserId(Integer userId);

}
