package org.example.functional_programming.optionals;

import java.util.Optional;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args)
    {
        String nullValue = null;
        Integer year = 2012;

        Optional<Integer> optionalYear = Optional.of(year);
        Optional<Integer> optionalNull = Optional.empty();

        System.out.println(optionalNull.filter(y -> y > 1979).isPresent());
        System.out.println(optionalYear.filter(y -> y > 1979).isPresent());
    }

    static class Person
    {
        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
}
