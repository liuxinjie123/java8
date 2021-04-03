package com.java8.lambda;

import com.java8.service.parent.Child;
import com.java8.service.parent.ChildServiceImpl;
import com.java8.service.parent.Parent;
import com.java8.service.parent.ParentServiceImpl;

/**
 * 三定律
 *
 * 如果你对默认方法的工作原理，特别是在多继承下的行为没有把握，
 * 如下三条简单的定理可以帮助大家
 *
 * 1，类剩余接口。
 *    日光在继承链中有方法体或抽象的声明方法，那么就可以忽略接口中定义的方法了。
 *
 * 2，子类剩余父类
 *    如果一个接口继承了另一个接口，且两个接口都定义了同一个默认方法，那么子类中定义的方法胜出。
 *
 * 3，没有规则三。
 *    如果上面两条规则都不适用，子类要么实现该方法，要么将该方法声明为抽象方法。
 */
public class DefaultMethodTest {

    public static void main(String[] args) {
        Parent parent = new ParentServiceImpl();
        parent.welcome();
        Child child = new ChildServiceImpl();
        child.welcome();
    }
}
