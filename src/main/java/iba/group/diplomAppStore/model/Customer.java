package iba.group.diplomAppStore.model;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Customer {
    @NotNull
    @Size(min=2, message="Name must be at least 2 characters long")
    private String firstName;
    @NotNull
    @Size(min=2, message="Last name must be at least 2 characters long")
    private String lastName;
    @NotNull
    @Size(min=2, message="Street must be at least 2 characters long")
    private String street;
    @NotNull
    @Size(min=2, message="City must be at least 2 characters long")
    private String city;
    @NotNull
    @Size(min=2, message="State must be at least 2 characters long")
    private String state;
    @NotNull
    @Digits(integer = 6, fraction = 0, message="Invalid ZIP")
    private String zip;

}
