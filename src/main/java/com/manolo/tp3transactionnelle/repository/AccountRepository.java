package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Account;
import com.manolo.tp3transactionnelle.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT c from Client c LEFT JOIN FETCH c.borrowings WHERE c.id = :clientId")
    Optional<Client> findClientByIdWithBorrowings(@Param("clientId") long clientId) ;
}
