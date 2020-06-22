/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEvent;

import Entity.Player.Player;
import net.mamoe.mirai.contact.Group;
import gamerobot.GameRobot;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public abstract class GameEvent {

    private String message;
    private boolean isopen = true;
    private boolean open = true;
    private Map<Long, Boolean> permissions = new HashMap();

    public GameEvent(String message) {
        this.message = message;
        GameRobot.gameevents.put(message, this);
    }

    public void AddPermission(Player player) {
        if (!permissions.containsKey(Long.valueOf(player.getName()))) {
            getPermissions().put(Long.valueOf(player.getName()), Boolean.TRUE);
        }
    }

    public void RemvoePermission(Player player) {
        if (getPermissions().containsKey(Long.valueOf(player.getName()))) {
            getPermissions().put(Long.valueOf(player.getName()), Boolean.FALSE);
        }
    }

    public void Do(Player player) {

    }

    public void Do(Group group) {

    }

    public void Do(Player player, String message) {

    }

    public void Do(Group group, Player player) {

    }

    public void Do(Group group, String message) {

    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the permissions
     */
    public Map<Long, Boolean> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(Map<Long, Boolean> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return the isopen
     */
    public boolean isIsopen() {
        return isopen;
    }

    /**
     * @param isopen the isopen to set
     */
    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(boolean open) {
        this.open = open;
    }
}
