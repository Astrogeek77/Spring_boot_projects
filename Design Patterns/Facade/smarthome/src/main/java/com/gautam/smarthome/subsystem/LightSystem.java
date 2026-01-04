package com.gautam.smarthome.subsystem;

import org.springframework.stereotype.Component;

@Component
public class LightSystem {
    public void turnOn() {
        System.out.println("Lights are ON");
    }

    public void turnOff() {
        System.out.println("Lights are OFF");
    }

    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%");
    }
}