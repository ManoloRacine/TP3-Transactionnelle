package com.manolo.tp3transactionnelle.DTO;

import com.manolo.tp3transactionnelle.model.Document;
import lombok.Data;

@Data
public class DocumentSimpleDTO {
    private long id ;
    private String type ;
    private String name ;
    private int nbAvailable ;

    public DocumentSimpleDTO(Document document) {
        this.id = document.getId() ;
        this.name = document.getName();
        this.type = document.getClass().getSimpleName();
        this.nbAvailable = document.getNbAvailable();
    }
}
