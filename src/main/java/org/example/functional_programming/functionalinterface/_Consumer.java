package org.example.functional_programming.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main (String[] args)
    {
        Customer c = new Customer("Maria","99999");
        greetingCustomer(c);

        // funtional interface
        BiConsumer<Customer,Boolean> greetCustomerFunction = (customer, showPhoneNumber) ->System.out.println("Hello "+customer.customerName+", thanks for registering " +
                "phone number "+(showPhoneNumber ? customer.customerPhoneNumber : "*****"));
        greetCustomerFunction.accept(c,true);

    }


    static void greetingCustomer(Customer customer)
    {
        System.out.println("Hello "+customer.customerName+", thanks for registering " +
                "phone number "+customer.customerPhoneNumber);
    }

    static class Customer
    {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
