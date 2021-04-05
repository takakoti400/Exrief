package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class VanishCommand implements ICommand {


    @Override
    public String getName() {
        return "vanish";
    }

    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage("§cExrief §7| Vanish: " + (Utils.toggleVanish(player) ? ChatColor.DARK_GREEN + "ON" : "§4OFF"));
    }
}