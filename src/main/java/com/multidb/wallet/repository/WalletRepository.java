package com.multidb.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidb.order.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
