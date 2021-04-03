package com.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationRunTest {
    @Test
    public void test001() {
        List<Integer> numbers = asList(1, 3, 66, 6, 9);
        List<Integer> sameOrder = numbers.stream().collect(toList());
        Assert.assertEquals(numbers, sameOrder);
        Assert.assertEquals(asList(9, 1, 3, 66, 6), sameOrder);
    }

}
