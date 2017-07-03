package com.demo1.day17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by whb on 2017/6/28.
 */
public class PredicateTest {
    public static void main(String[] args) {
        Collection books =new ArrayList();
        books.add("ads");
        books.add("ads1");
        books.add("ads2");
        System.out.println(callAll(books,ss->((String)ss).length()>3));
        System.out.println(books.stream().filter(a->((String)a).contains("1")).count());

    }
    public static int callAll(Collection books, Predicate p){
        int tall =0;
        for(Object book :books){
            if (p.test(book)){
                tall++;
            }
        }

        return tall ;
    }
}
