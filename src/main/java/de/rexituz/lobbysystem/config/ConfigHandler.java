package de.rexituz.lobbysystem.config;

import de.rexituz.lobbysystem.LobbySystem;
import de.rexituz.lobbysystem.games.GameHandler;
import de.rexituz.lobbysystem.games.LobbyGame;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class ConfigHandler {
    public static void loadGames() {
        Plugin plugin = LobbySystem.getInstance().getPlugin();

        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        Location spawn = config.getLocation("lobby.spawn");
        LobbySystem.getInstance().setSpawn(spawn);

        ConfigurationSection section = config.getConfigurationSection("lobby.games");

        if(section == null) {
            throw new IllegalArgumentException("Couldn't find lobby.games path in config file.");
        }

        Set<String> ids = section.getKeys(false);

        for(String id : ids) {
            String name = config.getString("lobby.games." + id + ".name");
            String color = config.getString("lobby.games." + id + ".color");
            Location location = config.getLocation("lobby.games." + id + ".position");
            Material material = Material.valueOf(config.getString("lobby.games." + id + ".material"));
            int slot = config.getInt("lobby.games." + id + ".slot");

            LobbyGame game = new LobbyGame(name, color, location, material, slot);
            GameHandler.addLobbyGame(game);
        }
    }
}
