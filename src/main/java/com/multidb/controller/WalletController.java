package com.multidb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multidb.wallet.entity.Wallet;
import com.multidb.wallet.repository.WalletRepository;

@Controller
@RequestMapping("wallets")
public class WalletController {

	@Autowired
	private WalletRepository repository;

	@GetMapping("{userId}")
	public ResponseEntity<Object> findByUserId(@PathVariable Integer userId) {
		Wallet wallet = repository.findByUserId(userId);
		return ResponseEntity.ok(wallet);
	}
}
