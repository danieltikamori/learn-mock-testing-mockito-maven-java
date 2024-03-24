/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

/*
 * This class is a test class for the RegisterPerson class. It uses Mockito for mocking objects.
 * The test method 'validateRegistrationData' tests the registration functionality by mocking the ApiPostOffice object.
 */

// Use MockitoExtension to enable Mockito annotations
@ExtendWith(MockitoExtension.class) // Use @Mock annotations
public class RegisterPersonTest {

    // Create a mock object for ApiPostOffice class
    @Mock
    // This mock object will be injected into the RegisterPerson class
    // when creating a new instance of it.
    // The mock object will be used to replace the actual ApiPostOffice class
    // during the testing process.
    // This will allow us to test the RegisterPerson class without depending on the actual ApiPostOffice class.

    private ApiPostOffice apiPostOffice;

    @InjectMocks // Inject the mock object into the RegisterPerson class. In this case, ApiPostOffice is injected into RegisterPerson.
    private RegisterPerson registerPerson;

    @Test
    void validateRegistrationData() {

        // Create a mock object for ApiPostOffice
        // The mock object will be injected into the RegisterPerson class
        // when creating a new instance of it.
        // The mock object will be used to replace the actual ApiPostOffice class
        // during the testing process.
        // This will allow us to test the RegisterPerson class without depending on the actual ApiPostOffice class.

        // Create a sample location data
        LocationData locationData = new LocationData("TX", "Houston", "Evergreen street", "Block A", "Happy district");

        // Mock the behavior of the ApiPostOffice object
        Mockito.when(apiPostOffice.searchBasedOnZipCode("123456789")).thenReturn(locationData);

        // Register a person with mock data
        Person person = registerPerson.registerPerson("Daniel", "1234567890", LocalDate.now(), "123456789");

        // Assertions to check the registration data
        assertEquals("Daniel", person.getName());
        assertEquals("1234567890", person.getDocument());
        assertEquals("TX", person.getPersonAddress().getState());
        assertEquals("Block A", person.getPersonAddress().getAddressComplement());
    }

}
