package model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class Employee extends Account {

    public void createDocument() {

    }

    public void modifyDocument(Document document) {

    }

    public void addDocumentToLibrary(Document document) {
        myLibrary.getDocuments().add(document) ;
    }
}
