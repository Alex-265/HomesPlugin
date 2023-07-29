package at.alex.homes.commands;

import at.alex.homes.utils.FileHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DelHome implements CommandExecutor {
    FileHandler fileHandler = new FileHandler();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            fileHandler.RemoveLocation(player, args[0]);
            sender.sendMessage("Removed " + args[0]);
            return false;
        } else {
            sender.sendMessage("Please provide a Name");
            return true;
        }
    }
}
