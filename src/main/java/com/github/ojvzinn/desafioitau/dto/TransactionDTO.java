package com.github.ojvzinn.desafioitau.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class TransactionDTO {

    private Float value;
    private OffsetDateTime date;

}
