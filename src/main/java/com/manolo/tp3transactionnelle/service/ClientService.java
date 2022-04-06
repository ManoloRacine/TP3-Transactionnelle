package com.manolo.tp3transactionnelle.service;

import com.manolo.tp3transactionnelle.repository.AccountRepository;
import com.manolo.tp3transactionnelle.repository.BorrowingRepository;
import com.manolo.tp3transactionnelle.repository.DocumentRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientService {
    private BorrowingRepository borrowingRepository ;
    private DocumentRepository documentRepository ;

    public ClientService(BorrowingRepository borrowingRepository, DocumentRepository documentRepository) {
        this.borrowingRepository = borrowingRepository ;
        this.documentRepository = documentRepository ;
    }


}
