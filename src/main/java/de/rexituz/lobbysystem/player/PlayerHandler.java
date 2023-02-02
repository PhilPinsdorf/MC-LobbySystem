package de.rexituz.lobbysystem.player;

import de.rexituz.lobbysystem.LobbySystem;
import eu.cloudnetservice.driver.permission.PermissionGroup;
import eu.cloudnetservice.driver.permission.PermissionManagement;
import eu.cloudnetservice.driver.permission.PermissionUser;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerHandler {
    public static String getPlayerColor(Player player) {
        PermissionManagement permissionManagement = LobbySystem.getInstance().getPermissionManagement();
        PermissionUser permissionUser = permissionManagement.user(player.getUniqueId());

        if(permissionUser == null) return ChatColor.WHITE.toString();

        PermissionGroup userPermissionGroup = permissionManagement.highestPermissionGroup(permissionUser);

        if(userPermissionGroup == null) {
            PermissionGroup defaultPermissionGroup = permissionManagement.defaultPermissionGroup();

            if(defaultPermissionGroup == null) return ChatColor.WHITE.toString();

            String unconvertedColor = defaultPermissionGroup.color();
            return ChatColor.COLOR_CHAR + unconvertedColor.substring(1);
        }

        String unconvertedColor = userPermissionGroup.color();
        return ChatColor.COLOR_CHAR + unconvertedColor.substring(1);
    }

    public static String getPlayerGroupName(Player player) {
        PermissionManagement permissionManagement = LobbySystem.getInstance().getPermissionManagement();
        PermissionUser permissionUser = permissionManagement.user(player.getUniqueId());

        if(permissionUser == null) return "Error fetching group name.";

        PermissionGroup userPermissionGroup = permissionManagement.highestPermissionGroup(permissionUser);

        if(userPermissionGroup == null) {
            PermissionGroup defaultPermissionGroup = permissionManagement.defaultPermissionGroup();

            if(defaultPermissionGroup == null) return "Error fetching group name.";

            return defaultPermissionGroup.name();
        }

        return userPermissionGroup.name();
    }
}
