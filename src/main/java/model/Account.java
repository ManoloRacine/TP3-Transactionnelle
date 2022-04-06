package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {
    @Id
    @GeneratedValue
    private long id ;

    protected String firstName ;
    protected String lastName ;
    protected String password ;

    @ManyToOne
    @PrimaryKeyJoinColumn
    protected Library myLibrary ;


}
