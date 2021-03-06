package com.manolo.tp3transactionnelle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Document {
    @Id
    @GeneratedValue
    private long id ;
    private String name ;
    private String author ;
    private int releaseYear ;
    private int nbAvailable ;
    private String genre ;

}
