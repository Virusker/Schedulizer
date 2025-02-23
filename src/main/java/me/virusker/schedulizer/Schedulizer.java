package me.virusker.schedulizer;

import me.virusker.schedulizer.commands.ScheduleCommand;
import me.virusker.schedulizer.config.PluginConfig;
import me.virusker.schedulizer.metrics.Metrics;
import me.virusker.schedulizer.timmer.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;

public final class Schedulizer extends JavaPlugin {

    @Override
    public void onEnable() {

        int pluginId = 24886;
        Metrics metrics = new Metrics(this, pluginId);

        // Plugin startup logic
        saveDefaultConfig();

        PluginConfig pluginConfig = new PluginConfig(this);

        // register the command
        getCommand("Schedulizer").setExecutor(new ScheduleCommand(pluginConfig));

        new BukkitRunnable(pluginConfig).runTaskTimer(this, 100, pluginConfig.getTick());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
