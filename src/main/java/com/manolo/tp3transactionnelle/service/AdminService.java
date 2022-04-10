package com.manolo.tp3transactionnelle.service;

import com.manolo.tp3transactionnelle.model.Account;
import com.manolo.tp3transactionnelle.model.Client;
import com.manolo.tp3transactionnelle.repository.AccountRepository;
import com.manolo.tp3transactionnelle.repository.BorrowingRepository;
import com.manolo.tp3transactionnelle.repository.ClientRepository;
import com.manolo.tp3transactionnelle.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminService {
    private AccountRepository accountRepository ;
    private BorrowingRepository borrowingRepository ;
    private DocumentRepository documentRepository ;
    private ClientRepository clientRepository ;

    public AdminService(AccountRepository accountRepository, BorrowingRepository borrowingRepository, DocumentRepository documentRepository,
                         ClientRepository clientRepository) {
        this.accountRepository = accountRepository ;
        this.borrowingRepository = borrowingRepository ;
        this.documentRepository = documentRepository ;
        this.clientRepository = clientRepository ;
    }

    public long createClient(String firstName, String lastName, String password) {
        Client client = Client.builder().firstName(firstName).lastName(lastName).password(password).build() ;
        accountRepository.save(client) ;
        return client.getId() ;
    }

    public Optional<Client> getClientByIdWithBorrowing(long id) {
        return clientRepository.findClientByIdWithBorrowings(id) ;
    }
}
