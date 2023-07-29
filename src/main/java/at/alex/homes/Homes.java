package at.alex.homes;

import at.alex.homes.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Homes extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("home").setExecutor(new Home());
        getCommand("home").setTabCompleter(new HomeCompleter());
        getCommand("delhome").setExecutor(new DelHome());
        getCommand("delhome").setTabCompleter(new delhomeCompleter());
        getCommand("sethome").setExecutor(new SetHome());
        Bukkit.getLogger().info("Starting Homes Plugin");

    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Stopping Homes Plugins");
    }
}
