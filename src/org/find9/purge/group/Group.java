package org.find9.purge.group;

import java.util.UUID;

public interface Group {

    boolean canClaim(UUID uuid);

    UUID getKey();

    String getName();

    int getType();

    int getColor();
}
