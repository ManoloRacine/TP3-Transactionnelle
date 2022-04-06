package com.manolo.tp3transactionnelle.model;


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

}
