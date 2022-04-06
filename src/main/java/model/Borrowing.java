package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Borrowing {
    @Id
    @GeneratedValue
    public long id ;
    public LocalDateTime locationDate ;
    public LocalDateTime returnDate ;

    @OneToOne
    @PrimaryKeyJoinColumn
    public Document borrowedDocument ;
}
