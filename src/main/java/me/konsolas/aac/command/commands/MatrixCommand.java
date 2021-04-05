package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class MatrixCommand implements ICommand {
    
    public static boolean matrixEnabled;
    
    @Override
    public String getName() {
        return "matrix";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            if(args[1].equalsIgnoreCase("start")) {
                matrixEnabled = true;
                player.sendMessage("§cExrief §7| §cMatrix was enabled.");
                return;
            }

            if(args[1].equalsIgnoreCase("stop")) {
                matrixEnabled = false;
                player.sendMessage("§cExrief §7| §cMatrix was diabled.");
                return;
            }
        }
        player.sendMessage("§cExrief §7| §c*matrix <start/stop>");
    }
}