package com.java8.test.chapter06;

import com.java8.enu.CaloricLevel;
import com.java8.enu.DEPT;
import com.java8.model.Dish;
import com.java8.enu.DishType;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamCollector {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("port", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH)
        );

        System.out.println(" \n------------------ 111 ---------------- ");
        Long howManyDishes = menu.stream().collect(counting());
        System.out.println(" howManyDishes=" + howManyDishes);

        System.out.println(" \n------------------ 222 ---------------- ");
        Long howManyDishes2 = menu.stream().count();
        System.out.println(" howManyDishes2=" + howManyDishes2);

        System.out.println(" \n------------------ 333 ---------------- ");
        Comparator<Dish> dishComparator = comparingInt(Dish::getCalories);

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

        System.out.println(" \n------------------ 121212 ---------------- ");
        int totalCalories3 = menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(" totalCalories3=" + totalCalories3);

        System.out.println(" \n------------------ 131313 ---------------- ");
        int maxCalories = menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::max));
        System.out.println(" maxCalories=" + maxCalories);

        System.out.println(" \n------------------ 141414 ---------------- ");
        int minCalories = menu.stream()
                .collect(reducing(1000, Dish::getCalories, Integer::min));
        System.out.println(" minCalories=" + minCalories);

        System.out.println(" \n------------------ 151515 ---------------- ");
        int totalCalories4 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(" totalCalories4=" + totalCalories4);

        System.out.println(" \n------------------ 161616 ---------------- ");
        String shortMenu4 = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + ", " + s2)).get();
        System.out.println(" shortMenu4=" + shortMenu4);

        System.out.println(" \n------------------ 171717 ---------------- ");
        String shortMenu5 = menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + ", " + s2));
        System.out.println(" shortMenu5=" + shortMenu5);

        System.out.println(" \n------------------ 181818 ---------------- ");
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() > 700) return CaloricLevel.FAT;
                    else return CaloricLevel.NORMAL;
                        }
                )
        );
        dishesByCaloricLevel.keySet().stream().forEach(System.out::println);
        dishesByCaloricLevel.values().stream().forEach(System.out::println);

        System.out.println(" \n------------------ 191919 ---------------- ");
        Map<DishType, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(
                        groupingBy(Dish::getDishType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() > 700) return CaloricLevel.FAT;
                                    else return CaloricLevel.NORMAL;
                                        }
                                ))
                );
        dishesByTypeCaloricLevel.keySet().stream().forEach(System.out::println);
        dishesByTypeCaloricLevel.values().stream().forEach(System.out::println);

        System.out.println(" \n------------------ 202020 ---------------- ");
        Map<DishType, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getDishType, counting())
        );
        System.out.println(typesCount);

        System.out.println(" \n------------------ 212121 ---------------- ");
        Map<DishType, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getDishType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        System.out.println(" \n------------------ 222222 ---------------- ");
        Map<DishType, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getDishType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType2);

        System.out.println(" \n------------------ 232323 ---------------- ");
        Map<DishType, Integer> totalCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getDishType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloricByType);

        System.out.println(" \n------------------ 242424 ---------------- ");
        Map<DishType, Set<CaloricLevel>> caloricLevelByType = menu.stream()
                .collect(groupingBy(Dish::getDishType, mapping(
                        dish -> {
                            if (dish.getCalories() < 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() > 700) return CaloricLevel.FAT;
                            else return CaloricLevel.NORMAL;
                        },
                        toSet()
                )));
        System.out.println(caloricLevelByType);

        System.out.println(" \n------------------ 252525 ---------------- ");
        Map<DishType, Set<CaloricLevel>> caloricLevelByType2 = menu.stream()
                .collect(groupingBy(Dish::getDishType,
                        mapping( dish -> {
                                    if (dish.getCalories() < 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() > 700) return CaloricLevel.FAT;
                                    else return CaloricLevel.NORMAL;
                                },
                                toCollection(HashSet::new)
                        )));
        System.out.println(caloricLevelByType2);

        System.out.println(" \n------------------ 262626 ---------------- ");
        Map<Boolean, List<Dish>> dishesByPartitioned = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(dishesByPartitioned);

        System.out.println(" \n------------------ 272727 ---------------- ");
        List<Dish> vegetarianDishList = menu.parallelStream()
                .filter(Dish::isVegetarian).collect(toList());
        vegetarianDishList.forEach(System.out::println);

        System.out.println(" \n------------------ 282828 ---------------- ");
        Map<Boolean, Map<DishType, List<Dish>>> vegetarianDishesByType = menu.parallelStream()
                .collect(
                        partitioningBy(Dish::isVegetarian, groupingBy(Dish::getDishType))
                );
        System.out.println(vegetarianDishesByType);

        System.out.println(" \n------------------ 292929 ---------------- ");
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.parallelStream()
                .collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);

        System.out.println(" \n------------------ 303030 ---------------- ");
        System.out.println(menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        partitioningBy(d -> d.getCalories() > 500))));

        System.out.println(" \n------------------ 313131 ---------------- ");
        Map<Boolean, Long> partitionCount = menu.parallelStream()
                .collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(partitionCount);

    }
}
