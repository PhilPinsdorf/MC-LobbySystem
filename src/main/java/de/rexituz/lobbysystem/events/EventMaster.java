package de.rexituz.lobbysystem.events;

import de.rexituz.lobbysystem.inventory.InventoryHandler;
import de.rexituz.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;

public class EventMaster {
    public static void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new DisabledEventsListener(), LobbySystem.getInstance().getPlugin());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), LobbySystem.getInstance().getPlugin());
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerMoveListener(), LobbySystem.getInstance().getPlugin());
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryHandler(), LobbySystem.getInstance().getPlugin());
    }
}
