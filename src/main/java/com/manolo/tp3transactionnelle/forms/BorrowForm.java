package com.manolo.tp3transactionnelle.forms;

import lombok.Data;

@Data
public class BorrowForm {
    private int documentId ;
    private int clientId ;
    private int nbDays ;

    public BorrowForm() {

    }

    public BorrowForm(int documentId, int clientId, int nbDays) {
        this.documentId = documentId ;
        this.clientId = clientId ;
        this.nbDays = nbDays ;
    }
}
