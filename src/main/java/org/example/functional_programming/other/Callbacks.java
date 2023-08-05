package org.example.functional_programming.other;

import java.util.function.Consumer;

public class Callbacks {
    /**
     * Two different ways of implementing callbacks in Java.
     * This is similar to javascript
     */
    public static void main(String[] args) {
        hellov1("John", null,firstname -> System.out.println("no lastname provided for "+firstname));
    }

    static void hellov1(String firstName, String lastName, Consumer<String> callback)
    {
        System.out.println(firstName);
        if (lastName != null)
            System.out.println(lastName);
        else
            callback.accept(firstName);
    }

    static void hellov2(String firstName, String lastName, Runnable callback)
    {
        System.out.println(firstName);
        if (lastName != null)
            System.out.println(lastName);
        else
            callback.run();
    }

}
