package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class Client extends Account {
    private double totalLateFees ;

    @OneToMany
    private List<Borrowing> borrowings ;

    public void payLateFees() {

    }

    public void returnDocument() {

    }

    public void borrowDocument(Borrowing borrowing) {
        borrowings.add(borrowing) ;
    }
}
