/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SendMessage {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }
}
