package fr.hamterro.back_spring_user.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.hamterro.back_spring_user.models.user.AccountLogin;

public interface AccountLogginRepository extends CrudRepository<AccountLogin, Long>{
	
	public AccountLogin findByUsername(String username);
	
}
