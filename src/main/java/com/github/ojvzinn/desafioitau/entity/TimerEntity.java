package com.github.ojvzinn.desafioitau.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimerEntity {

    private Long start;

    public Long getCurrentTime() {
        return System.currentTimeMillis() - start;
    }
}
