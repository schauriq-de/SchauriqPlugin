package de.schauriq.schauriqplugin.listener;

import de.schauriq.schauriqplugin.filter.BadWordFilter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        new BadWordFilter().filterMessages(event);
    }
}