package com.gautam.group_chat.mediator;

import com.gautam.group_chat.colleague.User;
import java.util.ArrayList;
import java.util.List;

public class GroupChat implements ChatMediator {

    private List<User> users;

    public GroupChat() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender) {
        for (User u : this.users) {
            // Don't send the message back to the person who sent it!
            if (u != sender) {
                u.receive(msg);
            }
        }
    }
}