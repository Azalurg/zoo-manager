package com.github.azalurg.zoomanager.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Counter {
    private long id;
    private BigInteger amount;

    public Counter(BigInteger id, BigInteger amount) {
        this.id = id.longValue();
        this.amount = amount;
    }

    public Counter(long id, BigInteger amount) {
        this.id = id;
        this.amount = amount;
    }

    public void setId(BigInteger id) {
        this.id = id.longValue();
    }
}