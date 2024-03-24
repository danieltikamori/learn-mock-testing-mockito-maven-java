/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SendMessageTest {

    // Create a mock object for SendMessage
    @Spy
    private SendMessage sendMessage;

    // Test the behavior of the SendMessage class
    @Test
    void verifyBehaviorOfSendMessage() {

        // Verify that there is no interaction with the sendMessage object
        Mockito.verifyNoInteractions(sendMessage);

        Message message = new Message("0","Hello Mockito!");
        sendMessage.addMessage(message);

        // Verify that the addMessage method was called on the sendMessage object
        Mockito.verify(sendMessage).addMessage(message);

        // Verify that the sendMessage object has at least one message
        assertFalse(sendMessage.getMessages().isEmpty());

    }
}
