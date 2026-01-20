package com.gautam.legion.model;

// This class represents the "Heavy" data.
// In a real app, 'texture' might be a huge byte array or 3D mesh.
public class NpcType {

    private final String typeName;  // e.g., "Orc"
    private final String texture;   // e.g., "orc_skin_v1.png" (Shared)
    private final String combatSkill; // e.g., "Smash"

    public NpcType(String typeName, String texture, String combatSkill) {
        this.typeName = typeName;
        this.texture = texture;
        this.combatSkill = combatSkill;
        // Simulate heavy memory usage delay
        System.out.println("Creation: Loading heavy assets for [" + typeName + "] into memory...");
    }

    // Method that takes EXTRINSIC (Unique) state as an argument
    public void render(int x, int y) {
        System.out.println("Rendering " + typeName + " at coordinates (" + x + "," + y + ") using texture " + texture);
    }
}
