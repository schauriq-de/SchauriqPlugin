package de.schauriq.schauriqplugin.scoreboard;

import de.schauriq.schauriqplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class MainScoreboard extends ScoreboardBuilder {

    public MainScoreboard(Player player) throws Exception {
        super(player, ChatColor.GREEN.toString() + ChatColor.BOLD + "By ju_dev");
        filterRangs();
    }

    @Override
    public void createScoreboard(){
        setScore(ChatColor.YELLOW.toString(), 10);
        setScore(ChatColor.YELLOW.toString() + ChatColor.BOLD  + "Spielername", 9);
        setScore(ChatColor.WHITE + "» " + player.getName(), 8);
        setScore(ChatColor.RED.toString(), 7);
        setScore(ChatColor.RED.toString() + ChatColor.BOLD  + "Dein Rang", 6);
        setScore(getRang().equals("Not found") ? "Not found" : getRang(), 5);
        setScore(ChatColor.BLUE.toString(), 4);
        setScore(ChatColor.BLUE.toString() + ChatColor.BOLD  + "Aktuelle Lobby", 3);
        setScore("» Soon....", 2);
        setScore(ChatColor.GRAY.toString(), 1);
        setScore(ChatColor.GREEN.toString() + ChatColor.BOLD + "schauriq.de", 0);
    }

    @Override
    public void update() {

    }

    List<String> filter = de.schauriq.schauriqplugin.Main.getPlugin(Main.class).getConfig().getStringList("filter");

    private void filterRangs() {
        for (String key : filter) {
            if (player.getName().toUpperCase().contains(key)) {
                player.setDisplayName(player.getDisplayName().toLowerCase().replace(key.toLowerCase(), " "));
            }
        }
    }

    private String getRang() {
        return "» Soon...";
    }
}