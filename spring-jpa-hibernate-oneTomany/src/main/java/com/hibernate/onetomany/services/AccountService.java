package com.hibernate.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.onetomany.entities.Account;
import com.hibernate.onetomany.repositories.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	public Account getAccount(Integer accountId) {
		return accountRepository.findById(accountId).get();
	}
	
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}
	
}
