package de.schauriq.schauriqplugin.listener;

import de.schauriq.schauriqplugin.scoreboard.MainScoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws Exception {
        new MainScoreboard(event.getPlayer());
    }
}