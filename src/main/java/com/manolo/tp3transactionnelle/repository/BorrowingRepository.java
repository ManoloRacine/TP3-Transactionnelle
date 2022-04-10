package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    @Query(value = "select b from Borrowing b LEFT JOIN FETCH b.borrowedDocument where b.id = :borrowId")
    Optional<Borrowing> findBorrowingWithDocument(@Param("borrowId") long borrowId) ;
}
