package at.alex.homes.commands;

import at.alex.homes.utils.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class adminDelHomeTabCompleter implements TabCompleter {
    FileHandler fileHandler = new FileHandler();
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            return null;
        } else if (args.length == 2) {
            if (fileHandler.GetHomes(Bukkit.getPlayer(args[0])).stream().toArray().length == 0) {
                return null;
            } else {
                return fileHandler.GetHomes(Bukkit.getPlayer(args[0]));
            }
        }
        return null;
    }
}
