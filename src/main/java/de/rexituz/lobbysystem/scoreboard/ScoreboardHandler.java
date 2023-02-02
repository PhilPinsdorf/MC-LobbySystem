package de.rexituz.lobbysystem.scoreboard;

import de.rexituz.lobbysystem.player.PlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardHandler {
    public static void setScoreboard(Player player) {
        if(Bukkit.getScoreboardManager() == null) return;

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective sidebar = scoreboard.registerNewObjective("sidebar", Criteria.DUMMY, ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "24H" + ChatColor.WHITE + "" + ChatColor.BOLD + " Game Night");
        sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score groupLabel = sidebar.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + "Rang:");
        groupLabel.setScore(15);

        Score group = sidebar.getScore(ChatColor.DARK_GRAY + " » " + PlayerHandler.getPlayerColor(player) + PlayerHandler.getPlayerGroupName(player));
        group.setScore(14);

        player.setScoreboard(scoreboard);
    }
}
