/*
 * Homes Plugin
 *     Copyright (C) <2023>  <Alex_265>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses>.
 */



package at.alex.homes.commands;

import at.alex.homes.utils.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Home implements CommandExecutor {
    FileHandler fileHandler = new FileHandler();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        /*
         Some shitty Method, to not have to fiddle around with a Conversion
         Don't Complain, make it better
        */


        Player player = (Player) sender;
        if (args.length == 1) {
            String response = fileHandler.GetHomeFromNames(player, args[0]);
            if (response.equals("404")) {
                sender.sendMessage(ChatColor.RED + "Home not Found!");
                return true;
            } else {
                Location loc = fileHandler.GetLOCHomeFromNames(player, args[0]);
                player.teleport(loc);
                sender.sendMessage(ChatColor.DARK_GREEN + "Teleported!");
                Bukkit.getLogger().info("Teleported " + player.getName() + " to " + response);
                return false;
            }
        } else if (args.length == 0) {
            String response = fileHandler.GetHomeFromNames(player, "default");
            if (response.equals("404")) {
                sender.sendMessage(ChatColor.RED + "Default Home not Found!");
                return true;
            } else {
                Location loc = fileHandler.GetLOCHomeFromNames(player, "default");
                player.teleport(loc);
                sender.sendMessage(ChatColor.DARK_GREEN + "Teleported to default Home!");
                Bukkit.getLogger().info("Teleported " + player.getName() + " to " + response);
                return false;
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Please provide a Name!");
            return true;
        }
    }
}
