package com.gautam.smarthome.facade;

import com.gautam.smarthome.subsystem.LightSystem;
import com.gautam.smarthome.subsystem.SoundSystem;
import com.gautam.smarthome.subsystem.TVSystem;
import org.springframework.stereotype.Service;

@Service
public class SmartHomeFacade {

    private final LightSystem lights;
    private final TVSystem tv;
    private final SoundSystem sound;

    // Constructor Injection
    public SmartHomeFacade(LightSystem lights, TVSystem tv, SoundSystem sound) {
        this.lights = lights;
        this.tv = tv;
        this.sound = sound;
    }

    public String watchMovieMode() {
        // The Facade handles the complex sequence
        System.out.println("--- Starting Movie Mode ---");
        lights.dim(10);
        tv.turnOn();
        tv.setInput("HDMI 1");
        sound.turnOn();
        sound.setVolume(25);
        System.out.println("--- Movie Mode Ready ---");

        return "Movie Mode Activated: Lights dimmed, TV on HDMI, Sound at 25.";
    }

    public String stopMovieMode() {
        System.out.println("--- Shutting Down Movie Mode ---");
        lights.turnOn(); // Bring lights back up
        tv.turnOff();
        sound.turnOff();

        return "Movie Mode Stopped: House restored to normal.";
    }

    public String goodMorningMode() {
        System.out.println("--- Starting Good Morning Mode ---");

        // 1. Wake up lights
        lights.turnOn();

        // 2. TV to News Channel
        tv.turnOn();
        tv.setChannel(100); // Assuming 100 is the news channel

        // 3. Low volume background noise
        sound.turnOn();
        sound.setVolume(10);

        System.out.println("--- Morning Routine Set ---");
        return "Good Morning! Lights are bright, News is on, Volume is low.";
    }
}