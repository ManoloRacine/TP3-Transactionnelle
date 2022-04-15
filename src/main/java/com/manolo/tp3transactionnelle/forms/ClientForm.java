package com.manolo.tp3transactionnelle.forms;

import com.manolo.tp3transactionnelle.model.Client;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ClientForm {
    @NotNull
    @NotBlank
    @Size(max = 30)
    private String firstName ;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String lastName ;

    @Size(min = 10, max = 30)
    @NotNull
    @NotBlank
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
