package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
