package org.example.functional_programming.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult>
{
    private static CustomerRegistrationValidator isEmailValid()
    {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    private static CustomerRegistrationValidator isPhoneNumberValid()
    {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;

    }

    private static CustomerRegistrationValidator isAdult()
    {
        return customer ->
        {
            return Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                    ValidationResult.SUCCESS : ValidationResult.IS_NOT_ADULT;
        };
    }

    default CustomerRegistrationValidator add(final CustomerRegistrationValidator other)
    {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return ValidationResult.SUCCESS.equals(result) ? other.apply(customer) : result;
        };
    }

    public static CustomerRegistrationValidator validator = CustomerRegistrationValidator.isEmailValid()
        .add(CustomerRegistrationValidator.isPhoneNumberValid())
        .add(CustomerRegistrationValidator.isAdult());

    enum ValidationResult
    {
        SUCCESS,PHONE_NUMBER_NOT_VALID,EMAIL_NOT_VALID,IS_NOT_ADULT
    }
}
