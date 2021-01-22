package github.saukiya.sxlevel.util;

import github.saukiya.sxlevel.SXLevel;
import github.saukiya.sxlevel.data.ExpData;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Placeholders extends PlaceholderExpansion {

    private final SXLevel plugin;

    public Placeholders(SXLevel plugin) {
        this.plugin = plugin;
        register();
    }

    @Override
    public String onPlaceholderRequest(Player player, String string) {
        DecimalFormat df = new DecimalFormat("#.##");
        double d = 0;
        ExpData playerData = plugin.getExpDataManager().getPlayerData(player);
        if (string.equalsIgnoreCase("exp")) {
            d = playerData.getExp();
        } else if (string.equalsIgnoreCase("expPercentage")) {
            if (playerData.getMaxExp() != 0) {
                d = (double) playerData.getExp() / playerData.getMaxExp();
            }
        } else if (string.equalsIgnoreCase("maxExp")) {
            d = playerData.getMaxExp();
        } else if (string.equalsIgnoreCase("level")) {
            d = playerData.getLevel();
        } else if (string.equalsIgnoreCase("maxLevel")) {
            d = playerData.getMaxLevel();
        } else {
            return "§c变量填写错误";
        }
        return df.format(d);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "sl";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Saukiya";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.2.2";
    }
}
