package at.alex.homes.commands;

import at.alex.homes.utils.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class delhomeCompleter implements TabCompleter {
    FileHandler fileHandler = new FileHandler();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Bukkit.getLogger().info(fileHandler.GetHomes(player).toString());
        List<String> options = fileHandler.GetHomes(player);
        if (options.contains("default")) {
            options.remove("default");
        }
        return options;
    }
}
