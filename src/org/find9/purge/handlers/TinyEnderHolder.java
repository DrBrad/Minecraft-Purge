package org.find9.purge.handlers;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.UUID;

public class TinyEnderHolder implements InventoryHolder {

    private final UUID owner;

    public TinyEnderHolder(UUID owner){
        this.owner = owner;
    }

    public UUID getOwner(){
        return owner;
    }

    @Override
    public Inventory getInventory(){
        return null;
    }
}
