package com.gautam.legion.model;

public class Soldier {

    private int x;
    private int y;

    // Reference to the shared Flyweight
    private NpcType npcType;

    public Soldier(int x, int y, NpcType npcType) {
        this.x = x;
        this.y = y;
        this.npcType = npcType;
    }

    public void spawn() {
        // Delegate the heavy lifting to the Flyweight, passing unique data
        npcType.render(x, y);
    }
}
