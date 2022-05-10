package de.schauriq.schauriqplugin.commands.groupCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Group implements CommandExecutor {

    private final List<String> messages = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("Only player can use this command!");
            return false;
        }

        fillMessagesList();

        Player player = (Player) sender;

        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            for (String msg : messages) {
                player.sendMessage(ChatColor.GREEN + msg);
            }
        }

        return false;
    }

    private void fillMessagesList() {
        messages.add(ChatColor.BOLD + "/group");
        messages.add(ChatColor.WHITE + " » Returns this view");
        messages.add(ChatColor.BOLD + "/group set [groupName] [permissions]");
        messages.add(ChatColor.WHITE + " » Creates a new group");
        messages.add(ChatColor.BOLD + "/group delete [groupName]");
        messages.add(ChatColor.WHITE + " » Deletes the group");
        messages.add(ChatColor.BOLD + "/group add [playerName] [groupName]");
        messages.add(ChatColor.WHITE + " » Adds player to group");
        messages.add(ChatColor.BOLD + "/group delete [playerName] [groupName]");
        messages.add(ChatColor.WHITE + " » Deletes the player from group");
    }
}
