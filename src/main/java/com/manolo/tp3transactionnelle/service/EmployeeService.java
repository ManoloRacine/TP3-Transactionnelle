package com.manolo.tp3transactionnelle.service;

import com.manolo.tp3transactionnelle.model.Book;
import com.manolo.tp3transactionnelle.model.CD;
import com.manolo.tp3transactionnelle.model.DVD;
import com.manolo.tp3transactionnelle.model.Document;
import com.manolo.tp3transactionnelle.repository.AccountRepository;
import com.manolo.tp3transactionnelle.repository.BorrowingRepository;
import com.manolo.tp3transactionnelle.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    private AccountRepository accountRepository ;
    private BorrowingRepository borrowingRepository ;
    private DocumentRepository documentRepository ;

    public EmployeeService(AccountRepository accountRepository, BorrowingRepository borrowingRepository, DocumentRepository documentRepository) {
        this.accountRepository = accountRepository ;
        this.borrowingRepository = borrowingRepository ;
        this.documentRepository = documentRepository ;
    }

    public long createCD(String name, String author, int releaseYear, int nbMinutes, String genre, int nbAvailable) {
        CD cd = CD.builder().name(name).genre(genre).
                author(author).
                releaseYear(releaseYear).
                nbMinutes(nbMinutes).nbAvailable(nbAvailable).build() ;
        documentRepository.save(cd) ;
        return cd.getId() ;
    }

    public long createDVD(String name, String author, int releaseYear, int nbMinutes, String genre, int nbAvailable) {
        DVD dvd = DVD.builder().name(name).genre(genre).
                author(author).
                releaseYear(releaseYear).
                nbMinutes(nbMinutes).nbAvailable(nbAvailable).build() ;
        documentRepository.save(dvd) ;
        return dvd.getId() ;
    }

    public long createBook(String name, String author, int releaseYear, int nbOfPages, String genre, int nbAvailable) {
        Book book = Book.builder().name(name).author(author)
                .releaseYear(releaseYear).nbOfPages(nbOfPages)
                .genre(genre).nbAvailable(nbAvailable).build() ;
        documentRepository.save(book) ;
        return book.getId() ;
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
}
