package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class ReloadCommand implements ICommand {

	@Override
	public String getName() {
		return "rl";
	}

	@Override
	public void execute(Player player, String[] args) {
		player.sendMessage(AAC.prefix + "Reloading...");
		List<String> trustedPlayers = AAC.getInstance().trustedPlayers;
		Bukkit.reload();
		player.sendMessage(AAC.prefix + "§aReloaded");
		AAC.getInstance().trustedPlayers = trustedPlayers;
	}

}
