/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Goods.Armor;
import Interfaces.AttackSingle;
import Interfaces.Equipable;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public abstract class CombatableEntity extends Entity implements Cloneable, AttackSingle, Equipable{

    private long ATK;
    private long DEF;
    private long MATK;
    private long MDEF;
    private double ASPD;
    private double DSPD;
    private long strength;
    private long agile;
    private long wisdom;


    public CombatableEntity(String name) {
        super(name, 100);
        this.ATK = 1;
        this.ASPD = 1;
        this.DEF = 1;
        this.MATK = 1;
        this.MDEF = 1;
        this.strength = 1;
        this.agile = 1;
        this.wisdom = 1;

    }

    /**
     * @return the ATK
     */
    public long getATK() {
        return ATK;
    }

    /**
     * @param ATK the ATK to set
     */
    public void setATK(long ATK) {
        this.ATK = ATK;
    }

    /**
     * @return the DEF
     */
    public long getDEF() {
        return DEF;
    }

    /**
     * @param DEF the DEF to set
     */
    public void setDEF(long DEF) {
        this.DEF = DEF;
    }

    /**
     * @return the MATK
     */
    public long getMATK() {
        return MATK;
    }

    /**
     * @param MATK the MATK to set
     */
    public void setMATK(long MATK) {
        this.MATK = MATK;
    }

    /**
     * @return the MDEF
     */
    public long getMDEF() {
        return MDEF;
    }

    /**
     * @param MDEF the MDEF to set
     */
    public void setMDEF(long MDEF) {
        this.MDEF = MDEF;
    }

    /**
     * @return the ASPD
     */
    public double getASPD() {
        return ASPD;
    }

    /**
     * @param ASPD the ASPD to set
     */
    public void setASPD(double ASPD) {
        this.ASPD = ASPD;
    }

    /**
     * @return the DSPD
     */
    public double getDSPD() {
        return DSPD;
    }

    /**
     * @param DSPD the DSPD to set
     */
    public void setDSPD(double DSPD) {
        this.DSPD = DSPD;
    }

    /**
     * @return the strength
     */
    public long getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(long strength) {
        this.strength = strength;
    }

    /**
     * @return the agile
     */
    public long getAgile() {
        return agile;
    }

    /**
     * @param agile the agile to set
     */
    public void setAgile(long agile) {
        this.agile = agile;
    }

    /**
     * @return the wisdom
     */
    public long getWisdom() {
        return wisdom;
    }

    /**
     * @param wisdom the wisdom to set
     */
    public void setWisdom(long wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * @return the skills
     */
    
    @Override
    public int AttackSingle(CombatableEntity A, CombatableEntity B) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Equip(Armor armor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
