package com.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationRunTest {
    @Test
    public void test001() {
        List<Integer> numbers = asList(1, 3, 66, 6, 9);
        List<Integer> sameOrder = numbers.stream().collect(toList());
        assertEquals(numbers, sameOrder);
        assertEquals(asList(9, 1, 3, 66, 6), sameOrder);
    }

    @Test
    public void testSort() {
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 1, 2));
        List<Integer> sameOrder = numbers.stream()
                .sorted()
                .collect(toList());
        assertEquals(asList(1, 2, 3, 4), sameOrder);
    }

    @Test
    public void testUnordered() {
        List<Integer> numbers = asList(1, 2, 3, 4);
        List<Integer> stillOrdered = numbers.stream()
                .map(x -> x+1)
                .collect(toList());
        // sorted
        assertEquals(asList(2, 3, 4, 5), stillOrdered);

        Set<Integer> unOrdered = new HashSet<>(numbers);
        List<Integer> stillUnOrdered = unOrdered.stream()
                .map(x -> x+1)
                .collect(toList());
        // 顺序得不到保证
        assertThat(stillUnOrdered, hasItem(2));
        assertThat(stillUnOrdered, hasItem(3));
        assertThat(stillUnOrdered, hasItem(4));
        assertThat(stillUnOrdered, hasItem(5));
//        assertThat(stillUnOrdered, hasItem(1));
    }

    @Test
    public void testForeach() {
        List<Integer> numbers = asList(1, 2, 3, 4);
        numbers.stream()
                .forEach(System.out::print);

        System.out.println();

        numbers.stream()
                .forEachOrdered(System.out::print);

        System.out.println();

        numbers.parallelStream()
                .forEach(System.out::print);

        System.out.println();

        numbers.parallelStream()
                .forEachOrdered(System.out::print);

        System.out.println();
    }

}
