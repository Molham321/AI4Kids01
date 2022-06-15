package me.kodysimpson.myfirstplugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin implements Listener {

    @Override

    public void onEnable() {
        System.out.println("My first plugin has started!!! Hello!!!");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        event.setJoinMessage("Welcome to the server you big dummy!!");
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.setHealth(0.0);
        player.sendMessage("you left a bed!!! Dork");
    }

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent event){

        Player player = event.getPlayer();
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.SHEEP){
            player.sendMessage("This is a sheep. you can't do that.");
            event.setCancelled(true);

        } else {
            player.sendMessage("This is not a sheep.");
        }

    }
}