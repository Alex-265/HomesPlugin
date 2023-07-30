package at.alex.homes.commands;

import at.alex.homes.utils.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class adminDelHome implements CommandExecutor {
    FileHandler fileHandler = new FileHandler();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("modernhomes.admin.deleteotherhomes")) {
            sender.sendMessage("You dont have the required permissions!");
            return true;
        } else {
            if (args.length == 2) {
                try {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    String homename = args[1];
                    fileHandler.RemoveLocation(target, homename);
                    sender.sendMessage("Home " + homename + " removed from Player " + target.getName());
                    return false;
                } catch (Exception e) {
                    sender.sendMessage("Usage: /admindelhomes <Player> <Home>");
                    return true;
                }




            } else {
                sender.sendMessage("Usage: /admindelhomes <Player> <Home>");
                return true;
            }
        }
    }
}
