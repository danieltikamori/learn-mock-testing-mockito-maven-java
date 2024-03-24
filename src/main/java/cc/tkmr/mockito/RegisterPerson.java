/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import java.time.LocalDate;

public class RegisterPerson {

    private ApiPostOffice apiPostOffice;

    public RegisterPerson(final ApiPostOffice apiPostOffice) {
        this.apiPostOffice = apiPostOffice;
    }

    public Person registerPerson(String name, String document, LocalDate birthDate, String zipCode) {
        Person person = new Person(name, document, birthDate);
        LocationData locationData = apiPostOffice.searchBasedOnZipCode(zipCode);
        person.addAddressData(locationData);
        return person;
    }
}
