package fr.hamterro.back_spring_user.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hamterro.back_spring_user.models.user.AccountLogin;
import fr.hamterro.back_spring_user.repositories.AccountLogginRepository;

@RestController
@RequestMapping(path="/api/account")
public class AccountLoginController {
	
	@Autowired
	private AccountLogginRepository accountLogginRepository;
	
	@GetMapping(path="/all")
	public Iterable<AccountLogin> getAllAccountLoggins(){
		return accountLogginRepository.findAll();
	}
	
	@GetMapping(path="/search/{username}")
	public AccountLogin getAccountLogginByUsername(@PathVariable String username){
		return accountLogginRepository.findByUsername(username);
	}
	
	@PostMapping(path="/create")
	public void createProduit(@Valid @RequestBody AccountLogin account) {
		
		AccountLogin foundAccount = accountLogginRepository.findByUsername(account.getUsername());
		if (foundAccount == null && account.getUsername() != null && account.getUsername() != "" && account.getPassword() != null && account.getPassword() != "") {
			accountLogginRepository.save(account);
		} else {
			System.err.println("Error when creating an account");
		}
	}
	
	@DeleteMapping(path = "/remove/{id}")
	public void removeAccountLoggin(@PathVariable Long id) {
		accountLogginRepository.deleteById(id);
	}
	
}
