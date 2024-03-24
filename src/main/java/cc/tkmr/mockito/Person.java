/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

    private String name;

    private String document;

    private LocalDate birthDate;

    private LocationData personAddress;

    public Person(final String name, final String document, final LocalDate birthDate) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
    }

    public void addAddressData(LocationData locationData) {
        this.personAddress = locationData;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocationData getPersonAddress() {
        return personAddress;
    }

    public boolean isAdult() {
//        return birthDate.isBefore(LocalDate.now().minusYears(18));
        return ChronoUnit.YEARS.between(this.birthDate, LocalDate.now()) > 18L;
    }

}
