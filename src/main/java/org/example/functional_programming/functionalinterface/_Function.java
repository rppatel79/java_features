package org.example.functional_programming.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function
{
    public static void main(String[] args)
    {
        BiFunction<Integer,Integer,Integer> incrementBy1AndThenMultiByFunc = (num,multiBy)-> (num+1)*multiBy;
        System.out.println(incrementBy1AndThenMultiByFunc.apply(1,10)); //20
        System.out.println(incrementBy1AndThenMultiBy(1,10)); //20
    }


    static int incrementBy1AndThenMultiBy(int num,int multiBy)
    {
        return  (num+1)*multiBy;
    }
}
