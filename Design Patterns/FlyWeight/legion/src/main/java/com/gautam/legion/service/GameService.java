package com.gautam.legion.service;

import com.gautam.legion.factory.NpcFactory;
import com.gautam.legion.model.NpcType;
import com.gautam.legion.model.Soldier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private final NpcFactory npcFactory;
    private final List<Soldier> army = new ArrayList<>();

    public GameService(NpcFactory npcFactory) {
        this.npcFactory = npcFactory;
    }

    public void createArmy() {
        // We will create 10 soldiers, but notice we only load assets TWICE.

        // 5 Orcs
        for (int i = 0; i < 5; i++) {
            // Ask Factory for the "Heavy" object
            NpcType orcType = npcFactory.getNpcType("Orc", "GreenSkin.png", "AxeSmash");
            // Create "Light" soldier with unique coordinates
            Soldier soldier = new Soldier(i * 10, i * 5, orcType);
            army.add(soldier);
        }

        // 5 Elves
        for (int i = 0; i < 5; i++) {
            NpcType elfType = npcFactory.getNpcType("Elf", "BlueSkin.png", "BowShot");
            Soldier soldier = new Soldier(i * 20, i * 10, elfType);
            army.add(soldier);
        }
    }

    public void renderArmy() {
        for (Soldier s : army) {
            s.spawn();
        }
    }
}