package model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CD extends Document {
    private int nbMinutes ;

}
