package com.github.ojvzinn.desafioitau.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class TransactionDTO {

    @Min(value = 0)
    private Float valor;

    @Past
    private OffsetDateTime dataHora;

}
