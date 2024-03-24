/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

public class EmailSendingService {

    private SendingPlatform sendingPlatform;

    void sendEmail(String emailAddress, String message, boolean htmlFormat) {

        Email email = null;

        if(htmlFormat) {
           email = new Email(emailAddress, message, EnumFormat.HTML);
        } else {
           email = new Email(emailAddress, message, EnumFormat.TEXT);
        }
        sendingPlatform.sendEmail(email);
    }
}
