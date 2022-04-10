package com.manolo.tp3transactionnelle.service;

import com.manolo.tp3transactionnelle.model.Borrowing;
import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.model.Document;
import com.manolo.tp3transactionnelle.repository.AccountRepository;
import com.manolo.tp3transactionnelle.repository.BorrowingRepository;
import com.manolo.tp3transactionnelle.repository.ClientRepository;
import com.manolo.tp3transactionnelle.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Optional;

@Component
public class ClientService {
    private AccountRepository accountRepository ;
    private BorrowingRepository borrowingRepository ;
    private DocumentRepository documentRepository ;
    private ClientRepository clientRepository ;

    public ClientService(AccountRepository accountRepository, BorrowingRepository borrowingRepository, DocumentRepository documentRepository,
                         ClientRepository clientRepository) {
        this.accountRepository = accountRepository ;
        this.borrowingRepository = borrowingRepository ;
        this.documentRepository = documentRepository ;
        this.clientRepository = clientRepository ;
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

    @Transactional
    public void borrowDocument(long clientId, long documentId, int nbDays) throws Exception {
        Optional<Client> client = clientRepository.findClientByIdWithBorrowings(clientId) ;

        if (client.isEmpty()) throw new Exception() ;

        Document document = documentRepository.getById(documentId) ;


        if (document.getNbAvailable() == 0) throw new Exception() ; //todo personalised exception

        Borrowing borrowing = Borrowing.builder().locationDate(LocalDateTime.now()).
                returnDate(LocalDateTime.now().plus(nbDays, ChronoUnit.DAYS)).borrowedDocument(document).build() ;

        document.setNbAvailable(document.getNbAvailable() - 1);

        client.get().borrowDocument(borrowing);

        documentRepository.save(document) ;
        borrowingRepository.save(borrowing) ;
        clientRepository.save(client.get()) ;
    }
}
