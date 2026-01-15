package org.find9.purge.handlers;

import org.bukkit.Bukkit;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.find9.purge.Main.plugin;

public class PlayerCooldown {

    private static Map<UUID, Long> players = new HashMap<>();
    //private static JSONObject players = new JSONObject();

    public PlayerCooldown(){
        if(plugin.getDataFolder().exists()){
            try{
                File playersFile = new File(plugin.getDataFolder()+File.separator+"player_cooldown.ser");
                if(playersFile.exists()){
                    DataInputStream in = new DataInputStream(new FileInputStream(playersFile));

                    while(in.available() > 0){
                        byte[] b = new byte[in.readInt()];
                        in.read(b);

                        UUID key = UUID.fromString(new String(b));

                        long value = in.readLong();

                        players.put(key, value);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void setPlayerCooldown(UUID uuid){
        players.put(uuid, new Date().getTime());
        write();
    }

    public static long getPlayerCooldown(UUID uuid){
        if(players.containsKey(uuid)){
            return players.get(uuid);
        }
        return 0;
    }

    private static void write(){
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable(){
            @Override
            public void run(){
                try{
                    if(!plugin.getDataFolder().exists()){
                        plugin.getDataFolder().mkdirs();
                    }

                    /*
                    FileWriter out = new FileWriter(new File(plugin.getDataFolder()+File.separator+"player_cooldown.json"));
                    out.write(players.toString());
                    out.flush();
                    out.close();
                    */

                    DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(plugin.getDataFolder()+File.separator+"player_cooldown.ser")));

                    for(UUID key : players.keySet()){
                        byte[] b = key.toString().getBytes();
                        out.writeInt(b.length);
                        out.write(b);

                        out.writeLong(players.get(key));
                    }


                    //FileWriter out = new FileWriter(new File(plugin.getDataFolder()+File.separator+"players.json"));
                    //out.write(players.toString());
                    out.flush();
                    out.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
