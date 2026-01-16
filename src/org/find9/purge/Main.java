package org.find9.purge;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.find9.purge.claim.ClaimHandler;
import org.find9.purge.group.GroupHandler;
import org.find9.purge.group.MyGroup;
import org.find9.purge.handlers.PlayerCooldown;
import org.find9.purge.handlers.PlayerResolver;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

import static org.find9.purge.Config.*;
import static org.find9.purge.group.GroupHandler.getPlayersGroup;
import static org.find9.purge.handlers.Colors.getChatColor;
import static org.find9.purge.handlers.MapHandler.isMapping;
import static org.find9.purge.handlers.MapHandler.stopMapping;

public class Main extends JavaPlugin {

    public static Plugin plugin;
    private int task;

    //Attempt player chunk loading not forceChunkLoad
    //add close to chat...

    @Override
    public void onLoad(){
        plugin = this;
    }

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new MyEventHandler(), this);
        getCommand("g").setExecutor(new GroupCommands());

        getCommand("warp").setExecutor(new MyCommands());
        getCommand("warps").setExecutor(new MyCommands());
        getCommand("setwarp").setExecutor(new MyCommands());
        getCommand("delwarp").setExecutor(new MyCommands());
        getCommand("home").setExecutor(new MyCommands());
        getCommand("sethome").setExecutor(new MyCommands());
        getCommand("spawn").setExecutor(new MyCommands());
        getCommand("setspawn").setExecutor(new MyCommands());
        getCommand("tpa").setExecutor(new MyCommands());
        getCommand("tpaa").setExecutor(new MyCommands());
        getCommand("tpad").setExecutor(new MyCommands());
        getCommand("msg").setExecutor(new MyCommands());
        getCommand("gamemode").setExecutor(new MyCommands());
        getCommand("back").setExecutor(new MyCommands());

        new Config();
        new GroupHandler();
        new ClaimHandler();
        new PlayerResolver();
        new PlayerCooldown();

        createRecipes();

        task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
            @Override
            public void run(){
                String[] names = getRanks();

                for(Player player : getPlayersAFK()){
                    MyGroup group = getPlayersGroup(player.getUniqueId());
                    if(group != null){
                        String color = getChatColor(group.getColor());
                        player.setPlayerListName("§6[§7AFK§6]§6["+color+group.getName()+"§6]["+color+names[group.getRank(player.getUniqueId())]+"§6]["+color+player.getName()+"§6]");

                    }else{
                        player.setPlayerListName("§6[§7AFK§6]§c"+player.getName());
                    }
                }
            }
        }, 200, 200);//100
    }

    @Override
    public void onDisable(){
        Bukkit.getServer().getScheduler().cancelTask(task);

        for(Player player : Bukkit.getOnlinePlayers()){
            if(isMapping(player.getUniqueId())){
                stopMapping(player);
            }
        }
    }

    private void createRecipes(){
        ShapedRecipe spawner = new ShapedRecipe(new ItemStack(Material.SPAWNER, 1));

        spawner.shape("NNN","NTN","NNN");

        spawner.setIngredient('N', Material.NETHERITE_INGOT);
        spawner.setIngredient('T', Material.TOTEM_OF_UNDYING);

        getServer().addRecipe(spawner);

        getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH));
    }

    public static boolean isPurge(){
        return ZonedDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
