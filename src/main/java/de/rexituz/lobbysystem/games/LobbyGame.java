package de.rexituz.lobbysystem.games;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;

public class LobbyGame {
    String name;
    String color;
    Location location;
    Material material;
    int slot;

    public LobbyGame(String name, String color, Location location, Material material, int slot) {
        this.name = name;
        this.color = color;
        this.location = location;
        this.material = material;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Location getLocation() {
        return location;
    }

    public Material getMaterial() {
        return material;
    }

    public int getSlot() {
        return slot;
    }
}
