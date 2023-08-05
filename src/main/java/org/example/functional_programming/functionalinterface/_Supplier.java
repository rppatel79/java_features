package org.example.functional_programming.functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String args[])
    {
        Supplier<String> getDBConnectionFunction = ()->"jdbc://localhost:5432/user";

        System.out.println(getDBConnection());
        System.out.println(getDBConnectionFunction.get());
    }

    static String getDBConnection()
    {
        return "jdbc://localhost:5432/user";
    }
}
