package fr.hamterro.back_spring_user.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.hamterro.back_spring_user.models.user.AccountLoggin;

public interface AccountLogginRepository extends CrudRepository<AccountLoggin, Long>{
	
	public AccountLoggin findByUsername(String username);
	
}
