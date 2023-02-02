package de.rexituz.lobbysystem.inventory;

import de.rexituz.lobbysystem.games.GameHandler;
import de.rexituz.lobbysystem.games.LobbyGame;
import de.rexituz.lobbysystem.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryHandler implements Listener {

    static String navigatorTitle = "Navigator";
    static ItemStack compass = ItemBuilder.getItem(ChatColor.GOLD + navigatorTitle, Material.COMPASS, 1);

    public static void setPlayerInventory(Player p){
        Inventory inv = p.getInventory();
        inv.clear();
        inv.setItem(4, compass);
    }

    public static Inventory getNavigatorInventory() {
        Inventory inv = Bukkit.createInventory(null, 5*9, ChatColor.GOLD + navigatorTitle);

        for(int i = 0; i < 5*9; i++) {
            inv.setItem(i, ItemBuilder.getItem( " ", Material.BLACK_STAINED_GLASS_PANE, 1));
        }

        for(LobbyGame game : GameHandler.getLobbyGames()) {
            inv.setItem(game.getSlot(), ItemBuilder.getItem(game.getColor() + "" + ChatColor.BOLD + game.getName(), game.getMaterial(), 1));
        }

        return inv;
    }

    @EventHandler
    private void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if(!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if(itemStack.getItemMeta() == null) return;

        if (itemStack.getType() == Material.COMPASS) {
            player.openInventory(getNavigatorInventory());
        }
    }

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        if (!(ChatColor.stripColor(event.getView().getTitle()).equals(navigatorTitle))) return;

        if (event.getCurrentItem() == null) return;
        Material material = event.getCurrentItem().getType();


        if(material == Material.BLACK_STAINED_GLASS_PANE || material == Material.COMPASS) return;

        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1 ,1);

        for(LobbyGame game : GameHandler.getLobbyGames()) {
            if(material == game.getMaterial()) {
                player.teleport(game.getLocation());
                break;
            }
        }

        player.closeInventory();
        player.updateInventory();
    }
}
