package de.schauriq.schauriqplugin.listener;

import de.schauriq.schauriqplugin.filter.BadWordFilter;
import de.schauriq.schauriqplugin.scoreboard.MainScoreboard;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws Exception {
        new BadWordFilter().filterPlayerNames(event.getPlayer());
        new MainScoreboard(event.getPlayer());

        if (!event.getPlayer().hasPlayedBefore()) {
            event.getPlayer().sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + "Willkommen " + event.getPlayer().getName() + " auf " + ChatColor.BOLD  + ChatColor.WHITE + "schauriq.de" + "!");
        }
        event.getPlayer().sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + "Willkommen zurück " + ChatColor.WHITE + ChatColor.BOLD + event.getPlayer().getName() + "!");
    }
}