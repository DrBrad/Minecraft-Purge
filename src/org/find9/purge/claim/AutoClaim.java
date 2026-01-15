package org.find9.purge.claim;

import org.find9.purge.group.Group;

public class AutoClaim {

    private Group group;
    private boolean claiming;
    private String key;

    public AutoClaim(Group group, boolean claiming, String key){
        this.group = group;
        this.claiming = claiming;
        this.key = key;
    }

    public Group getGroup(){
        return group;
    }

    public boolean isClaiming(){
        return claiming;
    }

    public void setLastLocation(String key){
        this.key = key;
    }

    public String getLastLocation(){
        return key;
    }
}