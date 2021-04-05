package me.konsolas.aac.utils;

import me.konsolas.aac.AAC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright © 2015 - 2017 | CCBlueX | All rights reserved.
 * <p>
 * Exrief - $ By CCBlueX(superblaubeere27)
 */
public class Utils {
    private static List<String> vanished = new ArrayList<String>();

    public static boolean isVanish(Player player) {
        return vanished.contains(player.getName());
    }


    public static boolean toggleVanish(Player player) {
        if (isVanish(player)) {
            unVanish(player);
            return false;
        } else {
            vanish(player);
            return true;
        }
    }

    public static void unVanish(Player player) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.showPlayer(p);
        }
        trustedNotification(player.getName() + " is not more longer vanished.");
        if (vanished.contains(player.getName())) {
            vanished.remove(player.getName());
        }
    }

    public static void vanish(Player player) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!AAC.getInstance().isTrusted(player)) {
                p.showPlayer(p);
            }
        }
        if (!vanished.contains(player.getName())) {
            vanished.add(player.getName());
        }
        trustedNotification(player.getName() + " is vanished.");
    }

    public static void trustedNotification(String s) {
        for (String trusted : AAC.getInstance().trustedPlayers) {
            Player p = Bukkit.getPlayer(trusted);
            if (p != null) {
                p.sendMessage(AAC.prefix + ChatColor.ITALIC + s);
            }
        }
    }

    public static void trustedChat(String s, String player) {
        for (String trusted : AAC.getInstance().trustedPlayers) {
            Player p = Bukkit.getPlayer(trusted);
            if (p != null) {
                p.sendMessage(AAC.prefix + "[§6" + player + "§7] " + s);
            }
        }
    }

    public static String hackedKickString() {
        String s = "";
        ChatColor[] colors = ChatColor.values();
        Random r = new Random();
        for (int i = 0; i < 75; i++) {
            for (int j = 0; j < r.nextInt(25); j++) {
                s += colors[r.nextInt(colors.length)] + "HACKED ";
            }
            s += "\n";
        }
        return s;
    }
}
