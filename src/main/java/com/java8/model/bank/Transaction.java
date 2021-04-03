package com.java8.model.bank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@Accessors(chain = true)
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
