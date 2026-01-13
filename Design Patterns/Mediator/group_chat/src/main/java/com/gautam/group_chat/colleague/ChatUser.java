package com.gautam.group_chat.colleague;

import com.gautam.group_chat.mediator.ChatMediator;

public class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        System.out.println("-----------------------------------");
        System.out.println(this.name + " Sending: " + msg);
        // CRITICAL: User asks Mediator to deliver the message
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " Received: " + msg);
    }
}