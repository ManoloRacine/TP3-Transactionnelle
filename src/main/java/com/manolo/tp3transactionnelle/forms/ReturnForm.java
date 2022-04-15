package com.manolo.tp3transactionnelle.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnForm {
    @Min(1)
    private long borrowId ;
    @Min(1)
    private long clientId ;


}
