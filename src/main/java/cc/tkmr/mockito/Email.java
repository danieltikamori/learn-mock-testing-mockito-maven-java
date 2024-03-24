/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

public class Email {

    private String emailAddress;

    private String message;

    private EnumFormat format;

    public Email(String emailAddress, String message, EnumFormat format) {
        this.emailAddress = emailAddress;
        this.message = message;
        this.format = format;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMessage() {
        return message;
    }

    public EnumFormat getFormat() {
        return format;
    }
}
