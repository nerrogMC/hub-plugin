package net.nerrog.hubplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hub Plugin is loaded!");
        //コマンドの登録
        getCommand("hub").setExecutor(new CommandClass());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}

class CommandClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use it.");
            return true;
        }

        Player player = (Player) sender;

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(console, "mv tp "+player.getName()+" lobby");

        return true;
    }
}
