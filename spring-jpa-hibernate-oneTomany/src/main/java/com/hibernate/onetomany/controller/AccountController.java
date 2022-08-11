package com.hibernate.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.onetomany.entities.Account;
import com.hibernate.onetomany.services.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping(value = "/getaccount/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable Integer id) {

		Account account = accountService.getAccount(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getallaccount")
	public ResponseEntity<List<Account>> getAllAccount() {

		List<Account> account = accountService.getAllAccount();
		return new ResponseEntity<List<Account>>(account, HttpStatus.OK);
	}

	@PostMapping(value = "/adduser")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {

		Account accountDetails = accountService.addAccount(account);
		return new ResponseEntity<Account>(accountDetails, HttpStatus.CREATED);
	}

}
