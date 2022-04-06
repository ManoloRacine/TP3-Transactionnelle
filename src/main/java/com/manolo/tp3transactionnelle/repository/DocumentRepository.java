package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findAllByAuthor(String author) ;
}
