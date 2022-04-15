package com.manolo.tp3transactionnelle.forms;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BorrowForm {

    @Min(1)
    private int documentId ;
    @Min(1)
    private int clientId ;
    @Min(1)
    private int nbDays ;

    public BorrowForm() {

    }

    public BorrowForm(int documentId, int clientId, int nbDays) {
        this.documentId = documentId ;
        this.clientId = clientId ;
        this.nbDays = nbDays ;
    }
}
