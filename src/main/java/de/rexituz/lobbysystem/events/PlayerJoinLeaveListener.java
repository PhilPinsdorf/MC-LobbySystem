package de.rexituz.lobbysystem.events;

import de.rexituz.lobbysystem.LobbySystem;
import de.rexituz.lobbysystem.games.GameHandler;
import de.rexituz.lobbysystem.games.LobbyGame;
import de.rexituz.lobbysystem.inventory.InventoryHandler;
import de.rexituz.lobbysystem.player.PlayerHandler;
import de.rexituz.lobbysystem.scoreboard.ScoreboardHandler;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.teleport(LobbySystem.getInstance().getSpawn());
        player.setGameMode(GameMode.ADVENTURE);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        InventoryHandler.setPlayerInventory(player);
        player.setLevel(2023);
        player.setExp(0.999f);
        ScoreboardHandler.setScoreboard(player);
        player.sendTitle(ChatColor.GREEN + "Willkommen,", PlayerHandler.getPlayerColor(player) + player.getPlayerListName() + ChatColor.DARK_GRAY + "!", 10, 70, 20);

        String top = ChatColor.GRAY + "-------------------------------------------\n" + ChatColor.GREEN + "Willkommen auf dem Minecraft Server der Game Night!\n \n" + ChatColor.GRAY + "Aktuell bieten wir folgende Spiel-Modi an:\n";
        String games = "";
        String bottom = ChatColor.GREEN + "Viel Spaß!\n" + ChatColor.GRAY + "-------------------------------------------\n \n ";
        for (LobbyGame game : GameHandler.getLobbyGames()) {
            games += ChatColor.GRAY + " - " + game.getColor() + "" + ChatColor.BOLD + game.getName() + "\n";
        }
        games += " \n";
        player.sendMessage(top + games + bottom);

        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + event.getPlayer().getPlayerListName());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + event.getPlayer().getDisplayName());
    }
}
