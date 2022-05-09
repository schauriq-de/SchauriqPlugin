package de.schauriq.schauriqplugin;

import de.schauriq.schauriqplugin.listener.JoinListener;
import de.schauriq.schauriqplugin.weatherchanger.WeatherChanger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    FileConfiguration config = getConfig();
    List<String> filterList = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Schauriq plugin enabled...");

        config.addDefault("filter", filterList);
        config.options().copyDefaults(true);
        saveConfig();

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        new WeatherChanger();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Schauriq plugin disabled...");
    }
}