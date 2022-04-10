package com.manolo.tp3transactionnelle.repository;

import com.manolo.tp3transactionnelle.model.Book;
import com.manolo.tp3transactionnelle.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findAllByAuthor(String author) ;
    List<Document> findAllByReleaseYear(int year) ;
    List<Document> findDocumentByGenre(String genre) ;
    List<Document> findDocumentByNameContains(String title) ;


}
