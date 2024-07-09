package com.juan.vanishplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender src, Command cmd, String s, String[] strings) {

        if(src instanceof Player) {
            Player player = ((Player) src).getPlayer();

            if (vanished.contains(player.getUniqueId())) {
                vanished.remove(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(player);
                }
                player.sendMessage(ChatColor.GREEN + "You are now unvanished!");
            } else {
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(player);
                }
                player.sendMessage(ChatColor.GREEN + "You are now unvanished!");
            }

        }

        return false;
    }
}
