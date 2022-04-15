package com.manolo.tp3transactionnelle.dto;

import com.manolo.tp3transactionnelle.model.Borrowing;
import com.manolo.tp3transactionnelle.model.Client;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {
    private long id ;

    private String firstName ;
    private String lastName ;

    private List<BorrowingDTO> borrowings = new ArrayList<>();

    public ClientDTO(Client client) {
        this.id = client.getId() ;
        this.firstName = client.getFirstName() ;
        this.lastName = client.getLastName() ;
        for (Borrowing borrowing : client.getBorrowings()) {
            this.borrowings.add(new BorrowingDTO(borrowing)) ;
        }
    }
}
