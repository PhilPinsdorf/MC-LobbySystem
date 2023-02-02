package de.rexituz.lobbysystem;

import de.rexituz.lobbysystem.config.ConfigHandler;
import de.rexituz.lobbysystem.events.EventMaster;
import dev.derklaro.aerogel.Inject;
import dev.derklaro.aerogel.Singleton;
import eu.cloudnetservice.driver.permission.PermissionManagement;
import eu.cloudnetservice.ext.platforminject.api.PlatformEntrypoint;
import eu.cloudnetservice.ext.platforminject.api.stereotype.Dependency;
import eu.cloudnetservice.ext.platforminject.api.stereotype.PlatformPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

@Singleton
@PlatformPlugin(
        platform = "bukkit",
        name = "LobbySystem",
        version = "0.1",
        authors = "rexituz",
        pluginFileNames = "plugin.yml",
        api = "1.19",
        description = "A simple Lobby System plugin for the Game Night.",
        dependencies = @Dependency(name = "CloudNet-CloudPerms")
)

public final class LobbySystem implements PlatformEntrypoint {
    static LobbySystem instance;
    private final Plugin plugin;
    PermissionManagement permissionManagement;
    private final static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Lobby System" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;
    private Location spawn;

    @Inject
    private LobbySystem(
            @NonNull Plugin plugin,
            @NonNull PermissionManagement permissionManagement)
    {
        instance = this;
        this.plugin = plugin;
        this.permissionManagement = permissionManagement;
    }

    @Override
    public void onLoad() {
        instance = this;
        ConfigHandler.loadGames();
        EventMaster.registerEvents();
    }

    @Override
    public void onDisable() {}

    public static LobbySystem getInstance() {
        return instance;
    }

    public PermissionManagement getPermissionManagement() {
        return permissionManagement;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public Location getSpawn() {
        return spawn;
    }
}
