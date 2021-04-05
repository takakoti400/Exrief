package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Copyright © 2015 - 2017 | CCBlueX | All rights reserved.
 * <p>
 * Exrief - $ By CCBlueX(superblaubeere27)
 */
public class FakeKickCommand implements ICommand {


    @Override
    public String getName() {
        return "fakeKick";
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length < 1) {
            player.sendMessage(AAC.prefix + "§cToo few arguments. (.fakeKick <Player>)");
            return;
        }
        Player p = Bukkit.getPlayer(args[1]);
        if (p == null) {
            player.sendMessage(AAC.prefix + "§c'" + args[1] + "' is not online");
            return;
        }
        Bukkit.getScheduler().runTask(AAC.getInstance(), () -> {
            p.kickPlayer("§6AAC " + ChatColor.WHITE + ">§6 Suspicious activities in the basement");
            player.sendMessage("§cExrief §7| §cBye bye.");
        });
    }
}