package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
