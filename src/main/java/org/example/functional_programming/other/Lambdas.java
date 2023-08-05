package org.example.functional_programming.other;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas
{
    // Syntax sugar with Lambda
    public static void main(String[] args) {
        // one statement in the function, then not curly basces required
        Function<String, String> upperCaseNamev1 = val->val.toUpperCase();
        // or use method reference
        Function<String, String> upperCaseNamev2 = String::toUpperCase;

        // multi statement in the function then you need curly barces
        Function<String, String> upperCaseNameV3 = name ->{
            if (name.isBlank()) throw new IllegalArgumentException();
            return name.toUpperCase();
        };

        // Functional interfaces with two arguments requires brackets around the parameters
        BiFunction<String, Integer, String> upperCaseName = (name, age)-> name.toUpperCase();

        // Method reference - static function with a single parameter
        Consumer<String> printName = System.out::println;
    }
}
