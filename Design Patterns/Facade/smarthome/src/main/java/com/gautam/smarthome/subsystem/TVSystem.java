package com.gautam.smarthome.subsystem;

import org.springframework.stereotype.Component;

@Component
public class TVSystem {
    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }

    public void setInput(String input) {
        System.out.println("TV input set to: " + input);
    }

    public void setChannel(int channel) {
        System.out.println("TV channel set to: " + channel + " (News)");
    }
}