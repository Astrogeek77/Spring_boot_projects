package com.gautam.smarthome.subsystem;

import org.springframework.stereotype.Component;

@Component
public class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is ON");
    }

    public void turnOff() {
        System.out.println("Sound System is OFF");
    }

    public void setVolume(int level) {
        System.out.println("Sound volume set to: " + level);
    }
}