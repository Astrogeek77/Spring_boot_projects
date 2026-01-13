package com.gautam.group_chat.controller;

import com.gautam.group_chat.colleague.ChatUser;
import com.gautam.group_chat.colleague.User;
import com.gautam.group_chat.mediator.ChatMediator;
import com.gautam.group_chat.mediator.GroupChat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @GetMapping("/api/mediator/chat")
    public String demoMediator() {
        // 1. Create the Mediator (The Chat Room)
        ChatMediator chatRoom = new GroupChat();

        // 2. Create Users and pass the Mediator to them
        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");
        User user4 = new ChatUser(chatRoom, "Diana");

        // 3. Register Users to the Room
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        chatRoom.addUser(user4);

        // 4. Action: Alice sends a message
        // Alice doesn't know Bob or Charlie exist. She just tells the room.
        user1.send("Hello everyone! Is the meeting at 4?");

        // 5. Action: Charlie responds
        user3.send("Yes Alice, see you there.");

        return "Check Console Logs for Chat History";
    }
}
