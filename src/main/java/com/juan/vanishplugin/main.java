package com.juan.vanishplugin;

import com.juan.vanishplugin.commands.VanishCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("vanish").setExecutor(new VanishCommand());
    }

}
