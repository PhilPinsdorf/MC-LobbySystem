package de.rexituz.lobbysystem.events;

import de.rexituz.lobbysystem.LobbySystem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();

        if(loc.getBlockY() > 30) return;

        player.teleport(LobbySystem.getInstance().getSpawn());
    }
}
