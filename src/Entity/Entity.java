package Entity;

import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public abstract class Entity {

    private String name;
    private long MAXHP;
    private long HP;
    private UUID uuid;

    public Entity(String name, long MAXHP) {
        this.name = name;
        this.MAXHP = MAXHP;
        this.HP = MAXHP;
        this.uuid = UUID.randomUUID();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the MAXHP
     */
    public long getMAXHP() {
        return MAXHP;
    }

    /**
     * @param MAXHP the MAXHP to set
     */
    public void setMAXHP(long MAXHP) {
        this.MAXHP = MAXHP;
    }

    /**
     * @return the HP
     */
    public long getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(long HP) {
        this.HP = HP;
    }

    /**
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
