/*
 * This class is a test class for the EmailSendingService class using Mockito for mocking objects.
 * The test method 'validateSentDataToPlatform' tests the functionality of sending an email by mocking the SendingPlatform object.
 */

package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmailSendingServiceTest {

    // Mock object for the sending platform to simulate email sending
    @Mock
    private SendingPlatform sendingPlatform;

    // The actual service class we are testing, where the mocked sending platform will be injected
    @InjectMocks
    private EmailSendingService emailSendingService;

    // ArgumentCaptor to capture the email object sent to the platform
    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validateSentDataToPlatform() {

        // Test data for the email
        String emailAddress = "user@example.com";
        String message = "Hello Mockito!";
        boolean isHtmlFormat = true; // true = HTML, false = TEXT

        // Call the method to send the email
        emailSendingService.sendEmail(emailAddress, message, isHtmlFormat);

        // Verify that the sendEmail method on the sending platform was called with the expected email
        Mockito.verify(sendingPlatform).sendEmail(captor.capture());

        // Get the captured email object
        Email capturedEmail = captor.getValue();

        // Assert that sent email matches the expected values
        assertEquals(emailAddress, capturedEmail.getEmailAddress());
        assertEquals(message, capturedEmail.getMessage());
        assertEquals(EnumFormat.TEXT, capturedEmail.getFormat());
    }
}