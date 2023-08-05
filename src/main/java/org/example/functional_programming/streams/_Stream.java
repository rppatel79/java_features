package org.example.functional_programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _Stream {
    public static void main(String[] args)
    {
        // 1 - Integer Stream
        IntStream.range(1,10)
                .skip(5) //intermediate
                .forEach(System.out::print);//terminal
        //6789

        // 2 - sum
        System.out.println(IntStream.range(1,10)
                .skip(5) //intermediate
                .sum());//30

        Stream.of("Ava","Aseri","Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        //Alberto

        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)
                .filter(i->i.startsWith("S"))
                .sorted()
                .forEach(System.out::print);
        //SarahSarikaShivika
        System.out.println();

        // average of squares
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println);
        //44

        List<String> subSetOfNames=Stream.of("Jim","Jack","Peter","Ava","Stevo")
                .filter(x->x.length()>3)
                .sorted()
                .collect(Collectors.toList());
        subSetOfNames.forEach(System.out::print);
        //JackPeterStevo

    }
}
