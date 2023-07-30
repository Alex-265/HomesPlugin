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

package at.alex.homes.utils;

import at.alex.homes.Homes;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public class FileHandler {
    Homes plugin = Homes.getPlugin(Homes.class);

    public void AddHome(String homename, Player player) {
        Location playerLocation = player.getLocation();
        plugin.getConfig().set("Homes." + player.getUniqueId() + "." + homename, playerLocation);
        plugin.saveConfig();
    }

    public String GetHomeFromNames(Player player, String homename) {
        try {
            Location locationhome = plugin.getConfig().getLocation("Homes." + player.getUniqueId() + "." + homename);
            return locationhome.toString();
        } catch (Exception e) {
            return "404";
        }
    }

    public Location GetLOCHomeFromNames(Player player, String homename) {
        Location locationhomes = plugin.getConfig().getLocation("Homes." + player.getUniqueId() + "." + homename);
        return locationhomes;
    }

    public void RemoveLocation(Player player, String homename) {
        plugin.getConfig().set("Homes." + player.getUniqueId() + "." + homename, null);
        plugin.saveConfig();
    }
    public List<String> GetHomes(Player player) {
        String playerUUID = player.getUniqueId().toString();
        ConfigurationSection homesSection = plugin.getConfig().getConfigurationSection("Homes." + playerUUID);
        Set<String> homeNames = homesSection.getKeys(false);
        return homeNames.stream().toList();
    }

}
