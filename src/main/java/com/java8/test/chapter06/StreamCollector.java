package com.java8.test.chapter06;

import com.java8.model.Dish;
import com.java8.model.Type;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamCollector {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("port", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH)
        );

        System.out.println(" \n------------------ 111 ---------------- ");
        Long howManyDishes = menu.stream().collect(counting());
        System.out.println(" howManyDishes=" + howManyDishes);

        System.out.println(" \n------------------ 222 ---------------- ");
        Long howManyDishes2 = menu.stream().count();
        System.out.println(" howManyDishes2=" + howManyDishes2);

        System.out.println(" \n------------------ 333 ---------------- ");
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(maxBy(dishComparator));
        System.out.println(" mostCalorieDish=" + mostCalorieDish.orElse(null));

        System.out.println(" \n------------------ 444 ---------------- ");
        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(" totalCalories=" + totalCalories);

        System.out.println(" \n------------------ 555 ---------------- ");
        int totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(" totalCalories2=" + totalCalories2);

        System.out.println(" \n------------------ 666 ---------------- ");
        OptionalDouble averageCalories = menu.stream().mapToInt(Dish::getCalories).average();
        System.out.println(" averageCalories=" + averageCalories.orElse(0));

        System.out.println(" \n------------------ 777 ---------------- ");
        Double averageCalories2 = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(" averageCalories2=" + averageCalories2);

        System.out.println(" \n------------------ 888 ---------------- ");
        IntSummaryStatistics menuStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(" IntSummaryStatistics:" +
                "\n count=" + menuStatistics.getCount() +
                "\n min=" + menuStatistics.getMin() +
                "\n max=" + menuStatistics.getMax() +
                "\n average=" + menuStatistics.getAverage() +
                "\n sum=" + menuStatistics.getSum() +
                "\n toString()=" + menuStatistics.toString()
        );

        System.out.println(" \n------------------ 999 ---------------- ");
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(" shortMenu=" + shortMenu);

        System.out.println(" \n------------------ 101010 ---------------- ");
        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(" shortMenu2=" + shortMenu2);

        System.out.println(" \n------------------ 111111 ---------------- ");
        String shortMenu3 = menu.stream().map(Dish::getName).collect(joining(",", "[", "]"));
        System.out.println(" shortMenu3=" + shortMenu3);
    }
}
