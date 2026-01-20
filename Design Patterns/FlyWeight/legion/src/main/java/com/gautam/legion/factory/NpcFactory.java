package com.gautam.legion.factory;

import com.gautam.legion.model.NpcType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NpcFactory {

    // The Cache (Pool of Flyweights)
    private static final Map<String, NpcType> cache = new HashMap<>();

    public NpcType getNpcType(String typeName, String texture, String combatSkill) {
        // The "Key" is usually the name or type
        NpcType result = cache.get(typeName);

        if (result == null) {
            // It doesn't exist? Create and Cache it.
            result = new NpcType(typeName, texture, combatSkill);
            cache.put(typeName, result);
        } else {
            // It exists? Return it (Memory Saved!)
            System.out.println("Cache Hit: Returning existing [" + typeName + "]");
        }

        return result;
    }
}
