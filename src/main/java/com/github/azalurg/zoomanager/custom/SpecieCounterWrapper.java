package com.github.azalurg.zoomanager.custom;

import com.github.azalurg.zoomanager.models.Specie;

import java.math.BigInteger;

public class SpecieCounterWrapper extends Counter {
    private Specie specie;
    public SpecieCounterWrapper(long id, BigInteger amount, Specie specie) {
        super(id, amount);
        this.specie = specie;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }
}
