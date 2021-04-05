package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import org.bukkit.entity.Player;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by superblaubeere27 on 31.05.17.
 */
public class CopyPluginCommand implements ICommand {
    @Override
    public String getName() {
        return "copyPlugin";
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length > 1) {
            player.sendMessage(AAC.prefix + "§cUsage: *copyPlugin <newName>");
            return;
        }
        try {
            String newJar = args[1] + ".jar";
            File oldJar = new File(AAC.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            player.sendMessage(AAC.prefix + String.format("Current jar: %s newJar: %s", oldJar.getName(), newJar));
            File newFile = new File(oldJar.getParentFile(), newJar);
            Files.copy(oldJar.toPath(), newFile.toPath());
            player.sendMessage(AAC.prefix + "Copied");
        } catch (Exception e) {
            player.sendMessage(AAC.prefix + "§cERROR: " + e);
        }
    }
}
