package com.multidb.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidb.form.RegisterationForm;
import com.multidb.user.entity.User;
import com.multidb.user.repository.UserRepository;
import com.multidb.wallet.entity.Wallet;
import com.multidb.wallet.repository.WalletRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WalletRepository walletRepository;

	public User save(RegisterationForm form) {
		User user = new User(form.getName(), form.getEmail(), form.getPassword());
		user = userRepository.save(user);
		Wallet wallet = new Wallet(BigDecimal.ZERO, "FIAT", user.getId());
		walletRepository.save(wallet);
		return user;
	}
}
