package com.manolo.tp3transactionnelle.service;

import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.model.Document;
import com.manolo.tp3transactionnelle.repository.AccountRepository;
import com.manolo.tp3transactionnelle.repository.BorrowingRepository;
import com.manolo.tp3transactionnelle.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {
    private AccountRepository accountRepository ;
    private BorrowingRepository borrowingRepository ;
    private DocumentRepository documentRepository ;

    public ClientService(AccountRepository accountRepository, BorrowingRepository borrowingRepository, DocumentRepository documentRepository) {
        this.accountRepository = accountRepository ;
        this.borrowingRepository = borrowingRepository ;
        this.documentRepository = documentRepository ;
    }

    public List<Document> researchDocumentByAuthor(String author) {
        return documentRepository.findAllByAuthor(author) ;
    }

    public List<Document> researchDocumentByYear(int year) {
        return documentRepository.findAllByReleaseYear(year) ;
    }

    public List<Document> researchDocumentByCategory(String category) {
        return documentRepository.findDocumentByGenre(category) ;
    }

    public List<Document> researchDocumentContainingTitle(String title) {
        return documentRepository.findDocumentByNameContains(title) ;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll() ;
    }

    public void borrowDocument(long clientId, long documentId) {
        //Client client = accountRepository.findById(clientId) ;
    }
}
