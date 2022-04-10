package com.manolo.tp3transactionnelle.DTO;

import com.manolo.tp3transactionnelle.model.Borrowing;
import com.manolo.tp3transactionnelle.model.Document;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowingDTO {
    public long id ;
    public LocalDateTime locationDate ;
    public LocalDateTime returnDate ;

    public DocumentSimpleDTO borrowedDocument ;

    public BorrowingDTO(Borrowing borrowing) {
        this.id = borrowing.getId() ;
        this.locationDate = borrowing.getLocationDate() ;
        this.returnDate = borrowing.getReturnDate() ;
        this.borrowedDocument = new DocumentSimpleDTO(borrowing.getBorrowedDocument()) ;
    }
}
