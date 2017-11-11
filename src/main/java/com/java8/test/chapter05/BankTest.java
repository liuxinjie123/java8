package com.java8.test.chapter05;

import com.java8.model.bank.Trader;
import com.java8.model.bank.Transaction;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Comparator.comparing;

public class BankTest {
    public static final String CITY_CamBridge = "Cambridge";
    public static final String CITY_Milan = "Milan";

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", CITY_CamBridge, 20);
        Trader mario = new Trader("Mario", CITY_Milan, 22);
        Trader alan = new Trader("Alan", CITY_CamBridge, 30);
        Trader brain = new Trader("Brian", CITY_CamBridge, 28);
        //test01
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brain, 2011, BigDecimal.valueOf(3000)),
                new Transaction(raoul, 2012, BigDecimal.valueOf(1000)),
                new Transaction(raoul, 2011, BigDecimal.valueOf(4000)),
                new Transaction(mario, 2012, BigDecimal.valueOf(710)),
                new Transaction(mario, 2012, BigDecimal.valueOf(700)),
                new Transaction(alan, 2012, BigDecimal.valueOf(950))
        );


        System.out.println(" ---------------- 001 --------------- ");
        transactionList.stream()
                .filter(t -> t.getYear() == 2012)
                .sorted(comparing(Transaction::getAmount).reversed())
                .forEach(System.out::println);

        System.out.println(" ---------------- 002 --------------- ");
        transactionList.parallelStream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" ---------------- 003 --------------- ");
        transactionList.stream()
                .filter(t -> t.getTrader().getCity().equals(CITY_CamBridge))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println(" ---------------- 004 --------------- ");
        transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println(" ---------------- 004-01 --------------- ");
        String traderNameStr = transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println(" traderNameStr=" + traderNameStr);

        System.out.println(" ---------------- 005 --------------- ");
        transactionList.parallelStream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals(CITY_Milan))
                .distinct()
                .forEach(System.out::println);
        System.out.println(" ---------------- 005-01 --------------- ");
        boolean isExistWorkAtMilan = transactionList.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> t.getCity().equals(CITY_Milan));
        System.out.println(" isExistWorkAtMilan=" + isExistWorkAtMilan);

        System.out.println(" ---------------- 006 --------------- ");
        Optional<BigDecimal> sumAmount = transactionList.parallelStream()
                .filter(t -> t.getTrader().getCity().equals(CITY_CamBridge))
                .map(Transaction::getAmount)
                .reduce((a, b) -> a.add(b));
        System.out.println(" sumAmount=" + sumAmount.get());

        System.out.println(" ---------------- 007 --------------- ");
        Optional<BigDecimal> maxAmount = transactionList.parallelStream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal::max);
        System.out.println(" maxAmount=" + maxAmount.get());
        System.out.println(" ---------------- 007-01 --------------- ");
        Optional<Transaction> maxTransaction = transactionList.parallelStream()
                .max(comparing(Transaction::getAmount));
        System.out.println(" maxAmount2=" + maxTransaction.get().getAmount());

        System.out.println(" ---------------- 008 --------------- ");
        Optional<BigDecimal> minAmount = transactionList.parallelStream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal::min);
        System.out.println(" minAmount=" + minAmount.get());
        System.out.println(" ---------------- 008-01 --------------- ");
        Optional<Transaction> minTransaction = transactionList.parallelStream()
                .min(comparing(Transaction::getAmount));
        System.out.println(" minAmount2=" + minTransaction.get().getAmount());

        System.out.println(" ---------------- 009 --------------- ");
        int sumAge = transactionList.parallelStream()
                .map(Transaction::getTrader)
                .mapToInt(Trader::getAge)
                .sum();
        System.out.println(" sumAge=" + sumAge);
        OptionalDouble aveAge = transactionList.parallelStream()
                .map(Transaction::getTrader)
                .mapToInt(Trader::getAge)
                .average();
        System.out.println(" aveAge=" + aveAge.getAsDouble());
        OptionalInt maxAge = transactionList.parallelStream()
                .map(Transaction::getTrader)
                .mapToInt(Trader::getAge)
                .max();
        System.out.println(" maxAge=" + maxAge.getAsInt());
        OptionalInt minAge = transactionList.parallelStream()
                .map(Transaction::getTrader)
                .mapToInt(Trader::getAge)
                .min();
        System.out.println(" minAge=" + minAge.orElse(0));
    }
}
