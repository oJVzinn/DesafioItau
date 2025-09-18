package com.github.ojvzinn.desafioitau.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class TransactionEntity {

    private Float value;
    private OffsetDateTime date;

}
