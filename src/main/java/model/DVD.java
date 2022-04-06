package model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DVD extends Document {
    private int nbMinutes ;

}
