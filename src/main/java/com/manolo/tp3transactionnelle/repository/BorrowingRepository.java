package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
