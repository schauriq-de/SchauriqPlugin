package de.schauriq.schauriqplugin.weatherchanger;

import org.bukkit.Bukkit;

public class WeatherChanger {

    public WeatherChanger() {
        new Thread(() -> {
            while(true) {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "weather clear");
                delay(450000); // Refresh all  7.5 minutes
            }
        }).start();
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}