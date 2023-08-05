package org.example.functional_programming.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    /***
     * A Predicate is a functional interface, which accepts an argument and returns a boolean.
     * Usually, it is used to apply in a filter for a collection of objects.
     */
    public static void main(String arg[])
    {
        String testCase2="0900000000";

        Predicate<String> predicate = phoneNumber ->
                phoneNumber.startsWith("07") && phoneNumber.length() ==11;

        Predicate<String> containsNumber9 = phoneNumber -> phoneNumber.contains("9");
        System.out.println(predicate.and(containsNumber9).test(testCase2));
        System.out.println(predicate.or(containsNumber9).test(testCase2));

    }

    static boolean isPhoneNumberValid(String phoneNumber)
    {
        return phoneNumber.startsWith("07") && phoneNumber.length() ==11;
    }
}
