package com.gautam.group_chat.mediator;


import com.gautam.group_chat.colleague.User;

public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}