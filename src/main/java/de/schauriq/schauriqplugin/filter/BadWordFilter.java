package de.schauriq.schauriqplugin.filter;

import de.schauriq.schauriqplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BadWordFilter {

    public void filterMessages(AsyncPlayerChatEvent event) {
        for (String badWord : Main.getPlugin(Main.class).getConfig().getStringList("badWords")) {
            if (event.getMessage().toLowerCase().contains(badWord)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "Bitte teile uns nur schöne Sachen mit!");
            }
        }
    }

    public void filterPlayerNames(Player player) {
        for (String badWord : Main.getPlugin(Main.class).getConfig().getStringList("badWords")) {
            if (player.getName().toLowerCase().contains(badWord)) {
                player.setDisplayName(player.getName().replace(badWord, " "));
            }
        }
    }
}