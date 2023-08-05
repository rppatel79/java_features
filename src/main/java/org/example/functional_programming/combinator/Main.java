package org.example.functional_programming.combinator;

import java.time.LocalDate;

public class Main {
    public static void main(String arg[])
    {
        Customer customer = new Customer("Alice","alice@gmail.com",
                "+012341234",
                LocalDate.of(2000,1,1));

        // using combinator pattern
        CustomerRegistrationValidator customerRegistrationValidator=CustomerRegistrationValidator.validator;
        CustomerRegistrationValidator.ValidationResult result =customerRegistrationValidator.apply(customer);

        System.out.println(result);

    }
}
