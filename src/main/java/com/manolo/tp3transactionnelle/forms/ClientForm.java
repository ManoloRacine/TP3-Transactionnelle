package com.manolo.tp3transactionnelle.forms;

import com.manolo.tp3transactionnelle.model.Client;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class ClientForm {
    private String firstName ;
    private String lastName ;
    private String password ;

    public ClientForm(String firstName, String lastName, String password) {
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.password = password ;
    }

    public ClientForm(Client client) {
        this(client.getFirstName(), client.getLastName(), client.getPassword());
    }

    public Client toClient() {
        return Client.builder().firstName(firstName).lastName(lastName).password(password).build() ;
    }

    public ClientForm() {

    }
}
