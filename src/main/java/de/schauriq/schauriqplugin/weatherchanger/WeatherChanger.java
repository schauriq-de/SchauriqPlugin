package de.schauriq.schauriqplugin.weatherchanger;

import org.bukkit.Bukkit;

public class WeatherChanger {

    public WeatherChanger() {
        new Thread(() -> {
            while(true) {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "weather clear");
                delay(450000);
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