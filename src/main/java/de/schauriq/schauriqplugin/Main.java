package de.schauriq.schauriqplugin;

import de.schauriq.schauriqplugin.listener.JoinListener;
import de.schauriq.schauriqplugin.weatherchanger.WeatherChanger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Schauriq plugin enabled...");

        // Set default paths to config.yml
        getConfig().addDefault("filter", new ArrayList<String>());
        getConfig().options().copyDefaults(true);
        saveConfig();

        // Register events, commands and Co.
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        new WeatherChanger();
    }

    @Override
    public void onDisable() {
        System.out.println("Schauriq plugin disabled...");
    }
}