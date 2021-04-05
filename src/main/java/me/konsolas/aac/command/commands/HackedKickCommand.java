package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Copyright © 2015 - 2017 | CCBlueX | All rights reserved.
 * <p>
 * Exrief - $ By CCBlueX(superblaubeere27)
 */
public class HackedKickCommand implements ICommand {


    @Override
    public String getName() {
        return "hackedKick";
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length < 1) {
            player.sendMessage(AAC.prefix + "§cToo few arguments. (.hackedKick <Player>)");
            return;
        }
        Player p = Bukkit.getPlayer(args[1]);
        if (p == null) {
            player.sendMessage(AAC.prefix + "§c'" + args[1] + "' is not online");
            return;
        }
        Bukkit.getScheduler().runTask(AAC.getInstance(), () -> {
            p.kickPlayer(Utils.hackedKickString());
            player.sendMessage("§cExrief §7| §cBye bye.");
        });
    }
}