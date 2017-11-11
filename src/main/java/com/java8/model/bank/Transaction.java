package com.java8.model.bank;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Transaction implements Serializable {
    private Trader trader;
    private int year;
    private BigDecimal amount;

    public Transaction(Trader trader, int year, BigDecimal amount) {
        this.trader = trader;
        this.year = year;
        this.amount = amount;
    }
}
