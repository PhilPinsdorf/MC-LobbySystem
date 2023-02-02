package de.rexituz.lobbysystem.events;

import de.rexituz.lobbysystem.LobbySystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DisabledEventsListener implements Listener {
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        event.getPlayer().teleport(LobbySystem.getInstance().getSpawn());
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodLoose(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }
}
