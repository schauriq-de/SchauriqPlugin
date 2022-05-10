package de.schauriq.schauriqplugin.scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MainScoreboard extends ScoreboardBuilder {

    public MainScoreboard(Player player) throws Exception {
        super(player, ChatColor.GREEN.toString() + ChatColor.BOLD + "By ju_dev");
    }

    @Override
    public void createScoreboard(){
        setScore(ChatColor.YELLOW.toString(), 10);
        setScore(ChatColor.YELLOW.toString() + ChatColor.BOLD  + "Spielername", 9);
        setScore(ChatColor.WHITE + "» " + player.getName(), 8);
        setScore(ChatColor.RED.toString(), 7);
        setScore(ChatColor.RED.toString() + ChatColor.BOLD  + "Dein Rang", 6);
        setScore(ChatColor.WHITE + "» Soon...", 5);
        setScore(ChatColor.BLUE.toString(), 4);
        setScore(ChatColor.BLUE.toString() + ChatColor.BOLD  + "Aktuelle Lobby", 3);
        setScore(ChatColor.WHITE + "» Soon....", 2);
        setScore(ChatColor.GRAY.toString(), 1);
        setScore(ChatColor.GREEN.toString() + ChatColor.BOLD + "schauriq.de", 0);
    }

    @Override
    public void update() {

    }
}