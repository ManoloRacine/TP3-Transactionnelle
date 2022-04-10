package com.manolo.tp3transactionnelle.DTO;

import com.manolo.tp3transactionnelle.model.Borrowing;
import com.manolo.tp3transactionnelle.model.Client;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {
    private long id ;

    private String firstName ;
    private String lastName ;

    private List<Borrowing> borrowings = new ArrayList<>();

    public ClientDTO(Client client) {
        this.id = client.getId() ;
        this.firstName = client.getFirstName() ;
        this.lastName = client.getLastName() ;
    }
}
