package com.manolo.tp3transactionnelle.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CD extends Document {
    private int nbMinutes ;

}
