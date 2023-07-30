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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class adminListHome implements CommandExecutor {
    FileHandler fileHandler = new FileHandler();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("modernhomes.admin.listotherhomes")) {
            return true;
        } else {
            Player player = (Player) sender;
            List<String> Homes = fileHandler.GetHomes(player);
            String homesAsString = String.join(", ", Homes);
            homesAsString = homesAsString.substring(1, homesAsString.length() - 1);

            sender.sendMessage(player.getName() + " has Homes " + homesAsString);

        }

        return false;
    }
}
