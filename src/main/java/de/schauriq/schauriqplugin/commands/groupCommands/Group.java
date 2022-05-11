package de.schauriq.schauriqplugin.commands.groupCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Group implements CommandExecutor {

    private Player player;
    private final List<String> messages = new ArrayList<>();

    public Group() {
        fillMessagesList();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("Only player can use this command!");
            return false;
        }

        player = (Player) sender;

        switch (args[0]) {
            case "list":
                new GroupList(player);
                break;
            case "set":
                if (args.length == 2) {
                    new GroupSet();
                }
                break;
            case "delete":
                if (args.length == 1) {
                    new GroupDelete();
                }
                break;
            default:
                sendHelpMessage();
        }

        return false;
    }

    private void fillMessagesList() {
        messages.add(ChatColor.BOLD + "/group help");
        messages.add(ChatColor.WHITE + " » Returns this view");
        messages.add(ChatColor.BOLD + "/group set group [name] [permissions]");
        messages.add(ChatColor.WHITE + " » Creates a new group");
        messages.add(ChatColor.BOLD + "/group set player [player name] [group name]");
        messages.add(ChatColor.WHITE + " » Adds player to group");
        messages.add(ChatColor.BOLD + "/group delete group [name]");
        messages.add(ChatColor.WHITE + " » Deletes the group");
        messages.add(ChatColor.BOLD + "/group delete player [player name] [group name]");
        messages.add(ChatColor.WHITE + " » Deletes player from group");
    }

    private void sendHelpMessage() {
        for (String msg : messages) {
            player.sendMessage(ChatColor.GREEN + msg);
        }
    }
}